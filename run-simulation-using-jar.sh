#!/usr/bin/env bash
JAVA_OPTS="-DbaseUrl=http://localhost:8080  -DdurationMin=1 -DrequestPerSecond=10"
SIMULATION_NAME=gatling.test.example.simulation.ExampleSimulation
JAVA_OPTS="${JAVA_OPTS} --add-opens java.base/java.lang=ALL-UNNAMED"
java ${JAVA_OPTS} -cp target/gatling-kotlin-example.jar io.gatling.app.Gatling --simulation "${SIMULATION_NAME}" --results-folder results
