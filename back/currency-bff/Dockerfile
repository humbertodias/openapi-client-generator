FROM maven:3-jdk-11 as build
WORKDIR /build
COPY . .
RUN mvn package

FROM eclipse-temurin:11-jdk-focal as run
WORKDIR /run
ARG JAR_NAME=currency-bff
COPY --from=build /app/$JAR_NAME/target/$PROJECT_NAME-*-SNAPSHOT.jar /app/$JAR_NAME.jar
#COPY target/currency-bff-*-SNAPSHOT.jar /run/bff.jar
CMD java -jar bff.jar
EXPOSE 8007
HEALTHCHECK CMD curl --silent --fail --request GET http://localhost:8007/actuator/health | grep UP || exit 1
