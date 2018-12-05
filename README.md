#Micronaut Kafka Sample
A sample program that will create both a producer to a Kafka topic and
a consumer of the same topic.

The producer will contain a controller that will accept a POJO from a post
and will place that object on a topic.  The controller will consume the object
from the topic, and then using the `@SendTo` annotation send a part of the 
message to another topic for consumption.

##Setup
To develop and test locally make sure install Zookeeper and Kafka locally 
according the Kafka QuickStart https://kafka.apache.org/quickstart.  For this
sample program we need to do steps 1-3: download and install, start the servers 
and create a topic.  If it is desired to run through Docker a `docker-compose.yml`
file has been set up to use docker compose to start up Zookeeper, Kafka and both
sample applications.  To use make sure both samples have been built for Docker and
run the command `docker-compose up -d` to start all the containters.
