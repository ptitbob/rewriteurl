import io.gatling.core.Predef.{Simulation, _}
import io.gatling.http.Predef._

import scala.concurrent.duration._

/*
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
*/

/**
  *
  * @author François Robert
  */
class GetWeb extends Simulation {

  //val hostUrl = System.getProperty("url")

  val httpConfigurationWeb1 = http
    .baseURL("http://localhost/web1")
    .acceptHeader("text/html")
  val httpConfigurationWeb2 = http
    .baseURL("http://localhost/web2")
    .acceptHeader("text/html")

  val scenarioWeb1 = scenario("web1")
    .repeat(5)
    //.during(10 seconds)
    {
      exec(http("status").get("/").check(status.not(404)))
    }.inject(rampUsers(100) over (10 seconds)).protocols(httpConfigurationWeb1)
  val scenarioWeb2 = scenario("web2")
    .repeat(5)
    //.during(10 seconds)
    {
      exec(http("status").get("/").check(status.not(404)))
    }.inject(rampUsers(100) over (20 seconds)).protocols(httpConfigurationWeb2)


  setUp(
    scenarioWeb1,scenarioWeb2
  )


}
