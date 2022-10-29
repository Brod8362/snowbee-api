package pw.byakuren.snowbee.api

import org.scalatra._
import pw.byakuren.snowbee.api.vendors.{AmazonV, IVendor}

class SnowbeeServlet extends ScalatraServlet {

  private val availableVendors: Seq[IVendor] = Seq(new AmazonV)

  post("/search") {
    views.html.hello()
  }

  get("/info") {

  }

  get("vendors") {

  }

  get("filters") {

  }

}
