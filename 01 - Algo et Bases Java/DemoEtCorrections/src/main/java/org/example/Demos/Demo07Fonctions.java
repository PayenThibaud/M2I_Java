package org.example.Demos;

public class Demo07Fonctions {
    //    <visibilité> <mot-clés poo> <type de retour> <identificateur/symbol de la fonction>(<paramètres et leur types>){
    public static int add(int a, int b){ // a et b sont de paramètres => similaires à des variables
        int result = a + b;
        System.out.println("Result vaudra : " + result);
        return result;
    }

    // SIGNATURE => ce qui définit la fonction :
    //      - type de retour
    //      - son nom (identificateur ou symbol)
    //      - ses paramètres (variables d'entrées)
    //      + potentiellement des mots clés (static, public, private, ...)

    public static int add(int a, int b, int c){ // signature différente donc fonction différente avec le même nom => add est POLYMORPHE
        return a + b + c;
    }

    public static double add(double a, double b, double c){ // signature différente donc fonction différente avec le même nom => add est POLYMORPHE
        return a + b + c;
    }

    // les types et nombre de paramètres sont identique à add(int,int) donc c'est impoissible
//    public static double add(int int1, int int2){
//        return int1 + int2;
//    }

    // void => aucun type de retour, impossible de récupérer un résultat à l'exécution (!= null, 0 , "", '\0')
    public static void addPrint(int a, int b){
//        return; // quitte la méthode
        System.out.println("Résultat de l'addition : " + (a + b));

        return; // innutile
    }


    public static int addArray(int[] entiers){
        int somme = 0;
        for (int entier : entiers){
            somme += entier;
        }
        return somme;
    }

    // ici on accepte autant de paramètres du même type que nécessaire (on peu aussi directement mettre un tableau)
    public static int addMultipleInt(int... entiers){ // entiers est un tableau qui contiendra toutes les valeurs passées en arguments
        int somme = 0;
        for (int entier : entiers){
            somme += entier;
        }
        return somme;
    }

    public static void infinie(){
        System.out.println("Salut");
        infinie(); // récursivité => un fonction qui s'appelle elle-même
        // => StackOverflowError : on déborde de la Pile d'appel de méthodes
    }


    public static void main(String[] args) {
//        return; // sortir du main => du programme

        System.out.println("Addition de a et b :");
        int var1 = 1 ;
        int monResultat = add(var1, 2) + 10; // var1 et 2 sont des arguments => des valeurs passées aux paramètres

        System.out.println("résultat : " + monResultat);

        System.out.println("résultat add(1,2,3): " + add(1, 2, 3)); //int
        System.out.println("résultat add(1.,2.0,3): " + add(1., 2, (double) 3)); //double

        addPrint(21, 23);


        System.out.printf("%d %d %d\n",1, 2 ,2 ,3 ,4 ,5); // fonction prenant un nombre infini d'arguments

        int[] tabEntiers = {1,3,2,3};
        System.out.println(addArray(tabEntiers));

        System.out.println(addMultipleInt(1, 2, 3, 4));
        System.out.println(addMultipleInt(1));
        System.out.println(addMultipleInt(1,2));

        System.out.println(addMultipleInt(tabEntiers)); // entiers... == tabEntiers


//        infinie();
    }
}
