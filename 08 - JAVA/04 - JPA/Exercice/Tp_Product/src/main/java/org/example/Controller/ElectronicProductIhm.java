package org.example.Controller;

import org.example.Entity.Product;
import org.example.Entity.ProductElectronic;
import org.example.Entity.ProductFood;
import org.example.Repository.RepositoryProduct;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ElectronicProductIhm {

    private RepositoryProduct repositoryProduct;
    private Scanner sc;

    public ElectronicProductIhm(EntityManager em, Scanner scanner) {
        sc = scanner;
        repositoryProduct = new RepositoryProduct(em);
    }

    public void start (){
        int entry ;

        while (true){
            System.out.println("--- Product Electronic ---");
            System.out.println("1/ Create Product");
            System.out.println("2/ Edit Product");
            System.out.println("3/ Delete Product");
            System.out.println("4/ find by id Product");
            System.out.println("5/ find all Electronic product");
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
        System.out.println("-- Create Electronic Product --");
        System.out.println("Product name :");
        String name = sc.nextLine();
        System.out.println("Product price :");
        float price = sc.nextFloat();
        sc.nextLine();
        System.out.println("Batteries Duration :");
        int batteriesDuration = sc.nextInt();
        sc.nextLine();

        ProductElectronic productElectronic = ProductElectronic.builder().name(name).price(price).batterieDuration(batteriesDuration).build();
        repositoryProduct.save(productElectronic);
    }

    private void edit (){
        System.out.println("-- Update Electronic Product --");
        ProductElectronic productElectronic = findById();
        if(productElectronic != null){
            System.out.println("Product name : ( "+productElectronic.getName() +" )");
            productElectronic.setName(sc.nextLine());
            System.out.println("Product price : ( "+productElectronic.getPrice() +" )");
            productElectronic.setPrice( sc.nextFloat());
            sc.nextLine();
            System.out.println("Batteries Duration : ("+productElectronic.getBatterieDuration()+" )");
            productElectronic.setBatterieDuration( sc.nextInt());
            sc.nextLine();

            repositoryProduct.save(productElectronic);
        }
        else{
            System.out.println("no product found");
        }
    }

    private void delete (){
        System.out.println("-- Delete Electronic Product --");
        ProductElectronic productElectronic = findById();

        if(productElectronic != null){
            repositoryProduct.delete(productElectronic);
        }
        else{
            System.out.println("no product found");
        }
    }

    private ProductElectronic findById (){
        System.out.println("Electronic product id");
        int id = sc.nextInt();
        sc.nextLine();

        return (ProductElectronic) repositoryProduct.findById(id,"Elec");

    }

    private void showById (){
        System.out.println("-- Show By Id Electronic Product --");
        ProductElectronic productElectronic = findById();

        if(productElectronic != null){
            System.out.println(" Product : "+ productElectronic);
        }else{
            System.out.println("no product found");
        }
    }

    private void showAll () {
        System.out.println("-- Show Electronic Products --");
        List<Product> productFoods = repositoryProduct.findAllByType("Elec");

        if(productFoods!=null){
            for(Product product : productFoods){
                System.out.println(product);
            }
        }else{
            System.out.println("no product found");
        }
    }
}
