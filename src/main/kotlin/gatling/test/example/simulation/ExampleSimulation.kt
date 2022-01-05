package gatling.test.example.simulation

import gatling.test.example.simulation.PerfTestConfig.DURATION_MIN
import gatling.test.example.simulation.PerfTestConfig.P95_RESPONSE_TIME_MS
import gatling.test.example.simulation.PerfTestConfig.REQUEST_PER_SECOND
import io.gatling.javaapi.core.CoreDsl.*
import io.gatling.javaapi.core.Simulation
import io.gatling.javaapi.http.HttpDsl.http
import io.gatling.javaapi.http.HttpDsl.status
import java.time.Duration


class ExampleSimulation : Simulation() {

    private val httpProtocol = http.baseUrl(PerfTestConfig.BASE_URL)
            .header("Content-Type", "application/json")
            .header("Accept-Encoding", "gzip")
            .check(status().`is`(200))

    private val scn = scenario("Root end point calls")
            .exec(http("root end point").post("/").body(StringBody("{}")))

    init {
        setUp(scn.injectOpen(constantUsersPerSec(REQUEST_PER_SECOND).during(Duration.ofMinutes(DURATION_MIN))))
                .protocols(httpProtocol)
                .assertions(global().responseTime().percentile3().lt(P95_RESPONSE_TIME_MS),
                        global().successfulRequests().percent().gt(95.0))
    }
}
