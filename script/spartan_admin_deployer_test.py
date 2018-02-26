#!/usr/bin/python

import os
import sys
import ssh
import argparse
import traceback
from datetime import *

parser = argparse.ArgumentParser(description='Process some integers.')

parser.add_argument("-t", "--admin",
                  dest="admin", required=True,
                  help="absolute path of tz(admin) derectory")
parser.add_argument("-s", "--springboot",
                  dest="springboot", required=True,
                  help="absolute path of target springboot server, in remote pc")
parser.add_argument("-w", "--webapp",
                  dest="webapp", required=True,
                  help="webapp name of target web project, exclude filename suffix (.war).")
parser.add_argument("-p", "--project",
                  dest="project", required=True,
                  help="relative path of gradle project file, relative to tz(admin) directory")
parser.add_argument("-n", "--no-package",
                  dest="package", action='store_false',
                  help="if specified, target project won't be packaged. use existing package.")
parser.add_argument("-e", "--restart-only",
                  dest="restartonly", action='store_true', default=False,
                  help="if specified, remote springboot will be restarted.")
parser.add_argument("-r", "--profile",
                  dest="profile",
                  help="profile for gradle building")
parser.add_argument("--host",
                  dest="host", required=True,
                  help="address of remote host")
parser.add_argument("-o", "--port",
                  dest="port", type=int, default=22,
                  help="port of remote ssh service")
parser.add_argument("-u", "--username",
                  dest="username", required=True,
                  help="username of remote host")
parser.add_argument("-a", "--password",
                  dest="password", required=True,
                  help="password of remote user")
parser.add_argument("-b", "--rollback",
                  dest="rollback", action='store_true', default=False,
                  help="rollback to last version")
parser.add_argument("-v", "--version",
                  dest="version", required=False,
                  help="version of code")
parser.add_argument("--not-clean",
                  dest="notclean", action='store_true', default=False,
                  help="do not clean projects")
parser.add_argument("--no-monitor",
                  dest="nomonitor", action='store_true', default=False,
                  help="do not check springboot startup log")
parser.add_argument("--platform",
                  dest="platform", required=False,
                  help="platform argument for gradle script.")
parser.add_argument("--not-refresh-dependencies",
                  dest="not_refresh_dependencies", required=False,
                  help="do not use '--refresh-dependencies', when execute gradle.")
parser.add_argument("-c",
                  dest="settings", required=False,
                  help="see also gradle -c")


deploy_history = 'd:/tmp/deploy_history' if os.name =='nt' else "/var/tmp/deploy_history"
if os.path.isdir(deploy_history):
    pass
else:
    os.makedirs(deploy_history)
    print "create dir %s" % deploy_history

args = parser.parse_args()

placeholders = {
        'admin':args.admin,
        'springboot':args.springboot,
        'webapp':args.webapp,
        'project':args.project
       }

client = ssh.SSHClient()
client.set_missing_host_key_policy(ssh.AutoAddPolicy())
client.connect(args.host, port=args.port, username=args.username, password=args.password)
sftp = client.open_sftp()

FILE_DIR = ('%(springboot)s/%(webapp)s' % placeholders)

def coloration(s, color):
    return "\033[0;" + color + "m" + str(s) + "\033[0m"

def green(s):
    return coloration(s, "32")

def purple(s):
    return coloration(s, "35")

def localCmd(cmd):
    print green('==>') + ' executing "' + purple(cmd) + '"'
    os.system(cmd)

def sshExec(cmd):
    print green('==>') + ' executing "' + purple(cmd) + '"'
    return client.exec_command(cmd)

def sshCmd(cmd, ignoreError = False):
    stdin, stdout, stderr = sshExec(cmd)
    #line = stdout.readline()
    #while len(line) > 0:
    #    print line,
    #    line = stdout.readline()
    errInfo = stderr.read()
    if len(errInfo) > 0:
        print 'execute cmd failed => ' + errInfo
        if not ignoreError:
            sys.exit(1)

if os.path.exists(FILE_DIR):
    print 'dir exists'
else:
    print 'dir not exists'
    sshCmd('mkdir -p %(springboot)s/%(webapp)s' % placeholders)

def sshRun(cmd):
    stdin, stdout, stderr = sshExec(cmd)
    if len(stderr.read()) > 0:
        sys.exit('execute cmd failed.')
    return stdout.read()

def transfer(target, dest):
    print green('==>') + ' scp ' + purple(target) + ' --> ' + purple(dest)
    sftp.put(target, dest)

