#!/bin/bash
SIMULATION_NAME=${SIMULATION_NAME:-gatling.test.example.simulation.ExampleSimulation}
JAVA_OPTS="${JAVA_OPTS} --add-opens java.base/java.lang=ALL-UNNAMED"
exec java ${JAVA_OPTS} -cp bin/gatling-kotlin-example.jar  io.gatling.app.Gatling --simulation ${SIMULATION_NAME} --results-folder results
