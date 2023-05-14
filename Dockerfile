FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY build/libs/meme-api-0.0.1-SNAPSHOT-plain.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
