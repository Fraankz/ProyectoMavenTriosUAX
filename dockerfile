# Etapa de construcción
FROM maven:3.8.6-eclipse-temurin-17 AS build

# Copia el código y descarga dependencias
COPY pom.xml .
RUN mvn dependency:go-offline
COPY . .
RUN mvn dependency:copy-dependencies
RUN mvn clean package

RUN ls -la /target/dependency/

# Etapa de ejecución
FROM openjdk:17-jdk-slim
COPY --from=build /target/dependency/webapp-runner.jar /webapp-runner.jar
COPY --from=build /target/*.war /app.war
