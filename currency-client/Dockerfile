#FROM maven:3-jdk-11 as build
#WORKDIR /build
#COPY . .
#RUN mvn package

FROM eclipse-temurin:11-jdk-focal as run
WORKDIR /run
ARG JAR_NAME=currency-client
#COPY --from=build /app/$JAR_NAME/target/$PROJECT_NAME-*-SNAPSHOT.jar /app/$JAR_NAME.jar
COPY target/currency-client-*-SNAPSHOT.jar /run/client.jar
CMD java -jar client.jar
