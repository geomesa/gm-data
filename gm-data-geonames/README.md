# GeoNames for GeoMesa

This directory provides [GeoNames](http://www.geonames.org/) GeoMesa ingest commands and converter configuration files.

GeoNames is a geographical database containing over 10 million geographical names and over 9 million unique features. All features are classified as one of nine feature codes and then again sub-categorized into one of 645 feature codes. This data is available freely directly from GeoNames's website.

## Getting GeoNames data
GeoNames data can be downloaded from [GeoNames's Server](http://download.geonames.org/export/dump/). Files are downloaded in .zip format and need to be unzipped to a text document before being ready for use. The entire database can be ingested using `allCountries.txt` or a subset (such as `cities15000.txt`) can be downloaded instead.

## Ingest Commands

Check that `geonames` simple feature type is available on the GeoMesa tools classpath.

    geomesa env | grep geonames

Run the ingest. You may optionally point to a different accumulo instance using `-i` and `-z` options. See `geomesa help ingest` for more detail. The most important detail is referencing the `geonames` SimpleFeatureType and `geonames` converter.

    geomesa ingest -u USERNAME -c CATALOGNAME -s geonames -C geonames -c cities15000.txt
