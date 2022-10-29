package pw.byakuren.snowbee.api.vendors

abstract case class IVendor(id: String, name: String, url: String, favicon: String) {
  def search(query: String, limit: Int): Unit
}