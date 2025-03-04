# Usa una imagen de Maven para compilar la aplicación
FROM maven:3.8.6-openjdk-17 AS build
WORKDIR /app

# Copia todo el código fuente
COPY . .

# Ejecuta Maven para compilar el WAR
RUN mvn clean package

# Usa una imagen de OpenJDK para ejecutar la aplicación
FROM maven:3.8.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copia el archivo WAR desde la etapa anterior
COPY --from=build /app/target/*.war app.war

# Expone el puerto 8080
EXPOSE 8080

# Ejecuta la aplicación
CMD ["java", "-jar", "app.war"]
