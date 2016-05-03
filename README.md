# GeoMesa Data

GeoMesa Data (gm-data) provides several built in SimpleFeatureType (SFT) and Converter definitions to help ingest common data formats from across the web. Each module contains a ``reference.conf`` file that defines a named SFT and converter that can be referenced via the GeoMesa tools or GeoMesa Nifi processor when properly installed on the classpath.

The ``gm-data-all`` module will package all submodules together into a shaded jar and concatenate any ``reference.conf`` files found in other modules to provide a single deployable artifact.

## Building the Project

Build GeoMesa convert module (geomesa-convert-all). Then build gm-data:

    cd gm-data
    mvn clean install

## Named simple feature types and converters

| Data source | SFT name (-s) | Converter Name (-C) |
| --- | --- | --- |
| [GDELT](http://data.gdeltproject.org/events/index.html) | `gdelt` | `gdelt` |
| [GeoLife](http://research.microsoft.com/en-us/downloads/b16d359d-d164-469e-9fd4-daa38f2b2e13/) | `geolife` | `geolife` |
| [Global Terrorism Database](http://www.start.umd.edu/gtd/) | `gtd` | `gtd` |
| [New York City Taxi](https://publish.illinois.edu/dbwork/open-data/) | `nyctaxi`<sup>1</sup> <br> `nyctaxi-single` | `nyctaxi` <br> `nyctaxi-drop` <br> `nyctaxi-single` |
| [Open Street Map GPX](http://planet.osm.org/gps/) | `osm` | `osm` |
| [T-Drive](http://research.microsoft.com/apps/pubs/?id=152883) | | `tdrive` | `tdrive` |
| [Twitter](https://dev.twitter.com/overview/api/tweets) <sup>2</sup> | `twitter` | `twtitter` <br> `twitter-place-centroid` <sup>3</sup> |


1. NYC Taxi data includes two points: the pickup and dropoff. The `nyctaxi` feature type contains one point and an indicator of whether it is the pickup or dropoff. The `nyctaxi-single` feature has both geometries.
1. Converter expects one tweet per line in the file.
1. Converter `twitter` applies precise point geometry if available; `twitter-place-centroid` extracts the centroid from the bounding box of the tweet's place attribute.

## GeoMesa Tools installation

For GeoMesa Tools, copy the ``gm-data-all-{version}.jar`` file into the ``$GEOMESA_HOME/lib`` directory and run `geomesa ingest`. Specify the simple feature type by name with the `--spec` or `-s` option. Give the converter config by name with the `--converter` or `-C` (capital C) option.

## NiFi Installation

For Apache NiFi, copy the ``gm-data-all-{version}.jar`` file in the ``$NIFI_HOME/lib`` directory and restart NiFi.

