#!/bin/bash

read -p "input function name: " command

commit(){
    read -p "input commit note: " note

    git add .
    git commit -m $note
    sha='git rev-parse HEAD'
}

merge(){
    git fetch;git rebase
    git branch $note
    git push origin $note
    git checkout $note
    git cherry-pick $sha
    git push
    git push --set-upstream origin $note
}

delete(){
    read -p "input brance name: " name

    git checkout master
    git push origin --delete $name
    git branch -D $name
}

push(){
    commit
    merge
}

case $command in
  (commit)
     commit
     ;;
  (merge)
     merge
     ;;
  (push)
     push
     ;;
  (delete)
     delete
     ;;
  (*)
     echo "Error command"
     echo "$usage"
     ;;
esac
