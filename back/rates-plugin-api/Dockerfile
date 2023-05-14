FROM maven:3-jdk-11 as cache
WORKDIR /tmp
# 1. add pom.xml only here
COPY pom.xml .
# 2. start downloading dependencies
RUN mvn dependency:go-offline --fail-never -Dmaven.repo.local=/m2

FROM cache as build
WORKDIR /build
# 3. add all source code and start compiling
COPY --from=cache /m2 $HOME/.m2
# source code
COPY . .

RUN mvn install
RUN rm -rf *