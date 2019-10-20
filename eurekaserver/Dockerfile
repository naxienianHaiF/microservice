FROM java:8
LABEL maintainer="1623631899@qq.com"
# MAINTAINER 1623631899@qq.com deprecated
ADD /target/eurekaserver-1.0.0-SNAPSHOT.jar eurekaserver-1.0.0-SNAPSHOT.jar
EXPOSE 8761/tcp
ENTRYPOINT ["java", "-jar", "/eurekaserver-1.0.0-SNAPSHOT.jar"]