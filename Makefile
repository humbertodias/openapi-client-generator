CODEGEN_MAVEN_URL:=https://repo1.maven.org/maven2/io/swagger/codegen/v3/swagger-codegen-cli
CODEGEN_LATEST_VERSION:=$(shell curl -s ${CODEGEN_MAVEN_URL}/maven-metadata.xml | grep latest | cut -d ">" -f 2 | cut -d "<" -f 1)

version:
	@echo ${CODEGEN_LATEST_VERSION}
	@echo https://github.com/swagger-api/swagger-codegen/releases/tag/v${CODEGEN_LATEST_VERSION}

download:
	curl -o swagger-codegen-cli.jar ${CODEGEN_MAVEN_URL}/${CODEGEN_LATEST_VERSION}/swagger-codegen-cli-${CODEGEN_LATEST_VERSION}.jar

langs:
	java -jar swagger-codegen-cli.jar langs

help:
	java -jar swagger-codegen-cli.jar generate --help

config-help:
	java -jar swagger-codegen-cli.jar config-help --lang java

api-java:
	java -jar swagger-codegen-cli.jar generate \
    --input-spec rates-api.json \
    --output back/rates-cli-java-api \
    --config back/spring-cloud.json \
    --api-package com.company.rates.swagger.api \
    --model-package com.company.rates.swagger.model \
    --invoker-package com.company.rates.swagger.invoker \
    --lang spring \
    --library spring-cloud \
    --instantiation-types [date=LocalDate,date-time=LocalDateTime] \
    --import-mappings [LocalDate=java.time.LocalDate,LocalDateTime=java.time.LocalDateTime] \
    --group-id com.company \
    --artifact-id rates-cli-api \
    --artifact-version 0.0.1-SNAPSHOT \
    --verbose

api-ts:
	java -jar swagger-codegen-cli.jar generate \
    --input-spec rates-api.json \
    --output front/rates-cli-ts-api \
    --additional-properties=withSeparateModelsAndApi=true,modelPackage=models,apiPackage=api \
    --lang typescript-axios \
    --verbose

clean:
	cd back && mvn clean

package:	api-java
	cd back && MAVEN_OPTS="--add-opens=java.base/java.util=ALL-UNNAMED" mvn package

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
