package org.example.Demos;


import java.util.Scanner;

public class Demo03Console {
    public static void main(String[] args) {
        // les differents print ( println, print, printf )

        // snippet sout
        System.out.println("Bonjour");
        System.out.println("à tous !!");
        System.out.println();
        System.out.println("#########" +
                "#" +
                "########");
        System.out.println();
        System.out.print("Bonjour");
        System
            .out
            .print(" à tous !!\n");

        // \n saut de ligne

        int age = 25;
        double poids = 70;
        String nom = "John Doe";


        // https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax
        System.out.printf("Nom : %s, Age: %d, Poids : %.2f kg\n",nom,age,poids); // à retravailler
        // voir aussi String.format(...)

        // ENTREES UTILISATEUR
        // L'objet Scanner

        Scanner scanner = new Scanner(System.in);


        // les differents next de scanner

        // demande le nom a l'utilisateur
//        System.out.println("Quel est votre nom ? "); // ne pas oublier de lui demander ce qu'il doit saisir
//        String nomUtilisateur = scanner.nextLine();
//
//        System.out.println("Votre nom : " + nomUtilisateur);
//
//
//        System.out.println("Quel est votre prenom ? ");
//        String prenomUtilisateur = scanner.next(); // moins recommandé que nextLine
//
//        System.out.println("Votre prenom : " + prenomUtilisateur);


        System.out.println("Quel est votre age ?");
        int ageUser = scanner.nextInt();
//        int ageUser = Integer.parseInt(scanner.nextLine());

        scanner.nextLine(); // recupere la touche entree (\n) laissé par le nextint

        System.out.println("Vous avez " + ageUser + " ans.");

        System.out.println("Veuillez resaisir votre votre prenom ? ");
        String prenomUtilisateur = scanner.nextLine();

        System.out.print("Bonjour ");
        System.out.println(prenomUtilisateur);

        String ageString = "123";

        ageUser = Integer.parseInt(ageString);
        double ageUserDouble = Double.parseDouble(ageString);


        // fermer le scanner
        scanner.close();
    }
}
