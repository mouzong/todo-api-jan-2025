FROM openjdk:17-jdk-slim

LABEL authors="andreas"
LABEL contact="andreasmouzong@gmail.com"
LABEL version="v1.0"

COPY target/todo-api-v1.0.jar todo-api.jar

ENTRYPOINT ["java", "-jar", "todo-api.jar"]