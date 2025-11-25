FROM eclipse-temurin:21-jdk
WORKDIR /app
EXPOSE 8300
COPY target/order-service.jar order-service.jar
ENTRYPOINT ["java", "-jar", "order-service.jar"]
