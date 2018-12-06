package com.mnkafka.sample.consumer;

import com.mnkafka.sample.consumer.jpa.ProductDao;
import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import io.micronaut.spring.tx.annotation.Transactional;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Singleton
public class ProductRepositoryImpl implements ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;
    private final ApplicationConfiguration applicationConfiguration;

    public ProductRepositoryImpl(@CurrentSession EntityManager entityManager,
                                 ApplicationConfiguration applicationConfiguration) {
        this.entityManager = entityManager;
        this.applicationConfiguration = applicationConfiguration;
    }

    @Override
    @Transactional
    public Optional<ProductDao> findById(@NotNull Long id) {
        return Optional.ofNullable(entityManager.find(ProductDao.class, id));
    }

    @Override
    @Transactional
    public ProductDao save(ProductDao product) {
        entityManager.persist(product);
        return product;
    }

    @Override
    @Transactional
    public void deleteById(@NotNull Long id) {
        findById(id).ifPresent(product -> entityManager.remove(product));
    }

    private final static List<String> VALID_PROPERTY_NAMES = Arrays.asList("id", "name");

    @Override
    @Transactional(readOnly = true)
    public List<ProductDao> findAll(@NotNull SortingAndOrderArguments args) {
        String qlString = "SELECT p FROM product as p";
        if (args.getOrder().isPresent() && args.getSort().isPresent() && VALID_PROPERTY_NAMES.contains(args.getSort().get())) {
            qlString += " ORDER BY p." + args.getSort().get() + " " + args.getOrder().get().toLowerCase();
        }
        TypedQuery<ProductDao> query = entityManager.createQuery(qlString, ProductDao.class);
        query.setMaxResults(args.getMax().orElseGet(applicationConfiguration::getMax));
        args.getOffset().ifPresent(query::setFirstResult);

        return query.getResultList();

    }

    @Override
    @Transactional
    public int update(ProductDao product) {
        return entityManager.createQuery("UPDATE product p SET name = :name, sku = :sku, brand = :brand, quantity = :quantity where id = :id")
                .setParameter("name", product.getName())
                .setParameter("sku", product.getSku())
                .setParameter("brand", product.getBrand())
                .setParameter("quantity", product.getQuantity())
                .setParameter("id", product.getId())
                .executeUpdate() ;
    }
}
