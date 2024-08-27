package org.example.exo2Product.Repository;

import org.example.exo2Product.Entity.Product;

import javax.persistence.EntityManager;

public class ProductRepository extends BaseRepository<Product> {
    public ProductRepository(EntityManager em) {
        super(em);
    }
}
