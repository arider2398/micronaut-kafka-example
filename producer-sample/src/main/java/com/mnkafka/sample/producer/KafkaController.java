package com.mnkafka.sample.producer;

import javax.inject.Inject;

import com.mnkafka.sample.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.http.annotation.*;

@Controller("/products")
public class KafkaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaController.class);

    @Inject
    private ProductClient productClient;

    @Post
    public String send(@Body Product product) {
        String message = String.format("Message sending to partition: %s, name: %s", product.getBrand(), product.getName());
        LOGGER.debug(message);
        productClient.sendProduct(product.getBrand(), product);
        return message;
    }

    @Get
    public String index(){
        return "something";
    }
}
