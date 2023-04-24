CODEGEN_MAVEN_URL=https://repo1.maven.org/maven2/io/swagger/codegen/v3/swagger-codegen-cli
CODEGEN_LATEST_VERSION=$(shell curl -s $CODEGEN_MAVEN_URL/maven-metadata.xml | grep latest | cut -d ">" -f 2 | cut -d "<" -f 1)

version:
	@echo ${CODEGEN_LATEST_VERSION}
	@echo https://github.com/swagger-api/swagger-codegen/releases/tag/v${CODEGEN_LATEST_VERSION}

download:
	curl -o swagger-codegen-cli.jar $CODEGEN_MAVEN_URL/${CODEGEN_LATEST_VERSION}/swagger-codegen-cli-${CODEGEN_LATEST_VERSION}.jar

help:
	java -jar swagger-codegen-cli.jar generate --help

config-help:
	java -jar swagger-codegen-cli.jar config-help --lang java

api:
	java -jar swagger-codegen-cli.jar generate \
    --input-spec rates-api.json \
    --output rates-cli-api \
    --config spring-cloud.json \
    --lang spring \
    --library spring-cloud \
    --instantiation-types [date=LocalDate,date-time=LocalDateTime] \
    --import-mappings [LocalDate=java.time.LocalDate,LocalDateTime=java.time.LocalDateTime] \
    --verbose

clean:
	mvn clean

package:	api
	mvn package

build: package
	docker-compose build --parallel

network-rm:
	docker network ls --filter=name="openapi-*" -q | xargs -r docker network rm

run:
	docker-compose up

stop:
	docker-compose down -v

rmi:
	docker images --filter=reference="currency-*" -q | xargs -r docker rmi -f