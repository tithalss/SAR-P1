# Usando uma imagem base com OpenJDK 17
FROM eclipse-temurin:21-jdk-alpine

# Definindo o diretório de trabalho
WORKDIR /app

# Copiar o arquivo JAR do backend (depois de ter sido gerado pelo Gradle)
COPY build/libs/SAR-1.0-SNAPSHOT.jar app.jar

# Expor a porta 8080 para o backend
EXPOSE 8080

# Definir o comando para rodar a aplicação Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
