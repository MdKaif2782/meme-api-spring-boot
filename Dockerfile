FROM openjdk:17-jdk-slim

EXPOSE 8081

COPY build/libs/Random_meme_api-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
