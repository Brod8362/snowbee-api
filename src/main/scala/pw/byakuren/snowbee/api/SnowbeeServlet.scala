package pw.byakuren.snowbee.api

import org.json4s.{DefaultFormats, Formats, JNothing, JString}
import org.scalatra._
import org.scalatra.json.JacksonJsonSupport
import pw.byakuren.snowbee.api.filters.Filter
import pw.byakuren.snowbee.api.vendors.{AmazonV, EbayV, IVendor, WalmartV}

class SnowbeeServlet extends ScalatraServlet with JacksonJsonSupport {

  protected implicit lazy val jsonFormats: Formats = DefaultFormats

  private val apiInfo: Map[String, String] = Map(
    "version" -> "placeholder",
    "commit" -> "unknown"
  )

  private val availableVendors: Seq[IVendor] = Seq(AmazonV, EbayV, WalmartV)

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

  options("/search") {
    Ok()
  }

  get("/info") {
    apiInfo
  }

  get("/vendors") {
    if (availableVendors.isEmpty) {
      NotFound("no_vendors_selected")
    } else {
      val results = availableVendors.map(_.repr)
      if (results.isEmpty) {
        NotFound("no_results")
      } else {
        Ok(
          Map(
            "vendors" -> results
          )
        )
      }
    }
  }

  get("/filters") {
    Map(
      "filters" -> Filter.all
    )
  }

}
