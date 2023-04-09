FROM openjdk:8-alpine

LABEL mantainer = "AlexanderStatkevich"

COPY /build/libs/*.jar app.jar

ENTRYPOINT ["java", "-Xmx200m", "-jar", "/app.jar"]

EXPOSE 8080 8089
