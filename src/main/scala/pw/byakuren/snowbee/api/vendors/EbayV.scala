package pw.byakuren.snowbee.api.vendors

import pw.byakuren.snowbee.api.products.Product

object EbayV extends IVendor("ebay", "Ebay", "https://ebay.com", "https://ebay.com/favicon.ico") {

  private val productsDb = Seq(
    Product("Apple iPhone 13", "ebay", 539.99f, "https://www.ebay.com/itm/125481874479?epid=7049287499&amdata=enc%3AAQAHAAAAwMIT7m%2B5afy2s29gZ2xQhzsIQGuvXR%2B3R4aYmQsatmuPxGmRxonbyJT%2FRcF3lRNlTNgLGomlFy3ZRqy%2BgD6czS8vGe%2BoyejuA5IwZnmos5UgSizDAZ%2BZ0kNVIIoWyxdY7tm9gFyjXiBIGRI%2FUGPqYJJV3pnspimIaOAmKIx0TO2qRGxe%2FHe0F1T%2F2tvn58ZYwbs9qDASbTHQlIe3tJ6wcjF0uRkv28ZYyCYb4sWonLN1MZZUhg9hYS1uAtWrZ57epw%3D%3D%7Ctkp%3ABlBMUKCptOeEYQ", Map(), "https://i.ebayimg.com/images/g/yEUAAOSwgXBjDiS~/s-l1600.jpg"),
    Product("Lenovo Thinkpad P15s", "ebay", 605.00f, "https://www.ebay.com/itm/265957084072?epid=22040294624&amdata=enc%3AAQAHAAAAoMxh0I6ClEL23xQxrdpxKgCdAjSCYohAfD3%2B2UEYBru8XUcSr74SbskwQN6mqnXeZAKmQ8DhrQ4XWrRjHiKr4jM2Vg8ZHlGHkBFgMKYM%2FJCMryUj1ezz8RwYpz%2FX%2FY5YlFDyM0ZEIWm8EShyqdbCzxfIuhkmrhRbNFYaRlOCA9FD%2BhamhGAik90meHlOU9VsM2G0f%2FROBp%2BK5YsavrQcX3E%3D%7Ctkp%3ABk9SR9LNuueEYQ", Map(), "https://i.ebayimg.com/images/g/kaoAAOSwgXti-xJy/s-l1600.jpg"),
    Product("CyberPower CST135XLU-R 1350VA/810W UPS", "ebay", 96.99f, "https://www.ebay.com/itm/314167370192?amdata=enc%3AAQAHAAAA4LcKeCekYezaIaqNW6NRL7F8GfYYgBDTZXn2oTMsUDQcv%2FFb1BZhgAdTJzTblNu2ORSHtM3OKll7PGMvCjQcfKipNC4MJl2tGsB%2BzUORu%2BdpIsxErxvGE96DDFFf%2FeRfcDuq0PidLw4s2n7hpVjEUsf6%2FuUnQ67mMNBj9Xv4vcZaLQ%2B4NRkTVqeKms93OZyOQCQeyaIRT7YSQXnhPFIdMp5Ly4lctR3Iptz0RpsRJb5h6X2sivKi6P519UuhET%2FgFI%2BzvR6W858gPYi8E3WqrZy%2FFEWS2hgkm0sHiKpA%2FCPR%7Ctkp%3ABFBMyKPC54Rh", Map(), "https://i.ebayimg.com/images/g/rvIAAOSw6tdjWeb2/s-l1600.jpg")
  )

  override def search(query: String, limit: Int): Seq[Product] = {
      productsDb.filter(_.name.toLowerCase.contains(query.toLowerCase)).take(limit)
  }
}
