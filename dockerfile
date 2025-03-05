# Etapa de construcción (Build)
FROM maven:3.8.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copia el archivo pom.xml y descarga las dependencias antes de copiar el código fuente
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia el código fuente completo
COPY . .

# Verificar que pom.xml está en /app antes de compilar
RUN ls -l /app

# Ejecuta Maven para compilar el WAR
RUN mvn clean package

# Etapa de ejecución (Runtime)
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copia el WAR generado en la etapa de build
COPY --from=build /app/target/*.war app.war

# Expone el puerto 8080 para la aplicación
EXPOSE 8080

# Ejecuta la aplicación en Render
CMD ["java", "-jar", "app.war"]
