package pw.byakuren.snowbee.api.filters

case class Filter(id: String, name: String, `type`: String)

object Filter {
  val all = Seq(
    Filter("color", "Color", "str"),
    Filter("price_range", "Price Range", "range")
  )
}
