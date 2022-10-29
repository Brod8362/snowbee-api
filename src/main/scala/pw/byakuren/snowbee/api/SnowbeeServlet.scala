package pw.byakuren.snowbee.api

import org.scalatra._

class SnowbeeServlet extends ScalatraServlet {

  get("/") {
    views.html.hello()
  }

}
