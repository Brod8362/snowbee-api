package pw.byakuren.snowbee.api.vendors

object AmazonV extends IVendor("amazon", "Amazon", "https://amazon.com", "https://amazon.com/favicon.ico") {
  override def search(query: String, limit: Int): Seq[Product] = {
    Nil
  }
}
