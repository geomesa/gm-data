# Twitter

## File format

The converter expects data is in JSON that has had newlines removed, such that there is one record per line. Files may be compressed.

## Geometry

Twitter data collected with location data may have a point location if the user posts with precise location. This is stored in the `coordinates` field. Otherwise the tweet is associated with a named place, which has a bounding box. 

The bounding box provided by the Twitter API is not a properly formed geoJson polygon. The array of points does not form a linear ring, as it does not close. Thus the converter takes the bounds and builds a polygon from it.

## Ingest procedure

A recommended ingest procedure is to ingest first picking up the bounding boxes. Tweets with point geometry may fail this ingest. Then ingest to pick up the points. Tweets without points will fail this ingest, and their geometries will remain as set in the first pass.

    geomesa ingest -u USERNAME -c CATALOG -s twitter -C twitter-bbox hdfs://namenode:port/path/to/twitter/*
    geomesa ingest -u USERNAME -c CATALOG -s twitter -C twitter hdfs://namenode:port/path/to/twitter/*
