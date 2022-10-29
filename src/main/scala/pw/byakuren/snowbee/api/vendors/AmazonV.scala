package pw.byakuren.snowbee.api.vendors

class AmazonV extends IVendor("amazon", "Amazon", "https://amazon.com", "https://amazon.com/favicon.ico") {
  override def search(query: String, limit: Int): Unit = {

  }
}
