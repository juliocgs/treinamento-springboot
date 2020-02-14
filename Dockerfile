FROM openjdk:8-jdk-alpine
COPY treinamento.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]