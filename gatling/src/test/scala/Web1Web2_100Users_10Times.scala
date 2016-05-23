import io.gatling.core.Predef.{Simulation, _}
import io.gatling.http.Predef._

import scala.concurrent.duration._

/**
  *
  * @author François Robert
  */
class Web1Web2_100Users_10Times extends Simulation {

  val httpConfigurationWeb1 = http
    .baseURL("http://localhost/web1")
    .acceptHeader("text/html")
  val httpConfigurationWeb2 = http
    .baseURL("http://localhost/web2")
    .acceptHeader("text/html")

  val scenarioWeb1 = scenario("web1")
    .repeat(10)
    //.during(10 seconds)
    {
      exec(http("status").get("/").check(status.not(404)))
    }.inject(rampUsers(100) over (10 seconds)).protocols(httpConfigurationWeb1)
  val scenarioWeb2 = scenario("web2")
    .repeat(10)
    //.during(10 seconds)
    {
      exec(http("status").get("/").check(status.not(404)))
    }.inject(rampUsers(100) over (10 seconds)).protocols(httpConfigurationWeb2)


  setUp(
    scenarioWeb1, scenarioWeb2
  )


}
