package org.example.Demos;

import java.util.Scanner;

public class Demo04StructureConditionnelle {
    public static void main(String[] args) {

        // Notion de Scope/Bloc d'instructions

        int b = 2;
        // bloc d'instructions
        {
            int a = 1; // variable locale au bloc
            System.out.println(a);
            System.out.println(b);
        } // à la sortie du bloc, le Garbage Collector libère la mémoire en supprimant a

//        System.out.println(a); // a n'est plus accessible
        System.out.println(b);



        // Structures Conditionnelles

        //IF
        if (true) {
            int a;
            System.out.println("C'est true !!");
        }

        if(5==9 || 4>5){
            System.out.println("C'est false !!"); // pas exécuté
        }

        if (2 < 3 && 3 < 4)
            System.out.println(); // quand on a une seule instruction les accolades sont facultatives

        if (2 < 3 && 3 < 4) System.out.println();


        // if ... else if ... else

        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir age");
        int age = scanner.nextInt();

//        if(age >=18){
//            System.out.println("Vous êtes Majeur");
//        } else {
//            System.out.println("Vous êtes Mineur");
//        }
//
//        System.out.println("Après");

        System.out.println("-----------------------------------");

//        if(!(0 < age && age < 125 ))
//        if(0 > age || age > 125)
        if(age < 0 || 125 < age){
            System.out.println("Age invalide");
        } else if(age >=18) {
            System.out.println("Vous êtes Majeur");
        } else {
            System.out.println("Vous êtes Mineur");
        }

        // autres syntaxe possible car 1 seule instruction par bloc
//        if(age < 0 || 125 < age)
//            System.out.println("Age invalide");
//        else if(age >=18)
//            System.out.println("Vous êtes Majeur");
//        else
//            System.out.println("Vous êtes Mineur");
//
//        if(age < 0 || 125 < age) System.out.println("Age invalide");
//        else if(age >=18) System.out.println("Vous êtes Majeur");
//        else System.out.println("Vous êtes Mineur");

        if (true){

        } else if (true) { // autant de "else if" que nécessaire (0-N)

        } else if (true) {

        }else if (true) {

        } else if (true) {

        }else { // au maximum un else (0-1)

        }

        // if imbriqués

        if(true){
            if(false){

            } else if (true) {
                if(true){

                }
            }
        }

        // éviter les imbrications trop profondes (notion de complexité cyclomatique)


        //switch case

//        System.out.println("Faites votre choix :");
//        System.out.println("1- Dire bonjour");
//        System.out.println("2- Dire au revoir");
//        System.out.println("3- Dire bonne nuit");
//
//        int choix = scanner.nextInt();
//
//        if (choix==1){
//            System.out.println("bonjour");
//        } else if (choix == 2) {
//            System.out.println("au revoir");
//        } else if (choix == 3) {
//            System.out.println("bonne nuit");
//        } else {
//            System.out.println("choix invalide");
//        }
//
//        // équivalent en switch
//        switch (choix){
//            case 1:
//                System.out.println("bonjour");
//                break;
//            case 2:
//                System.out.println("au revoir");
//                break;
//            case 3:
//                System.out.println("bonne nuit");
//                break;
//            default:
//                System.out.println("choix invalide");
//                break;
//        }

        System.out.println("---------------------------------------");

        // pour faire un menu, il est intéressant de garder le choix en String
        // comme ça on évite les erreurs en cas de saisie invalide
        // et on passe par le default

        System.out.println("Faites votre choix :");
        System.out.println("1- Dire bonjour");
        System.out.println("2- Dire au revoir");
        System.out.println("3- Dire bonne nuit");

        String choix = scanner.nextLine();

        switch (choix){
            case "1":
                System.out.println("bonjour");
                break;
            case "2":
                System.out.println("au revoir");
                break;
            case "3":
                System.out.println("bonne nuit");
                break;
            default:
                System.out.println("choix invalide");
                break;
        }

    }
}
