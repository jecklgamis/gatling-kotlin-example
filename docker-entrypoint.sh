#!/bin/bash
SIMULATION_NAME=${SIMULATION_NAME:-gatling.test.example.simulation.ExampleSimulation}
exec java ${JAVA_OPTS} -cp bin/gatling-kotlin-example.jar  io.gatling.app.Gatling -s ${SIMULATION_NAME}
