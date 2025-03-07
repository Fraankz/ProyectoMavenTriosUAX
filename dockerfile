# Etapa de construcción
FROM maven:3.8.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copia el código y descarga dependencias
COPY pom.xml .
RUN mvn dependency:go-offline
COPY . .
RUN mvn dependency:copy-dependencies
RUN mvn clean package

# Descarga manual de webapp-runner si no está en Maven Central
RUN curl -L -o target/dependency/webapp-runner.jar \
    https://repo1.maven.org/maven2/com/github/jsimone/webapp-runner/9.0.41.0/webapp-runner-9.0.41.0.jar || \
    echo "Failed to download webapp-runner.jar"

# Etapa de ejecución
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/dependency/webapp-runner.jar /app/webapp-runner.jar
COPY --from=build /app/target/*.war /app/app.war

EXPOSE 8080
CMD ["java", "-jar", "/app/webapp-runner.jar", "--port", "8080", "/app/app.war"]
