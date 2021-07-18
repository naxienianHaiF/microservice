#!/bin/bash
#初始化psid变量（全局）
psid=0

# shell 脚本文件路径
workdir=$(cd $(dirname $0); pwd)
echo "shell filepath: $workdir"

# 待启动的微服务名称
APPSERVER="eurekaserver"

# 检查微服务是否已经启动
function checkpid()
{
   echo "start check $APPSERVER service..."
   javaps=`$JAVA_HOME/bin/jps -l | grep $APPSERVER`
   echo $javaps
   if [ -n "$javaps" ]; then
      psid=`echo $javaps | awk '{print $1}'`
      echo "$APPSERVER service is running, psid is $psid"
   else
      echo "$APPSERVER not start..."
      psid=0
   fi
}

getpid() {
   javaps=`jps -l | grep $APPSERVER`
   if [ -n "$javaps" ]; then
      psid=`echo $javaps | awk '{print $1}'`
   else
      psid=0
   fi
}

#java虚拟机启动参数
JAVA_OPTS="-ms256m -mx256m -Xmn256m -Djava.awt.headless=true -XX:MaxPermSize=128m"

start() {
   checkpid

   if [ $psid -ne 0 ]; then
      echo "================================"
      echo "warn: $APPSERVER already started! (pid=$psid)"
      echo "================================"
   else
      echo -n "Starting $APPSERVERMAINCLASS ..."
      nohup java -jar $JAVA_OPTS $workdir/../eurekaserver-1.0.0-SNAPSHOT.jar > ../log/install.log  2>&1 &
      checkpid
      if [ $psid -ne 0 ]; then
         echo "(pid=$psid) [OK]"
      else
         echo "[Failed]"
      fi
   fi
}

# 停止微服务
stop() {
  echo "current psid is $psid"
  if [ $psid -ne 0 ]; then
      echo "================================"
      echo -n  "start stop $APPSERVER  service... psid is $psid"
      kill -9 $psid
  else
      echo "$APPSERVER service is stop..."
  fi

  sleep 2
  getpid
  if [ $psid -ne 0 ]; then
      echo -n "stop service is failed..."
  else
      echo "stop $APPSERVER service is success."
  fi
}

input="$1";
run() {
   echo "input content is $input"
   if [ "$input" = "checkpid" ]; then
      checkpid
   elif [ "$input" = "start" ]; then
      start
   elif [ "$input" = "stop" ]; then
      stop
   elif [ "$input" = "getpid" ]; then
      getpid
   else
      echo "invalid input parameter"
   fi
}

run

