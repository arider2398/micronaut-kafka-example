#Consumer Sample
A simple example of a consumer that will fetch an item from a topic and 
then will use that information to feed another topic using the `@SendTo` 
annotation.

This project was created using `mn create-app consumer-sample --profile kafka`.
Using the profile flag will create a Micronaut app with Kafka support, and without an HTTP server 

##Product Consumer
This listener has two methods that are listening to two differnt topics.

The `receive` method will fetch data from the `test-products` topic, print a
message and return the quantity from `Product`.  The return value is the message being 
put on the `test-product-quantities` topic because of the `@SendTo` annotations.

The `updateQuantity` method will listen to the `test-product-quantities` topic an print
a message based on the value on the topic.