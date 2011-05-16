import java.net.URL
import java.net.URLEncoder
import scala.xml.XML

case class Location(val name: String, val lng: Double, val lat: Double)

object GeoCoder {

  def location(name: String): Option[Location] = {
    try {
      var xml = XML.load(new URL("http://nominatim.openstreetmap.org/search?q="+URLEncoder.encode(name, "utf-8")+"&format=xml"))
      var lng = ((xml \\ "place" head) \\ "@lon") text
      var lat = ((xml \\ "place" head) \\ "@lat") text
      def parseDouble(s:String) = java.lang.Double.parseDouble(s)
      Option(new Location(name, parseDouble(lng), parseDouble(lat)))
    } catch {
      case e: Exception => None
    }
  }

}
