package com.mnkafka.sample.producer;

import com.mnkafka.sample.domain.Product;
import io.micronaut.configuration.kafka.config.AbstractKafkaConfiguration;
import io.micronaut.context.ApplicationContext;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Collections;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class KafkaControllerTest {

    private static KafkaController kafkaController;

    @BeforeClass
    public static void setUp() throws Exception {
        Map<String, Object> config = Collections.singletonMap(
                AbstractKafkaConfiguration.EMBEDDED, true
        );

        try (ApplicationContext ctx = ApplicationContext.run(config)) {
            kafkaController = ctx.getBean(KafkaController.class);
        }
    }

    @Test
    public void send() {
        Product product = new Product();
        product.setBrand("Nike");
        product.setName("AirJordan");
        product.setSku("abcd-1234");
        product.setQuantity(3);
        String message = kafkaController.send(product);

        assertNotNull(message);
        assertEquals("Message sending to partition: Nike, name: AirJordan", message);

    }

    @Test
    public void index() {
        String message = kafkaController.index();
        assertEquals("something",message);
    }
}