#!/bin/sh
if [ $# -eq 0 ] ; then
  mvn -Dspring.profiles.active=test clean package -U
else
  if [ $1 = "-q" ] ; then
    mvn -Dmaven.test.skip=true clean package -U
  else
    echo "build.sh [-q]"
    exit 0
  fi
fi

if [ $? -ne 0 ] ; then
  echo "mvn package error"
  exit -1
fi

rm -rf output
mkdir output

mkdir -p output/bin
mkdir -p output/conf
cp yht-app/target/yht-app-1.0-SNAPSHOT.jar output/bin/yht-app.jar
cp yht-app/deploy/start.sh output/bin
cp yht-app/deploy/stop.sh output/bin
