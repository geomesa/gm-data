package org.locationtech.geomesa.data

import org.junit.runner.RunWith
import org.locationtech.geomesa.convert.ConverterConfigLoader
import org.locationtech.geomesa.utils.geotools.SimpleFeatureTypeLoader
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class DataDiscoveryTest extends Specification {

  val names = Seq("gdelt", "gtd", "tdrive", "geolife", "osm-gpx", "twitter")
  "SimpleFeatureTypes" should {
    "be discoverable" >> {
      SimpleFeatureTypeLoader.listTypeNames must containAllOf(names)
      ConverterConfigLoader.listConverterNames must containAllOf(names)
    }

    names.foreach { n =>
      s"have sft for $n" >> {
        SimpleFeatureTypeLoader.sftForName(n).get must not beNull
      }
      s"have converter for $n" >> {
        ConverterConfigLoader.configForName(n).get must not beNull
      }
    }
  }
}
