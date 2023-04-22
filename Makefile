CODEGEN_VERSION=$(shell curl -s https://repo1.maven.org/maven2/io/swagger/codegen/v3/swagger-codegen-cli/maven-metadata.xml | grep latest | cut -d ">" -f 2 | cut -d "<" -f 1)

version:
	@echo ${CODEGEN_VERSION}
	@echo https://github.com/swagger-api/swagger-codegen/releases/tag/v${CODEGEN_VERSION}

download:
	curl -o swagger-codegen-cli.jar https://repo1.maven.org/maven2/io/swagger/codegen/v3/swagger-codegen-cli/${CODEGEN_VERSION}/swagger-codegen-cli-${CODEGEN_VERSION}.jar

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
	rm -rf rates-cli-api
	mvn clean

package:	api
	mvn package
