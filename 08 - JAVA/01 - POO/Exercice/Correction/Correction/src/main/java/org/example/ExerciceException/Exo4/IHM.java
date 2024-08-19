package org.example.ExerciceException.Exo4;

import org.example.Exercice8.util.IHMCompte;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class IHM {

    private Scanner scanner;
    private List<Student> studentList;

    public IHM() {
        scanner = new Scanner(System.in);
        studentList  = new ArrayList<>();
    }

    public void startMenu(){
        while(true)
        {
            afficheMenuBase();
            String choix = scanner.nextLine();

            switch (choix){
                case "1" -> addEtudiant();
                case "2" -> afficherEtudiant();
                case "0" -> {
                    System.out.println("Au revoir !!!");
                    return; // ou break; ou System.exit(0); (termine l'application)

                }
                default -> System.out.println("Choix invalide !!!!");
            }

        }
    }

    private void afficheMenuBase (){
        System.out.println("""
                --- Menu Banque ---
                1/cree un etudiant
                2/afficher les etudiant
                0/quitter
                """);
    }

    private void addEtudiant (){
        System.out.println("--- ajout d'un etudiant ---");
        System.out.println("nom de l'edutiant :");
        String name = scanner.nextLine();

        while(true){
            try{
                System.out.println("entrer lage de l'etudiant");
                int age = scanner.nextInt();

                Student  student = new Student(name,age);
                studentList.add(student);
                return;
            }catch (InputMismatchException e){
                System.out.println("l'age est un entier");
            }catch (InvalidAgeException e){
                System.out.println(e.getMessage());
            }
            finally {
                scanner.nextLine();
            }
        }
    }

    private void afficherEtudiant (){
        System.out.println("--- Afficher les Etudiants ---");
        for (Student student : studentList){
            System.out.println(student);
        }
    }
}
