package org.example.exo2Product;

import org.example.exo2Product.Entity.Product;
import org.example.exo2Product.Entity.Product_Electronic;
import org.example.exo2Product.Entity.Product_Food;
import org.example.exo2Product.Repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Java_JPA");
        EntityManager em = emf.createEntityManager();

//        Product_ElectronicRepository electronicRepository = new Product_ElectronicRepository(em);
//        ProductRepository productRepository = new ProductRepository(em);
//
//
//        Product_Electronic electronic = Product_Electronic.builder()
//                .name("smartphone")
//                .price(10.0)
//                .expiry_date("10/10/10")
//                .build();
//
//        electronicRepository.add(electronic);
//
//        System.out.println(electronic);
//        Product productFound = productRepository.getById(Product.class,58L);
//        System.out.println(productFound);
//
//        System.out.println(electronicRepository.getById(Product_Electronic.class, 58L));

        ProductRepository productRepository = new ProductRepository(em);

        Product_Electronic electronic2 = Product_Electronic.builder()
                .name("tv")
                .price(20.0)
                .expiry_date("10")
                .build();

        productRepository.add(electronic2);

        System.out.println(electronic2);

        System.out.println(productRepository.getById(Product.class,66l));

        Product_Food food = Product_Food.builder()
                .name("orange")
                .price(15.0)
                .batterie_duration("5H")
                .build();

        productRepository.add(food);

        System.out.println(productRepository.getById(Product.class,70L));
    }
}
