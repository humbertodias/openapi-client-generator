FROM hldtux/maven-rates-plugin-api as build
WORKDIR /build
COPY . .
RUN mvn package

FROM eclipse-temurin:11-jdk-focal as run
ARG JAR_NAME=currency-bff
WORKDIR /run
COPY --from=build /build/target/$JAR_NAME-*.jar app.jar
CMD java -jar bff.jar
EXPOSE 8007
HEALTHCHECK CMD curl --silent --fail --request GET http://localhost:8007/actuator/health | grep UP || exit 1
