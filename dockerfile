# Etapa de construcción
FROM maven:3.8.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copia el código y descarga dependencias
COPY pom.xml .
RUN mvn dependency:go-offline
COPY . .
RUN mvn dependency:copy-dependencies
RUN mvn clean package

# Etapa de ejecución
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/dependency/webapp-runner.jar /app/webapp-runner.jar
COPY --from=build /app/target/*.war /app/app.war

EXPOSE 8080
