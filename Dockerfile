FROM openjdk:8-jdk-alpine
VOLUME /roster
ARG JAR_FILE=backend/target/roster.jar
COPY ${JAR_FILE} roster.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/roster.jar"]