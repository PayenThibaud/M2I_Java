package org.example.Controller;

import org.example.Repository.RepositoryProduct;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.Scanner;

public class IHM {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Product_Jpa");
    private EntityManager em = emf.createEntityManager();
    private Scanner sc ;

    private FoodProductIhm foodProductIhm;
    private HousingProductIhm housingProductIhm;
    private ElectronicProductIhm electronicProductIhm;


    public IHM() {
        sc = new Scanner(System.in);
        foodProductIhm = new FoodProductIhm(em,sc);
        housingProductIhm = new HousingProductIhm(em,sc);
        electronicProductIhm = new ElectronicProductIhm(em,sc);

    }

    public void start (){
        int entry ;
        while (true){
            System.out.println("--- Product Application ---");
            System.out.println("1/ Food Product");
            System.out.println("2/ Housing Product");
            System.out.println("3/ Electronic Product");
            entry = sc.nextInt();
            sc.nextLine();

            switch (entry){
                case 1:
                    foodProductIhm.start();
                    break;
                case 2 :
                    housingProductIhm.start();
                    break;
                case 3:
                    electronicProductIhm.start();
                    break;
                default:
                    return;
            }
        }

    }

}
