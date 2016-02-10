# GeoMesa Data

GeoMesa Data (gm-data) provides several built in SimpleFeatureType (SFT) and Converter definitions to help ingest 
common data formats from across the web. Each module contains a ``reference.conf`` file that defines a named SFT and 
converter that can be referenced via the GeoMesa tools or GeoMesa Nifi processor when properly installed on the 
classpath.

The ``gm-data-all`` module will package all submodules together into a shaded jar and concatenate any ``reference.conf``
files found in other modules to provide a single deployable artifact.

## Nifi Installation

For Apache Nifi, copy the ``gm-data-all-{version}.jar`` file in the ``$NIFI_HOME/lib`` directory and restart Nifi.

## GeoMesa Tools installation

For GeoMesa Tools, copy the ``gm-data-all-{version}.jar`` file into the ``$GEOMESA_HOME/lib`` directory and run ingest.
