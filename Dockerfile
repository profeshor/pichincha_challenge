FROM openjdk:17-jdk-alpine
COPY target/pichincha-0.0.1-SNAPSHOT.jar pichincha.jar
ENTRYPOINT [ "java" , "-jar", "pichincha.jar"]