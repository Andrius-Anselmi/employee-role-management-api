## Usa a imagem oficial com OpenJDK (Java 17+ em geral)
#FROM eclipse-temurin:17-jdk
#
## Define o mantenedor da imagem
#LABEL maintainer="contato@java"
#
## Define o mantenedor da imagem
#WORKDIR app/
#
#
## Copia o JAR compilado para dentro do contêiner
#COPY target/Gerenciamento-0.0.1-SNAPSHOT.jar /app/java.jar
#
## Comando para executar o JAR
#ENTRYPOINT ["java", "-jar", "java.jar"]