package com.mnkafka.sample.consumer;

import com.mnkafka.sample.consumer.SortingAndOrderArguments;
import com.mnkafka.sample.consumer.jpa.ProductDao;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Optional<ProductDao> findById(@NotNull Long id);
    ProductDao save(ProductDao person);
    void deleteById(@NotNull Long id);
    List<ProductDao> findAll(@NotNull SortingAndOrderArguments args);
    int update(ProductDao person);
}
