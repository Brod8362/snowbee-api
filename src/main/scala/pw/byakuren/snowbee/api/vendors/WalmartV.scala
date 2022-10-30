package pw.byakuren.snowbee.api.vendors

import pw.byakuren.snowbee.api.products.Product

object WalmartV extends IVendor("walmart", "Walmart", "https://walmart.com", "https://walmart.com/favicon.ico") {

  val productsDb = Seq(
    Product("Apple iPhone 13", "walmart", 829.00f, "https://www.walmart.com/ip/Straight-Talk-Apple-iPhone-13-128GB-Starlight-Prepaid-Smartphone/103784390", Map(), "https://i5.walmartimages.com/asr/904ef03b-71de-47b8-b045-c08c860820e8.12bc5a80ee74c14d63eb98d069b0173b.jpeg?odnHeight=612&odnWidth=612&odnBg=FFFFFF"),
    Product("Lenovo Thinkpad T540P HD 15.6\" Intel Core i5", "walmart", 227.99f, "https://www.walmart.com/ip/Lenovo-Thinkpad-T540P-HD-15-6-Intel-Core-i5-2-6GHz-3-3GHz-8GB-Memory-500GB-Hard-Drive-Webcam-Numeric-Keypad-Bluetooth-Windows-10-Professional-Laptop-/520049951", Map(), "https://i5.walmartimages.com/asr/d740b8b9-ac15-41de-b934-7c53505b6098_1.dd38fad7da91b90061eb237f1e6fe588.jpeg?odnHeight=612&odnWidth=612&odnBg=FFFFFF"),
    Product("APC UPS 450VA Battery Backup Surge Protector BN450M", "walmart", 55.00f, "https://www.walmart.com/ip/APC-UPS-450VA-Battery-Backup-Surge-Protector-BN450M-Backup-Battery-Power-Supply/187572176", Map(), "https://i5.walmartimages.com/asr/909f4410-c0ef-4202-9c02-87a9890d0b61_1.f25f8edf4686d17f74966646ed8a8106.jpeg?odnHeight=612&odnWidth=612&odnBg=FFFFFF")
  )

  override def search(query: String, limit: Int): Seq[Product] = {
    productsDb.filter(_.name.toLowerCase.contains(query.toLowerCase)).take(limit)
  }
}
