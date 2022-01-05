package gatling.test.example.simulation

object PerfTestConfig {
    val BASE_URL: String = SystemPropertiesUtil.getAsStringOrElse("baseUrl", "http://localhost:8080")
    val REQUEST_PER_SECOND = SystemPropertiesUtil.getAsDoubleOrElse("requestPerSecond", 10.0)
    val DURATION_MIN = SystemPropertiesUtil.getAsIntOrElse("durationMin", 1).toLong()
    val P95_RESPONSE_TIME_MS = SystemPropertiesUtil.getAsIntOrElse("p95ResponseTimeMs", 1000)
}
