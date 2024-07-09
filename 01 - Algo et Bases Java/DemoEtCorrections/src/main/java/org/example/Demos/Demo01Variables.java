package org.example.Demos;

public class Demo01Variables {
    public static void main(String[] args) {

        // Commentaires

        // Un Commentaire dans le code
        // pas interprété par le compilateur
        // présent pour expliquer le code par exemple

        int i; // commentaire de line

        /*
        Un
        commentaire
        multi-lignes
         */

        System.out.println("Demo n°1" /*commentaire dans la ligne (inline)*/);

        // Déclaration d'une variable

        // syntaxe
        // <type> <nom>;

        // ENTIERS

        // int entier sur 32 bits
        int age;
        // int age; // un identificateur est unique pour le scope

        long indice; // long entier sur 64 bits
        short indice2; // short entier sur 16 bits
        byte indice3; // byte entier sur 8 bits

        // REELS

        float distance; // 32 bits => moins précis
        double poids; // 64 bits => plus précis

        // CARACTÈRES
        char lettre;

        // BOOLEENS
        boolean estVrai;
        boolean estMineur;
        boolean a30Ans;

        // CHAINE DE CARACTÈRES
        String alphabet;


        //Affectation/assignation de données
        //<nom> = <valeur>;
        alphabet = "abcdefghij";

        //Déclaration puis Affectation/assignation de données
        //<type> <nom> = <valeur>;
        int entier = 23;


        // Affectation
        age = 35;
        distance = 12.74f;
        double monnaie = 15.5;
        estVrai = false;
        lettre = 'a';
        String prenom = "toto";


        i = 12;
        i = 12 + 1;
        i = i + 1;
        System.out.println(i+1);

        // valeurs typées

        // ENTIERS

        byte a1 = 1;
//        a1 = 1000000
        short a2 = 2;


        int a3;
        long a4;
//        a3= 1000000000000; // trop grand

//        a4= 1000000000000;// on est par défaut sur un int, trop grand
        a4= 1000000000000l + 1;// on est maintenant sur un long, grace au 'l' à la fin

        a2 = a1; // byte vers short => possible (cast implicite car les types sont compatibles)

//        a1 = a4; // long vers byte impossible (trop grand)
        a1 = (byte) a4; // long vers byte précisé explicitement (notion de transtypage/cast)


        // REELS

        float b1;
//        b1 = 12.0; // par défaut double
        b1 = 12.0f; // f pour float

        double b2;

//        b2 = 3.0/6; // => normalement égal à 0.5 mais division de 2 entiers donc => 0
        b2 = 3./6; // => égal à 0.5 (3 en tant que double)
        System.out.println("0.5 => " + b2);


        // BOOLEENS
        boolean vrai = true;
        boolean faux = false;

        // valeur par défaut
        int a;
        double b;
        char c;
        boolean d;
        String e;

        // les variables ne sont pas initialisées => erreur
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//        System.out.println(d);
//        System.out.println(e);


//        String chaineDeCaractères = "abcdefg";
    }
}
