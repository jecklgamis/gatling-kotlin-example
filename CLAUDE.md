# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Gatling load testing project using Kotlin and the Gatling Java DSL. It generates HTTP traffic against a target endpoint for performance testing.

## Build Commands

```bash
# Build the project (creates executable jar)
./mvnw clean package

# Build Docker image
make image
```

## Running Simulations

**Using Maven plugin (recommended for development):**
```bash
./mvnw -DsimulationClass=gatling.test.example.simulation.ExampleSimulation gatling:test
```

**Using executable jar:**
```bash
JAVA_OPTS="-DbaseUrl=http://localhost:8080 -DdurationMin=1 -DrequestPerSecond=10"
java ${JAVA_OPTS} -cp target/gatling-kotlin-example.jar io.gatling.app.Gatling \
  --simulation gatling.test.example.simulation.ExampleSimulation --results-folder results
```

**Using gatling-server (remote submission, no local JVM):**
```bash
curl -H "Authorization: Bearer ${API_TOKEN}" \
  -F "file=@target/gatling-kotlin-example.jar" \
  -F "simulation=gatling.test.example.simulation.ExampleSimulation" \
  -F "javaOpts=-DbaseUrl=http://localhost:8080 -DdurationMin=1 -DrequestPerSecond=10" \
  http://localhost:58080/task/upload
```
See [gatling-server](https://github.com/jecklgamis/gatling-server) for setup and the full API.

**Using gatling-mcp-server (AI agent, natural language):**
This repo has a project-scoped `.mcp.json` connecting to
[gatling-mcp-server](https://github.com/jecklgamis/gatling-mcp-server) - an MCP-capable AI client can upload the
jar and submit/monitor a run just by describing what you want, instead of the `curl` above.

## Configuration

Simulations are configured via Java system properties (set via `-D` flags):

| Property | Default | Description |
|----------|---------|-------------|
| `baseUrl` | `http://localhost:8080` | Target server URL |
| `requestPerSecond` | `10.0` | Constant request rate |
| `durationMin` | `1` | Test duration in minutes |
| `p95ResponseTimeMs` | `1000` | P95 latency threshold for assertions |

## Architecture

- **Simulations** extend `io.gatling.javaapi.core.Simulation` and define scenarios with HTTP protocols
- **PerfTestConfig** centralizes all configurable parameters, reading from system properties with defaults
- **SystemPropertiesUtil** provides typed accessors for system properties with fallbacks
- Simulations are in `src/main/kotlin/gatling/test/example/simulation/`
