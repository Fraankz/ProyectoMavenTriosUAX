# Etapa de construcción (Build)
FROM maven:3.8.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copia el archivo pom.xml primero para aprovechar la caché de Docker
COPY pom.xml .

# Descarga las dependencias antes de copiar el código fuente completo
RUN mvn dependency:go-offline

# Ahora copia el resto del código fuente
COPY src/ src/

# Ejecuta Maven para compilar el WAR
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
