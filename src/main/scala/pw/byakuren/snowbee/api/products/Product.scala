package pw.byakuren.snowbee.api.products

import pw.byakuren.snowbee.api.vendors.IVendor

case class Product(name: String, vendor: IVendor, price: Float, productPage: String, properties: Map[String, String]) {
  def asJson(): String = ???
}
