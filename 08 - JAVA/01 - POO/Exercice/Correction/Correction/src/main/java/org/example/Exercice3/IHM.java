package org.example.Exercice3;

import java.util.List;
import java.util.Scanner;

public class IHM {

    private final Scanner scanner;
    private final WaterTank[] waterTanks = {new WaterTank(300f,2000),new WaterTank(600f,4000)};

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
        System.out.println("##### Menu Citerne #######");
        System.out.println("1) remplir une citerne");
        System.out.println("2) vider une citerne");
        System.out.println("3) poids total d'une citerne");
        System.out.println("4) contenace total de tout nos citerne");
        System.out.println("0) Quitter");
        System.out.print("Faite votre choix : ");
    }

    public void choixOne(){
        System.out.println("""
                1/ citerne 1
                2/ citerne 2
                """);
        int citerneNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Conbien de litre a ajouter ?");
        int litre = scanner.nextInt();
        scanner.nextLine();

        int surplus = waterTanks[citerneNumber-1].remplir(litre);

        System.out.println(surplus > 0 ? surplus+" litre en trop" : "eau ajouté a la citerne");
        waterTanks[citerneNumber-1].affichageCiterne();
    }

    public void choixTwo(){
        System.out.println("""
                1/ citerne 1
                2/ citerne 2
                """);
        int citerneNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Conbien de litre a retirer ?");
        int litre = scanner.nextInt();
        scanner.nextLine();

        int eauRecu = waterTanks[citerneNumber-1].vider(litre);

        System.out.println(eauRecu > 0 ? eauRecu+" litre recus" : "il n'y a plus d'eau dans la citerne");
        waterTanks[citerneNumber-1].affichageCiterne();
    }

    public void choixThree(){
        System.out.println("""
                1/ citerne 1
                2/ citerne 2
                """);
        int citerneNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.println("La citerne fait : "+waterTanks[citerneNumber-1].poidTotal()+" kg");
    }

    public void choixFour(){
        System.out.println("Les citernes ont : "+WaterTank.getAllQuatityFronWaterTank()+" litres d'eau");
    }

}
