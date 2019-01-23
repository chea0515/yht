#!/bin/sh
ROOT_PATH="$(readlink -f $(dirname $0))"
BIN_PATH=`cd $ROOT_PATH/../bin; pwd`
pids=`ps ux | grep "yht-app" | grep -v grep | grep -v stop.sh | cut -c 9-15`
for pid in $pids
do
    bin_dir=`readlink -f /proc/$pid/cwd`
    if [[ $bin_dir == $BIN_PATH ]]; then
        echo "kill $bin_dir"
        kill -9 $pid
    fi
done
echo "stop done"
