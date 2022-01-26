FROM openjdk:11
WORKDIR /opt/hello-spring
COPY build/libs/demo-0.0.1-SNAPSHOT.jar ./
CMD java -jar demo-0.0.1-SNAPSHOT.jar

FROM openjdk:11-alpine
WORKDIR /opt/hello-spring
COPY --from=base/opt/hello-spring/build/libs/demo-0.0.1-SNAPSHOT.jar ./
CMD java -jar demo-0.0.1-SNAPSHOT.jar