FROM openjdk:8-jdk-alpine

RUN mkdir integration-tests

COPY docker/ /

RUN mkdir /opt/integration-tests/lib

COPY "target/integration-tests-*[0-9T].jar" /opt/integration-tests/lib/integration-tests.jar

ENV LOG_LEVEL WARN
ENV ROOT_LOG_LEVEL ERROR

WORKDIR /opt/integration-tests

CMD ["/opt/integration-tests/bin/start.sh"]
