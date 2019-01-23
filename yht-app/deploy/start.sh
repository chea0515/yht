#!/bin/sh
if [[ $# == 1 ]]; then
    if [[ -f ../conf/application.$1.yml ]]; then
        echo "use conf/application.$1.yml"
        cp ../conf/application.$1.yml ../conf/application.yml
    else
        echo "invalid parameter, no related conf: $1"
        exit 1
    fi
fi
# java8
export JUMBO_ROOT="/home/work/.jumbo"
source ${JUMBO_ROOT}/opt/sun-java8/sun-java8.sh
APPLICATION=yht-app.jar
SPRING_CONFIG_FILE=../conf/application.yml
ENDPOINT_CONFIG_FILE=file:../conf/endpoint.json
MAX_MEMORY=10240M
MAX_PERM_MEMORY=512M
INFO_LOG_FILE_PATH=../log/info/yht-app.info.log
ERROR_LOG_FILE_PATH=../log/error/yht-app.error.log
WARN_LOG_FILE_PATH=../log/warn/yht-app.warn.log
DEBUG_LOG_FILE_PATH=../log/debug/yht-app.debug.log
LOGBACK_FILE_PATH=../conf/logback.xml
nohup java -Dspring.config.location=$SPRING_CONFIG_FILE -Dendpoint.config=$ENDPOINT_CONFIG_FILE -Dfile.encoding=UTF-8 \
-Dlogging.config=$LOGBACK_FILE_PATH \
-Dlogging.info_log_file_path=$INFO_LOG_FILE_PATH -Dlogging.info_log_max_history_in_hours=24 \
-Dlogging.error_log_file_path=$ERROR_LOG_FILE_PATH -Dlogging.error_log_max_history_in_days=10 \
-Dlogging.warn_log_file_path=$WARN_LOG_FILE_PATH -Dlogging.warn_log_max_history_in_days=10 \
-Dlogging.debug_log_file_path=$DEBUG_LOG_FILE_PATH -Dlogging.debug_log_max_history_in_days=10 \
-Xmx$MAX_MEMORY -XX:MaxPermSize=$MAX_PERM_MEMORY -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps \
-Xloggc:gc.log -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=10 -XX:GCLogFileSize=20M -jar $APPLICATION > /dev/null 2>&1 &
echo "start done"
