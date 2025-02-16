FROM openjdk:17-jdk-slim

LABEL authors="andreas"

COPY target/todo-api.jar todo-api.jar

ENTRYPOINT ["java", "-jar", "todo-api.jar"]