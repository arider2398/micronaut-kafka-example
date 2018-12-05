#Producer Sample
A simple example that uses a Controller that will take a POJO from a POST request and place the 
object on a Kafka topic.

This project was created using `mn create-app producer-sample --features kafka`.  This still 
allows for the Controller to be used and to incorporate features from Kafka.

##KafkaController.java
This class creates an endpoint `/products` that at this time only implements a POST that logs the
call and places the `Product` data on the topic through the interface `ProductClient`.

##ProductClient.java
An interface used to contact the topic.  This implementation will place the `Product` item on the
topic `test-products` with a key value of the brand. 


