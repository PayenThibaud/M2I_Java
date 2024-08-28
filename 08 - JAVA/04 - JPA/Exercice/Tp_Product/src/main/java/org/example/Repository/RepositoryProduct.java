package org.example.Repository;

import org.example.Entity.Product;
import org.example.Entity.ProductElectronic;
import org.example.Entity.ProductFood;
import org.example.Entity.ProductHousing;

import javax.persistence.EntityManager;
import java.util.List;

public class RepositoryProduct extends BaseRepository<Product> {

    public RepositoryProduct(EntityManager em) {
        super(em);
    }

    @Override
    public void save (Product element){
        em.getTransaction().begin();
        em.persist(element);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Product element) {
        em.getTransaction().begin();
        em.remove(element);
        em.getTransaction().commit();
    }

    @Override
    public Product findById(int id, String discriminator) {

        switch (discriminator){
            case "Food":
                return em.find(ProductFood.class,id);
            case "Elec":
                return em.find(ProductElectronic.class,id);
            case"Housing":
                return em.find(ProductHousing.class,id);
            default:
                return null;
        }
        
    }

    @Override
    public List<Product> findAll() {
        return em.createQuery("select p from Product  p ",Product.class).getResultList();


    }

    @Override
    public List<Product> findAllByType(String productClass) {
        switch (productClass){
            case "Food":
                return em.createQuery("select p from ProductFood p",Product.class).getResultList();
            case "Elec":
                return em.createQuery("select p from ProductElectronic p",Product.class).getResultList();
            case"Housing":
                return em.createQuery("select p from ProductHousing p",Product.class).getResultList();
            default:
                return null;
        }
    }
}
