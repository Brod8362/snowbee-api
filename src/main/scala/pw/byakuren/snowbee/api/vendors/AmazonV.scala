package pw.byakuren.snowbee.api.vendors

import pw.byakuren.snowbee.api.products.Product

object AmazonV extends IVendor("amazon", "Amazon", "https://amazon.com", "https://amazon.com/favicon.ico") {

  val productsDb = Seq(
    Product("Apple iPhone 13", "amazon", 660.00f, "https://www.amazon.com/Apple-iPhone-13-128GB-Blue/dp/B09LNX6KQS?qu=eyJxc2MiOiI2LjI3IiwicXNhIjoiNS45NiIsInFzcCI6IjUuODAifQ%3D%3D", Map(), "https://m.media-amazon.com/images/I/31fGd1Tv3BL._AC_SR38,50_AA50_.jpg"),
    Product("Lenovo Thinkpad P15", "amazon", 1859.00f, "https://www.amazon.com/Lenovo-ThinkPad-P15-Gen-Fingerprint/dp/B09J73WY7M?qu=eyJxc2MiOiI1LjU4IiwicXNhIjoiNS4xNSIsInFzcCI6IjMuODkifQ%3D%3D&ufe=app_do%3Aamzn1.fos.17f26c18-b61b-4ce9-8a28-de351f41cffb", Map(), "https://m.media-amazon.com/images/I/31f-KMEIEfL._AC_US40_AA50_.jpg"),
    Product("APC UPS Battery Backup Surge Protector BE650G1", "amazon", 84.99f, "https://www.amazon.com/APC-Battery-Protector-Back-UPS-BE650G1/dp/B005GZRUZW?qu=eyJxc2MiOiI0LjEyIiwicXNhIjoiMy41MSIsInFzcCI6IjMuMjcifQ%3D%3D&ufe=app_do%3Aamzn1.fos.006c50ae-5d4c-4777-9bc0-4513d670b6bc", Map(), "https://m.media-amazon.com/images/I/318il+fyJPL._AC_US40_AA50_.jpg")
  )

  override def search(query: String, limit: Int): Seq[Product] = {
    productsDb.filter(_.name.toLowerCase.contains(query.toLowerCase)).take(limit)
  }
}
