#!/bin/sh

JVM_PARAMETERS="-Dinst.id=1"
java ${JVM_PARAMETERS:-} \
    ${JAVA_OPTS:-} \
    ${JAVA_OPTS_DEBUG:-} \
    -XX:OnOutOfMemoryError='kill -9 %p' \
    -XX:+HeapDumpOnOutOfMemoryError \
    -XX:HeapDumpPath=/dumps/transaction-processor.bin \
    -jar /transaction-processor/transaction-processor.jar
