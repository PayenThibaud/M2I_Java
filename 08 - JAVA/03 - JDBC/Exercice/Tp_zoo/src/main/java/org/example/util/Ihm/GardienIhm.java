package org.example.util.Ihm;

import org.example.DAO.GardienDAO;
import org.example.DAO.GardienAnimalDAO;
import org.example.entity.Gardien;
import org.example.entity.GardienAnimal;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class GardienIhm {

    private Scanner scanner;

    private GardienDAO gardienDAO;

    private GardienAnimalDAO gardienAnimalDAO;

    public GardienIhm(Scanner scanner){
        this.scanner = scanner;
        gardienDAO = new GardienDAO();
        gardienAnimalDAO = new GardienAnimalDAO();
    }

    public void start (){
        int entry;
        while(true){
            System.out.println("--- Menu Gardien ---");
            System.out.println("1/ cree un gardien");
            System.out.println("2/ liee un animal a un gardien");
            System.out.println("3/ afficher tout les gardien");
            entry = scanner.nextInt();
            scanner.nextLine();

            switch (entry){
                case 1:
                    createEnclos();
                    break;
                case 2:
                    linkAnimalToEnclos();
                    break;
                case 3 :
                    showAll();
                    break;
                default:
                    return;
            }
        }
    }


    private void createEnclos (){
        System.out.println("-- creation du gardien --");
        System.out.println("nom du gardien :");
        String name = scanner.nextLine();
        try {

            Gardien gardien = gardienDAO.save(Gardien.builder().name(name).build());
            if(gardien != null){
                System.out.println("gardien cree "+ gardien);
            }else{
                System.out.println("erreure lors de la creation");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void linkAnimalToEnclos (){
        System.out.println("-- liee un animal a un gardien --");
        System.out.println("id de l'animal :");
        int id_animal = scanner.nextInt();
        scanner.nextLine();
        System.out.println("id du gardien :");
        int id_gardien = scanner.nextInt();
        scanner.nextLine();

        try {
            GardienAnimal gardienAnimal = gardienAnimalDAO.save(GardienAnimal.builder().id_animal(id_animal).id_gardien(id_gardien).build());
            if(gardienAnimal != null){
                System.out.println("liaison cree "+ gardienAnimal);
            }else{
                System.out.println("erreure lors de la creation");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void showAll (){
        System.out.println("--- show all gardien ---");
        try {
            List<Gardien> gardiens = gardienDAO.get();
            for (Gardien gardien : gardiens){
                System.out.println(gardien);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
