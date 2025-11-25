FROM eclipse-temurin:21-jdk
WORKDIR /app
EXPOSE 8500
COPY target/parcel-service.jar parcel-service.jar
ENTRYPOINT ["java", "-jar", "parcel-service.jar"]
