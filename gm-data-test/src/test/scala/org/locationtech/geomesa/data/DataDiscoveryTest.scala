package org.locationtech.geomesa.data

import org.junit.runner.RunWith
import org.locationtech.geomesa.convert.SimpleFeatureConverters
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class DataDiscoveryTest extends Specification {

  val names = Seq("gdelt", "gtd", "tdrive", /*"geolife", "osm-gpx", */"twitter")
  "SimpleFeatureTypes" should {
    "be discoverable" >> {
      SimpleFeatureConverters.listTypes.toList must containAllOf(names)
    }

    names.foreach { n =>
      s"have sft for $n" >> {
        SimpleFeatureConverters.sftForName(n) must not beNull
      }
      s"have converter for $n" >> {
        SimpleFeatureConverters.convForName(n) must not beNull
      }
    }
  }
}
