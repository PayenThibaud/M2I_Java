package org.example.Exercice7;

import org.example.Exercice7.animaux.Animal;
import org.example.Exercice7.animaux.Elephant;
import org.example.Exercice7.animaux.Lion;
import org.example.Exercice7.enclos.EnclosDesElephants;
import org.example.Exercice7.enclos.EnclosDesLions;
import org.example.Exercice7.interfaces.Enclos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zoo {
    private static final List<EnclosDesLions> enclosLions = new ArrayList<>();
    private static final List<EnclosDesElephants> enclosDesElephants = new ArrayList<>();

    public static void init() {
        Lion steve = new Lion("Steve", 10);
        Lion lana = new Lion("Lana", 11);
        Lion simba = new Lion("Simba", 3);
        Lion nala = new Lion("Nala", 2);

        Elephant elmer = new Elephant("Elmer", 15, 400);
        Elephant dumbo = new Elephant("Dumbo", 3, 120);
        Elephant hathi = new Elephant("Hathi", 45, 875);
        Elephant tantor = new Elephant("Tantor", 12, 384);

        EnclosDesLions lions = new EnclosDesLions();
        EnclosDesElephants elephants = new EnclosDesElephants();

        lions.ajouterAnimal(steve);
        lions.ajouterAnimal(lana);
        lions.ajouterAnimal(simba);
        lions.ajouterAnimal(nala);

        elephants.ajouterAnimal(elmer);
        elephants.ajouterAnimal(dumbo);
        elephants.ajouterAnimal(hathi);
        elephants.ajouterAnimal(tantor);

        enclosLions.add(lions);
        enclosDesElephants.add(elephants);
    }

    public static void menuAjouterElephant(EnclosDesElephants enclosDesElephants) {
        System.out.print("-- Ajout d'un Elephant --\nnom: ");
        Scanner sc = new Scanner(System.in);
        String nom = sc.nextLine();
        System.out.print("age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("poids: ");
        float poids = sc.nextFloat();
        sc.nextLine();
        enclosDesElephants.ajouterAnimal(new Elephant(nom, age, poids));
    }

    public static void menuAjouterLion(EnclosDesLions enclosDesLions) {
        System.out.print("-- Ajout d'un lion --\nnom: ");
        Scanner sc = new Scanner(System.in);
        String nom = sc.nextLine();
        System.out.print("age: ");
        int age = sc.nextInt();
        sc.nextLine();
        enclosDesLions.ajouterAnimal(new Lion(nom, age));
    }

    public static void menuEnclosLions(EnclosDesLions enclosDesLions) {
        while (true) {
            System.out.print("""
                    -- Menu Enclos --
                    type: Lion
                    1-- Afficher
                    2-- Ajouter Lion
                    0-- Annuler
                    
                    >\s""");

            Scanner sc = new Scanner(System.in);
            String choix = sc.nextLine();

            switch (choix) {
                case "1" -> enclosDesLions.afficherAnimaux();
                case "2" -> menuAjouterLion(enclosDesLions);
                case "0" -> {
                    return;
                }
                default -> System.out.println("Erreur de Saisie!");
            }
        }
    }

    public static void menuEnclosElephants(EnclosDesElephants enclosDesElephants) {
        while (true) {
            System.out.print("""
                    -- Menu Enclos --
                    type: Elephant
                    1-- Afficher
                    2-- Ajouter Elephant
                    0-- Annuler
                    
                    >\s""");

            Scanner sc = new Scanner(System.in);
            String choix = sc.nextLine();

            switch (choix) {
                case "1" -> enclosDesElephants.afficherAnimaux();
                case "2" -> menuAjouterElephant(enclosDesElephants);
                case "0" -> {
                    return;
                }
                default -> System.out.println("Erreur de Saisie!");
            }
        }
    }

    public static void listeEnclos() {
        StringBuilder str = new StringBuilder();
        str.append("-- Liste des enclos --\n");
        str.append("Nombre d'enclos : ").append(enclosLions.size() + enclosDesElephants.size()).append("\n");

        int i = 1;
        for (EnclosDesLions enclosDesLion : enclosLions) {

            str.append(i).append("-- ").append(enclosDesLion.toString()).append("\n");
            i++;
        }
        for (EnclosDesElephants enclosDesElephants : enclosDesElephants) {
            str.append(i).append("-- ").append(enclosDesElephants.toString()).append("\n");
            i++;
        }
        str.append("0-- Retour\n\nEntrez numéro de l'enclos pour afficher son menu: ");
        while (true) {
            System.out.print(str);

            Scanner sc = new Scanner(System.in);
            int choix = sc.nextInt();
            sc.nextLine();

            if (choix == 0) {
                return;
            }

            if (choix <= enclosLions.size()) {
                menuEnclosLions(enclosLions.get(choix - 1));
                return;
            } else if (choix - enclosLions.size() <= enclosDesElephants.size()) {
                menuEnclosElephants(enclosDesElephants.get(choix - enclosLions.size() - 1));
                return;
            } else {
                System.out.println("Erreur de Saisie!");
            }
        }
    }

    public static void menuEnclos() {
        while (true) {
            System.out.print("""
                    -- Ajouter Enclos --
                    Type:
                    1-- Ajouter Enclos de Lion
                    2-- Ajouter Enclos d'Elephant
                    0-- Annuler
                    
                    >\s""");
            Scanner sc = new Scanner(System.in);
            String choix = sc.nextLine();
            switch (choix) {
                case "1" -> enclosLions.add(new EnclosDesLions());
                case "2" -> enclosDesElephants.add(new EnclosDesElephants());
                case "0" -> {return;}
                default -> System.out.println("Erreur de Saisie!");
            }
        }
    }

    public static void main(String[] args) {
        init();

        while (true) {
            System.out.print("""
                    == Gestion du Zoo ==
                    1-- Liste des enclos
                    2-- Ajouter un enclos
                    0-- Quitter
                    
                    >\s""");
            Scanner sc = new Scanner(System.in);
            String choix = sc.nextLine();

            switch (choix) {
                case "1" -> listeEnclos();
                case "2" -> menuEnclos();
                case "0" -> {return;}
                default -> System.out.println("Erreur de Saisie!");
            }
        }
    }

}
