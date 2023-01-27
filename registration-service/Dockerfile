FROM openjdk:8-jdk-alpine 
VOLUME /tmp   
COPY target/kafka-0.0.1-SNAPSHOT.jar kafka-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","kafka-0.0.1-SNAPSHOT.jar"]
EXPOSE 8083