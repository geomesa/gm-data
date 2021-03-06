# NYC Taxi 

New York City taxi activity data published by University of Illiois from Freedom of Information Law requests to NYC Taxi and Limo Commission. More information about the dataset is [here](https://publish.illinois.edu/dbwork/open-data/). Access to data within CCRi is described on [the interal wiki](https://ccristudio.jira.com/wiki/display/DATASOURCES/NYC+Taxi).

U of Illinois hosts the data in a Box web interface and arrives in several zip archives. Only the "trip data" is examined here. There is also "fare data" from the taxi meters such as fare amount and tip. Once unpacked there are monthly CSV files covering four years.

## Data design
The taxi data includes two points and two timestamps per record in the original data. This presents an opportunity for different simple feature type designs. 

There is one design where each SFT is either a pickup or dropoff point with timestamp. The two points share a common trip ID. Internally they are differentiated by hashing the record with either "pickup" or "dropoff" appended. The advantage of this for geomesa demonstrations is dealing with a larger quantity of point data.

In keeping with the original data, there is a two-point feature type as well. 

One could also imagine a linetype geometry, however the path is underspecified. Previous analysis of the NYC Taxi data seems to have used Google Maps API calls to propose valid paths through the streets. We do not attempt that in this work.

## Sample ingest command

### Two record method

To ingest with GeoMesa command line interface, first the pickup:

    $ geomesa ingest -u username -c catalogName -s nyctaxi -C nyctaxi hdfs://namenode:9000/path/to/nyctaxi*

Then the dropoff ingests the same file with the same simple feature type, but different converter.

    $ geomesa ingest -u username -c catalogName -s nyctaxi -C nyctaxi-drop hdfs://namenode:9000/path/to/nyctaxi*

### Single record method


    $ geomesa ingest -u username -c catalogName -s nyctaxi-single -C nyctaxi-single.conf hdfs://namenode:9000/path/to/nyctaxi*
