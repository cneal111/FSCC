FROM openjdk:8-jdk-alpine 
VOLUME /tmp 
# ARG JAR_FILE=target/*.jar
# COPY ${JAR_FILE} full-stack-coding-challenge.jar
COPY target/login-service-0.0.1-SNAPSHOT.jar login-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","login-service-0.0.1-SNAPSHOT.jar"]
EXPOSE 8081

# FROM openjdk:8-jdk-alpine
# ARG JAR_FILE=target/*.jar
# COPY ${JAR_FILE} app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]
# EXPOSE 8081