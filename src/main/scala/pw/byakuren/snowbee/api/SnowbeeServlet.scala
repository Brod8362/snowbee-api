package pw.byakuren.snowbee.api

import org.json4s.{DefaultFormats, Formats, JNothing, JString}
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
    val json = parsedBody
    val queryJ = json \\ "query"
    if (queryJ == JNothing) {
      BadRequest("missing_query_parameter")
    } else if (!queryJ.isInstanceOf[JString]) {
      BadRequest("query_is_not_string")
    } else {
      val limit = 10
      Map(
        "products" -> availableVendors.flatMap(_.search(queryJ.asInstanceOf[JString].s, limit))
      )
    }
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
