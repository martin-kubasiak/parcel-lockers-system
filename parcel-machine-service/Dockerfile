FROM eclipse-temurin:21-jdk
WORKDIR /app
EXPOSE 8400
COPY target/parcel-machine-service.jar parcel-machine-service.jar
ENTRYPOINT ["java", "-jar", "parcel-machine-service.jar"]
