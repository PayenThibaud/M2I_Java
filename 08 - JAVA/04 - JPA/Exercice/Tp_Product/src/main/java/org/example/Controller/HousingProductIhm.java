package org.example.Controller;

import org.example.Entity.Product;
import org.example.Entity.ProductFood;
import org.example.Entity.ProductHousing;
import org.example.Repository.RepositoryProduct;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class HousingProductIhm {

    private RepositoryProduct repositoryProduct;
    private Scanner sc;

    public HousingProductIhm(EntityManager em, Scanner scanner) {
        sc = scanner;
        repositoryProduct = new RepositoryProduct(em);
    }

    public void start (){
        int entry ;

        while (true){
            System.out.println("--- Product Housing ---");
            System.out.println("1/ Create Product");
            System.out.println("2/ Edit Product");
            System.out.println("3/ Delete Product");
            System.out.println("4/ find by id Product");
            System.out.println("5/ find all housing product");
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
        System.out.println("-- Create Housing Product --");
        System.out.println("Product name :");
        String name = sc.nextLine();
        System.out.println("Product price :");
        float price = sc.nextFloat();
        sc.nextLine();
        System.out.println("Product width :");
        int width = sc.nextInt();
        sc.nextLine();
        System.out.println("Product Height :");
        int height = sc.nextInt();
        sc.nextLine();

        ProductHousing productHousing = ProductHousing.builder().name(name).price(price).height(height).width(width).build();
        repositoryProduct.save(productHousing);
    }

    private void edit (){
        System.out.println("-- Update Housing Product --");
        ProductHousing productHousing = findById();

        if(productHousing != null){
            System.out.println("Product name : (" + productHousing.getName() +" )");
            productHousing.setName(sc.nextLine());
            System.out.println("Product price : (" + productHousing.getPrice() +" )");
            productHousing.setPrice(sc.nextFloat());
            sc.nextLine();
            System.out.println("Product width : (" + productHousing.getWidth() +" )");
            productHousing.setWidth(sc.nextInt());
            sc.nextLine();
            System.out.println("Product Height : (" + productHousing.getHeight() +" )");
            productHousing.setHeight(sc.nextInt());
            sc.nextLine();

            repositoryProduct.save(productHousing);
        }else{
            System.out.println("no product found");
        }
    }

    private ProductHousing findById (){
        System.out.println("Food product id");
        int id = sc.nextInt();
        sc.nextLine();

        return (ProductHousing) repositoryProduct.findById(id,"Housing");
    }

    private void delete (){
        System.out.println("-- Delete Housing Product --");
        ProductHousing productHousing = findById();

        if(productHousing != null){
            repositoryProduct.delete(productHousing);
        }
        else{
            System.out.println("no product found");
        }
    }

    private void showById (){
        System.out.println("-- Show By Id Housing Product --");
        ProductHousing productHousing = findById();

        if(productHousing != null){
            System.out.println(" Product : "+ productHousing);
        }else{
            System.out.println("no product found");
        }
    }

    private void showAll () {
        System.out.println("-- Show Housing Products --");
        List<Product> products = repositoryProduct.findAllByType("Housing");

        if(products!=null){
            for(Product product : products){
                System.out.println(product);
            }
        }else{
            System.out.println("no product found");
        }
    }
}
