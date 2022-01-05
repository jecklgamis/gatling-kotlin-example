#!/usr/bin/env bash
set -ex
curl -v \
  -F 'file=@./gatling-kotlin-example-user-files.tar.gz' \
  -F "simulation=gatling.test.example.simulation.ExampleSimulation" \
  -F "javaOpts=-DbaseUrl=http://localhost:8080 -DdurationMin=1 -DrequestPersecond=1" \
  http://localhost:58080/task/upload/http
