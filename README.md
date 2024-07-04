# gatling-kotlin-example

[![Build](https://github.com/jecklgamis/gatling-kotlin-example/actions/workflows/build.yml/badge.svg)](https://github.com/jecklgamis/gatling-kotlin-example/actions/workflows/build.yml)

An example Gatling Maven project using Kotlin DSL.

## Building

```
mvn clean package
```

## Running

Using the executable jar file (`run-simulation-using-jar.sh`):

```bash
JAVA_OPTS="-DbaseUrl=http://localhost:8080  -DdurationMin=1 -DrequestPerSecond=10"
SIMULATION_NAME=gatling.test.example.simulation.ExampleSimulation
java ${JAVA_OPTS} -cp target/gatling-kotlin-example.jar io.gatling.app.Gatling --simulation "${SIMULATION_NAME}" --results-folder results
```

Using the Gatling Maven plugin (`run-simulation-using-plugin.sh`):

```bash
./mvnw test -Pperf-test
```

Using the Docker container (`run-simulation-using-docker.sh`):

```bash
docker build -t gatling-kotlin-example:main .
docker run -e "JAVA_OPTS=-DbaseUrl=http://some-target-host:8080 -DdurationMin=1 -DrequestPerSecond=10" \
-e SIMULATION_NAME=gatling.test.example.simulation.ExampleSimulation gatling-kotlin-example:main
```

## Working With Makefile

Build executable jar and Docker image

```
make dist image
```

Run Docker image:

```
make run
```

