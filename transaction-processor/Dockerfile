FROM openjdk:8-jdk-alpine

RUN apk add --no-cache "su-exec>=0.2" "curl>=7.54.0"

RUN mkdir /transaction-processor/

COPY docker/* /transaction-processor/
COPY target/transaction-processor-*[0-9T].jar /transaction-processor/transaction-processor.jar

ENV HTTP_PORT 8080

EXPOSE ${HTTP_PORT}

HEALTHCHECK CMD curl -sSf http://localhost:8080/health || exit 1

WORKDIR /transaction-processor

ENTRYPOINT ["sh", "/transaction-processor/entrypoint.sh"]
