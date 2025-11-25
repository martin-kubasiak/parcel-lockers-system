FROM eclipse-temurin:21-jdk
WORKDIR /app
EXPOSE 8200
COPY target/notification-service.jar notification-service.jar
ENTRYPOINT ["java", "-jar", "notification-service.jar"]
