#/bin/bash

selfpath=$(cd "$(dirname "$0")"; pwd)
projecthome=$(cd "$(dirname "$selfpath/")"; pwd)

sh $projecthome/spartan-admin/spartan-admin-operator/deploy-ali-prod.sh
