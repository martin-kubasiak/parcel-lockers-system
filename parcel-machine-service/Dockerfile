FROM openjdk:21
WORKDIR /app
EXPOSE 8400
COPY target/parcel-machine-service.jar parcel-machine-service.jar
ENTRYPOINT ["java", "-jar", "parcel-machine-service.jar"]
