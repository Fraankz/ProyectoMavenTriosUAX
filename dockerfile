# Usa la imagen oficial de OpenJDK 17
FROM openjdk:17-jdk-slim

# Configura el directorio de trabajo
WORKDIR /app

# Copia el archivo WAR generado por Maven
COPY target/*.war app.war

# Expone el puerto en el que correrá la app
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.war"]
