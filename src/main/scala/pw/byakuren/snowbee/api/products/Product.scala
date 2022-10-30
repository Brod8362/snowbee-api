package pw.byakuren.snowbee.api.products

case class Product(name: String,
                   vendor: String,
                   price: Float,
                   product_page: String,
                   properties: Map[String, String],
                   preview_url: String)
