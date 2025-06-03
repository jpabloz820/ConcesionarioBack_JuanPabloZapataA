# Usa una imagen ligera de Java 17
FROM eclipse-temurin:17-jdk-alpine

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el .jar al contenedor
COPY target/ordenes-trabajo-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto del backend
EXPOSE 8080

# Comando para ejecutar la app
CMD ["java", "-jar", "app.jar"]
