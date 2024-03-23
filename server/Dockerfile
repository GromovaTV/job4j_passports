FROM eclipse-temurin:17.0.6_10-jre
WORKDIR /server
COPY target/*.jar /server/app.jar
ENTRYPOINT java -jar /server/app.jar