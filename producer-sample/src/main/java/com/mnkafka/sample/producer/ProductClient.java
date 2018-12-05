package com.mnkafka.sample.producer;

import io.micronaut.configuration.kafka.annotation.*;
import io.micronaut.messaging.annotation.*;
import com.mnkafka.sample.domain.Product;

@KafkaClient
public interface ProductClient {

    @Topic("test-products")
    void sendProduct(@KafkaKey String brand, @Body Product product);
}
