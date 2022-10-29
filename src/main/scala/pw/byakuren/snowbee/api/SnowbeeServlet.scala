package pw.byakuren.snowbee.api

import org.json4s.{DefaultFormats, Formats}
import org.scalatra._
import org.scalatra.json.JacksonJsonSupport
import pw.byakuren.snowbee.api.filters.Filter
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
    val query = ""
    val limit = 10
    availableVendors.map(_.search(query, limit))
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

  get("/filters") {
    Filter.all
  }

}
