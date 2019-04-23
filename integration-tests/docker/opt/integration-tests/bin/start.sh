#!/bin/sh

exec java ${JAVA_OPTIONS} \
    -Dlog.level="${LOG_LEVEL}" \
    -Droot.level="${ROOT_LOG_LEVEL}" \
    -jar "/opt/integration-tests/lib/integration-tests.jar" \
    --strict \
    --plugin pretty \
    --glue classpath:init/ \
    --glue classpath:steps/ \
    classpath:features/ \
    $@
