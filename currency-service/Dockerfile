FROM maven:3-jdk-11 as build
WORKDIR /build
COPY . .
RUN mvn package

FROM eclipse-temurin:11-jdk-focal as run
ARG JAR_NAME=currency-service
WORKDIR /run
COPY --from=build /build/target/$JAR_NAME-*.jar app.jar
ENV JAVA_OPTS="-Xms50M -Xmx1G"
CMD java $JAVA_OPTS -jar app.jar
EXPOSE 8006
HEALTHCHECK CMD curl --silent --fail --request GET http://localhost:8006/actuator/health | grep UP || exit 1