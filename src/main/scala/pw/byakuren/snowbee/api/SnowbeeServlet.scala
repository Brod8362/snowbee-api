package pw.byakuren.snowbee.api

import org.json4s.{DefaultFormats, Formats}
import org.scalatra._
import org.scalatra.json.JacksonJsonSupport
import pw.byakuren.snowbee.api.vendors.{AmazonV, IVendor}

class SnowbeeServlet extends ScalatraServlet with JacksonJsonSupport {

  protected implicit lazy val jsonFormats: Formats = DefaultFormats

  private val apiInfo: Map[String, String] = Map(
    "version" -> "placeholder",
    "commit" -> "unknown"
  )

  private val availableVendors: Seq[IVendor] = Seq(AmazonV)

  before() {
    contentType = formats("json")
  }

  post("/search") {
    views.html.hello()
  }

  get("/info") {
    apiInfo
  }

  get("/vendors") {
    if (availableVendors.isEmpty) {
      NotFound()
    } else {
      Map(
        "vendors" -> availableVendors.map(_.repr)
      )
    }
  }

  get("filters") {

  }

}
