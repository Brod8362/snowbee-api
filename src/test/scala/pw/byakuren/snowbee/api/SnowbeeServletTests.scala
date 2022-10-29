package pw.byakuren.snowbee.api

import org.scalatra.test.scalatest._

class SnowbeeServletTests extends ScalatraFunSuite {

  addServlet(classOf[SnowbeeServlet], "/*")

  test("GET / on SnowbeeServlet should return status 200") {
    get("/") {
      status should equal (200)
    }
  }

}
