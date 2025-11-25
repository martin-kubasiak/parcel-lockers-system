FROM eclipse-temurin:21-jdk
WORKDIR /app
EXPOSE 8080
COPY target/user-service.jar user-service.jar
ENTRYPOINT ["java", "-jar", "user-service.jar"]
