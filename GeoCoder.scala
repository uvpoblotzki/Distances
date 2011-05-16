import java.net.URL
import java.net.URLEncoder
import scala.xml.XML


object GeoCoder {
  
  def apply(location: String) = new GeoCoder(location)
  
}

class GeoCoder(val location: String) {
  
  private val x = XML.load(new URL("http://maps.googleapis.com/maps/api/geocode/xml?address="+location+"&sensor=false"))
  
  val lat: Option[Double] = try {
    Some(java.lang.Double.parseDouble((x \\ "location" \\ "lat").text))
  } catch {
    case ex: Exception => None
  }
  
  val lng: Option[Double] = try {
    Some(java.lang.Double.parseDouble((x \\ "location" \\ "lng").text))
  } catch {
    case ex: Exception => println(ex);None
  }
  
}