#!/usr/bin/env bash
TIMESTAMP=`date -u +"%C%y%m%dT%H%M%SZ"`
OUTPUT="test-results-${TIMESTAMP}"
mkdir -p ${OUTPUT}
docker run -v ${PWD}/${OUTPUT}:/srv/output --env-file env.sh sif-hits-test $1
if [[ "0" == "$?" ]]; then
    echo "Full test results output to ${OUTPUT}/surefire-report.html"
fi
