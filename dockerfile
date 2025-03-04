# Etapa de construcción (Build)
FROM maven:3.8.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copia el código fuente al contenedor
COPY . .

# Ejecuta Maven para compilar la aplicación
RUN mvn clean package

# Etapa de ejecución (Runtime)
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copia el WAR generado en la etapa de build
COPY --from=build /app/target/*.war app.war

# Expone el puerto 8080
EXPOSE 8080

# Ejecuta la aplicación
CMD ["java", "-jar", "app.war"]
