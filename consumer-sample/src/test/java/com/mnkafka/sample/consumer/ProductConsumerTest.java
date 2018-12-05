package com.mnkafka.sample.consumer;

import com.mnkafka.sample.domain.Product;
import io.micronaut.configuration.kafka.config.AbstractKafkaConfiguration;
import io.micronaut.context.ApplicationContext;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Collections;
import java.util.Map;

import static org.junit.Assert.*;

public class ProductConsumerTest {

    private static ProductConsumer productConsumer;

    @BeforeClass
    public static void setUp() throws Exception {
        Map<String, Object> config = Collections.singletonMap(
                AbstractKafkaConfiguration.EMBEDDED, true
        );

        try (ApplicationContext ctx = ApplicationContext.run(config)) {
            productConsumer = ctx.getBean(ProductConsumer.class);
        }
    }

    @Test
    public void receiveTest() {
        Product product = new Product();
        product.setBrand("Nike");
        product.setName("AirJordan");
        product.setSku("abcd-1234");
        product.setQuantity(3);
        Integer quantity = productConsumer.receive("Nike", product);
        assertNotNull(quantity);
        assertEquals(Integer.valueOf(3),quantity);
    }

    @Test
    public void updateQuantityTest() {
        //Code not interesting for now.  If we did something with the value we could check it was successful.
        productConsumer.updateQuantity("Nike",3);
    }
}