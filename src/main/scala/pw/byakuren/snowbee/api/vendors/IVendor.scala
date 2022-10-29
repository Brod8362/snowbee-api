package pw.byakuren.snowbee.api.vendors
import org.json4s.DefaultFormats

case class VendorRepr(id: String, name: String, url: String, favicon: String)

abstract class IVendor(id :String, name: String, url: String, favicon: String) {

  implicit val formats: DefaultFormats.type = org.json4s.DefaultFormats

  def search(query: String, limit: Int): Seq[Product] = ???
  final def repr: VendorRepr = VendorRepr(this.id, this.name, this.url, this.favicon)
}