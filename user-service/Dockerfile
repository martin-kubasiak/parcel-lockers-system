FROM openjdk:21
WORKDIR /app
EXPOSE 8080
COPY target/user-service.jar user-service.jar
ENTRYPOINT ["java", "-jar", "user-service.jar"]
