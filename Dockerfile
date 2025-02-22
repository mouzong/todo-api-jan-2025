FROM openjdk:17-jdk-slim

LABEL authors="andreas"
LABEL contact="andreasmouzong@gmail.com"

COPY target/todo-api.jar todo-api.jar

ENTRYPOINT ["java", "-jar", "todo-api.jar"]