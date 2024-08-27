package org.example.Controller;

import com.sun.tools.jconsole.JConsoleContext;
import org.example.Entity.Product;
import org.example.Entity.ProductFood;
import org.example.Repository.RepositoryProduct;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class FoodProductIhm {

    private RepositoryProduct repositoryProduct;
    private Scanner sc;

    public FoodProductIhm(EntityManager em,Scanner scanner) {
        sc = scanner;
        repositoryProduct = new RepositoryProduct(em);
    }

    public void start (){
        int entry ;

        while (true){
            System.out.println("--- Product Food ---");
            System.out.println("1/ Create Product");
            System.out.println("2/ Edit Product");
            System.out.println("3/ Delete Product");
            System.out.println("4/ find by id Product");
            System.out.println("5/ find all food product");
            entry = sc.nextInt();
            sc.nextLine();
            switch (entry){
                case 1:
                    add();
                    break;
                case 2:
                    edit();
                    break;
                case 3 :
                    delete();
                    break;
                case 4:
                    showById();
                    break;
                case 5 :
                    showAll();
                    break;
                default:
                    return;
            }
        }
    }

    private void add (){
        System.out.println("-- Create Food Product --");
        System.out.println("Product name :");
        String name = sc.nextLine();
        System.out.println("Product price :");
        float price = sc.nextFloat();
        sc.nextLine();
        System.out.println("how many days left fort expiry date :");
        long days = sc.nextLong();
        sc.nextLine();

        long today = new Date().getTime();
        today += 86400000 * days;
        Date expiryDate = new Date(today);

        ProductFood productFood = ProductFood.builder().name(name).price(price).expiryDate(expiryDate).build();
        repositoryProduct.save(productFood);
    }

    private void edit (){
        System.out.println("-- Update Food Product --");
        ProductFood productFood = findById();
        if(productFood != null){
            System.out.println("Product name : ( "+productFood.getName() +" )");
            productFood.setName(sc.nextLine());
            System.out.println("Product price : ( "+productFood.getPrice() +" )");
             productFood.setPrice( sc.nextFloat());
            sc.nextLine();
            System.out.println("how many days left fort expiry date : ( "+productFood.getExpiryDate().toString() +" )");
            long days = sc.nextLong();
            sc.nextLine();

            long today = new Date().getTime();
            today += 86400000 * days;
            productFood.setExpiryDate(new Date(today));
            repositoryProduct.save(productFood);
        }
        else{
            System.out.println("no product found");
        }
    }

    private void delete (){
        System.out.println("-- Delete Food Product --");
        ProductFood productFood = findById();

        if(productFood != null){
            repositoryProduct.delete(productFood);
        }
        else{
            System.out.println("no product found");
        }
    }

    private ProductFood findById (){
        System.out.println("Food product id");
        int id = sc.nextInt();
        sc.nextLine();

        return (ProductFood) repositoryProduct.findById(id,"Food");

    }

    private void showById (){
        System.out.println("-- Show By Id Food Product --");
        ProductFood productFood = findById();

        if(productFood != null){
            System.out.println(" Product : "+ productFood);
        }else{
            System.out.println("no product found");
        }
    }

    private void showAll () {
        System.out.println("-- Show Food Products --");
        List<Product> productFoods = repositoryProduct.findAllByType("Food");

        if(productFoods!=null){
            for(Product product : productFoods){
                System.out.println(product);
            }
        }else{
            System.out.println("no product found");
        }
    }
}