def package():
    if args.version is not None:
        placeholders['version'] = args.version
        localCmd('git checkout %(version)s' % placeholders)
        localCmd('echo "%(version)s" > %(admin)s/%(project)s/src/main/webapp/version' % placeholders)
    else:
        localCmd('git tag --contains=HEAD > %(admin)s/%(project)s/src/main/webapp/version' % placeholders)
    cmd = 'cd %(admin)s/%(project)s/;gradle build' % placeholders
    localCmd(cmd)
    localCmd('test -f %(admin)s/%(project)s/src/main/webapp/version && rm %(admin)s/%(project)s/src/main/webapp/version' % placeholders)

def upload():
    transfer('%(admin)s/%(project)s/target/libs/%(webapp)s.war' % placeholders, '/tmp/%(webapp)s.war' % placeholders)

def stop_springboot():
    try:
        pid = sshRun("ps aux|grep %(webapp)s |grep -v 'grep'|awk '{print $2}' | xargs -l kill -9" % placeholders).strip()
    except:
        print "remote server is not started."

def replace_war():
    placeholders["datetimestr"] = datetime.now().strftime("%Y%m%d_%H%M%S")
    latest_version = "%(webapp)s_" % placeholders + "%(datetimestr)s.war" % placeholders
    os.chdir(deploy_history)
    if os.path.isfile("%(webapp)s_latest" % placeholders):
        if os.path.isfile("%(webapp)s_rollback" % placeholders):
            os.remove("%(webapp)s_rollback" % placeholders)
        os.rename("%(webapp)s_latest" % placeholders, "%(webapp)s_rollback" % placeholders)
    f_latest = open("%(webapp)s_latest" % placeholders, 'w')
    f_latest.write(latest_version)
    f_latest.close()
    sshCmd('test -f %(springboot)s/%(webapp)s/%(webapp)s.war && mv %(springboot)s/%(webapp)s/%(webapp)s.war ~/%(webapp)s_%(datetimestr)s.war' % placeholders, True)
    sshCmd('rm -rf %(springboot)s/%(webapp)s/%(webapp)s*' % placeholders)
    sshCmd('cp /tmp/%(webapp)s.war %(springboot)s/%(webapp)s/%(webapp)s.war' % placeholders)

def rollback():
    os.chdir(deploy_history)
    if os.path.isfile("%(webapp)s_rollback" % placeholders):
        f_rollback = open("%(webapp)s_rollback" % placeholders, 'r')
        placeholders["rollback"] = f_rollback.readline()
        f_rollback.close()
        stop_springboot()
        sshCmd('rm -rf %(springboot)s/%(webapp)s/%(webapp)s*' % placeholders)
        sshCmd('mv ~/%(rollback)s %(springboot)s/%(webapp)s/%(webapp)s.war' % placeholders, True)
        start_springboot()
        os.rename("%(webapp)s_rollback" % placeholders, "%(webapp)s_latest" % placeholders)
    else:
        print "no last version to rollback for %(webapp)s" % placeholders

def start_springboot():
    #sshCmd('%(tomcat)s/bin/startup.sh' % placeholders)
    sshCmd('nohup java -jar %(springboot)s/%(webapp)s/%(webapp)s.war > %(springboot)s/%(webapp)s/nohup.out 2>&1 &' % placeholders)
    print green('==> starting springboot ...')
    if args.nomonitor:
        return
    #stdin, stdout, stderr = sshExec('tail -f -n 0 %(springboot)s/logs/catalina.out' % placeholders)
    #line = stdout.readline()
    #while len(line) > 0:
    #    print line,
    #    if 'INFO: Server startup in ' in line:
    #       break
    #   line = stdout.readline()

if args.restartonly:
    stop_springboot()
    sshCmd('rm -rf %(springboot)s/%(webapp)s/%(webapp)s' % placeholders)
    start_springboot()
    sys.exit(1)
elif args.rollback:
    rollback()
else:
    try:
        if args.package:
            package()
        upload()
        stop_springboot()
        replace_war()
        start_springboot()
        loginfo = "deployed [%s] in profile [%s], at %s\n" % (args.project, args.profile,  datetime.now().strftime("%Y/%m/%d_%H:%M"))
    except:
        print traceback.format_exc()
        loginfo = "!!! deploy failed [%s] in profile [%s], at %s\n" % (args.project, args.profile,  datetime.now().strftime("%Y/%m/%d_%H:%M"))

    # write log
    # windows check
    logPath = 'd:/tmp/admin-auto-deploy.log' if os.name == 'nt' else '/var/tmp/admin-auto-deploy.log';
    log = open(logPath,'a')
    log.write(loginfo)
    log.close()



