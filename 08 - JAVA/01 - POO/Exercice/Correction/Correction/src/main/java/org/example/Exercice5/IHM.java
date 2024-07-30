package org.example.Exercice5;

import org.example.Exercice3.WaterTank;

import java.util.Scanner;

public class IHM {

    private final Scanner scanner;

    private Salarie[] salaries = new Salarie[20];

    public IHM( ) {
        this.scanner = new Scanner(System.in);
    }

        public void startMenu(){
        while(true)
        {
            afficheMenuBase();
            String choix = scanner.nextLine();

            switch (choix){
                case "1" -> choixOne();
                case "2" -> choixTwo();
                case "3" -> choixThree();
                case "4" -> choixFour();
                case "0" -> {
                    System.out.println("Au revoir !!!");
                    return; // ou break; ou System.exit(0); (termine l'application)

                }
                default -> System.out.println("Choix invalide !!!!");
            }

        }
    }

        public void afficheMenuBase(){
        System.out.println("##### Menu Salarie #######");
        System.out.println("1) add Salarie");
        System.out.println("2) get salary from salarie");
        System.out.println("3) number total salarie");
        System.out.println("4) total salary");
        System.out.println("0) Quitter");
        System.out.print("Faite votre choix : ");
    }

        public void choixOne(){
        System.out.println("Add a salarie");
            System.out.println("Salarie matricule :");
            String matricule = scanner.nextLine();

            System.out.println("Salarie service :");
            String service = scanner.nextLine();

            System.out.println("Salarie category :");
            String category = scanner.nextLine();

            System.out.println("Salarie name :");
            String nom = scanner.nextLine();

            System.out.println("Salarie salary :");
            float salary = scanner.nextFloat();
            scanner.nextLine();

            Salarie salarie = new Salarie(matricule,service,category,nom,salary);

            for (int i = 0 ; i<salaries.length-1;i++){
                if(salaries[i] == null){
                    salaries[i] = salarie;
                    return;
                }
            }
            System.out.println("we already have 20 salaries");
    }

        public void choixTwo(){
            System.out.println("enter the salary number :");
            int indexSalarie = scanner.nextInt();
            scanner.nextLine();
            if(indexSalarie>= 0 && indexSalarie<20){
                salaries[indexSalarie].afficheSalaire();
            }

    }

        public void choixThree(){
            System.out.println("number total salarie");
            System.out.println(Salarie.getNumberSalarie());
    }

        public void choixFour(){
        System.out.println("total salary : "+Salarie.getTotalSalary()+" €");
    }

    }
