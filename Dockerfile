# -----------------------------------------------------------------
# ETAPA 1: BUILD (Construcción)
# Usa la imagen de Gradle para compilar y generar el JAR.
# -----------------------------------------------------------------
FROM gradle:8.6.0-jdk21 as builder

# Define el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia los archivos de configuración de Gradle y el código fuente
COPY build.gradle settings.gradle ./
COPY src ./src

# Otorga permisos de ejecución al script de Gradle wrapper
RUN chmod +x ./gradlew

# Ejecuta el build para generar el JAR ejecutable de Spring Boot.
# Usa '-x test' para omitir las pruebas y acelerar la construcción en Cloud Build.
RUN gradle bootJar --no-daemon -x test

# -----------------------------------------------------------------
# ETAPA 2: RUNTIME (Ejecución)
# Usa una imagen ligera con solo el JRE para la ejecución final.
# -----------------------------------------------------------------
FROM openjdk:21-jre-slim

# Define el puerto que escuchará la aplicación.
# Cloud Run inyecta la variable de entorno PORT (por defecto 8080).
ENV PORT 8080
EXPOSE ${PORT}

# Crea un volumen para la aplicación
WORKDIR /app

# Copia el JAR generado en la etapa de construcción
# El JAR se encuentra típicamente en build/libs/
COPY --from=builder /app/build/libs/*.jar /app/app.jar

# Configuración de inicio (Entrypoint)
# Inicia la aplicación Spring Boot.
# Se recomienda usar parámetros de memoria (ej. -Xmx) si tu aplicación es grande.
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
