import io.gatling.core.Predef.{Simulation, _}
import io.gatling.http.Predef._

import scala.concurrent.duration._

/**
  *
  * @author François Robert
  */
class Web1Web2_1User_3Times extends Simulation {

  val httpConfigurationWeb1 = http
    .baseURL("http://localhost/web1")
    .acceptHeader("text/html")
  val httpConfigurationWeb2 = http
    .baseURL("http://localhost/web2")
    .acceptHeader("text/html")

  val scenarioWeb1 = scenario("web1")
    .repeat(3)
  {
    exec(http("status").get("/").check(status.not(404))).pause(1 seconds)
  }.inject(atOnceUsers(1)).protocols(httpConfigurationWeb1)
  val scenarioWeb2 = scenario("web2")
    .repeat(3)
  {
    exec(http("status").get("/").check(status.not(404))).pause(1 seconds)
  }.inject(atOnceUsers(1)).protocols(httpConfigurationWeb2)

  setUp(
    scenarioWeb1, scenarioWeb2
  )

}
