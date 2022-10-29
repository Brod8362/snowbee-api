package pw.byakuren.snowbee.api.vendors
import org.json4s.DefaultFormats
import org.json4s.JsonDSL._
import org.json4s.jackson.Serialization


case class IVendor(id: String, name: String, url: String, favicon: String) {

  implicit val formats: DefaultFormats.type = org.json4s.DefaultFormats

  def search(query: String, limit: Int): Seq[Product] = ???
}