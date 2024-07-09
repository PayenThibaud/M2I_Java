package org.example.Demos;

public class Demo02Operateurs {
    public static void main(String[] args) {
        // CHAR Spéciaux

        char a = 'm';
        System.out.println(a);
        a = '\t';// tabulation
        System.out.print(a);
        System.out.println("abc");

        System.out.println("\t\tabc\ttest");
        System.out.println("\t2shshshshshshsh\tabc\ttest");

        // retour à la ligne
        System.out.println("Bonjour\n\tje\nm'appelle\n\t\tGuillaume !");

        System.out.print("\n");
        System.out.println();
        System.out.println("avant");
        System.out.println("\n\n\n");
        System.out.println("après");


        // String

        String phrase = "Ceci est une chaîne de caractères, elle est de type String";
        String phrase2 = "Ceci est une chaîne de caractères, elle est de type String".toUpperCase();
        String phrase3 = phrase.toUpperCase();

        System.out.println(phrase.toUpperCase());
        System.out.println(phrase2);
        System.out.println(phrase3);

        System.out.println(phrase.toLowerCase());

        System.out.println(phrase.charAt(5));
        System.out.println(phrase.length());
        System.out.println(phrase.equals("une autre chaine")); // ne pas utiliser l'opérateur == pour des String


        // région opérateur arithmétiques

        System.out.println("10 + 2 = " + (10 + 2) );

        System.out.println("10 - 1 = " + (10 - 1) );

        System.out.println("10 * 2 = " + (10 * 2) );

        System.out.println("10 / 2 = " + (10 / 2) );

        System.out.println("10 % 2 = " + (10 % 2) );

        //assignation combinée à arithmétiques

        int entier = 1;
        System.out.println(entier);
        entier = entier + 1;
        System.out.println(entier);
        entier += 1;
        System.out.println(entier);
        entier++;
        System.out.println(entier);

        entier--;
        System.out.println(entier);

        System.out.println("---------------------------------------");

        entier = 3;
        int apres = 0;

        apres = ++entier;
        System.out.println(entier);
        System.out.println(apres);

        apres = 0;

        apres = entier++;
        System.out.println(entier);
        System.out.println(apres);

        apres = - apres; // opérateur de négation unaire (+ => - et - => +)
        System.out.println(apres);

        System.out.println("---------------------------------------");

        // Opérateurs booléens

        // not
        System.out.println(!true);
        System.out.println(!false);
        boolean vraie = true;
        System.out.println(!vraie);

        System.out.println("---------------------------------------");
        //And
        System.out.println(true && true);
        System.out.println(true && false);
        System.out.println(false && true);
        System.out.println(false && false);

        System.out.println("---------------------------------------");
        //Or
        System.out.println(true || true);
        System.out.println(true || false);
        System.out.println(false || true);
        System.out.println(false || false);


        System.out.println("---------------------------------------");
        System.out.println(4<6 && 4>=9 && true);


        System.out.println("---------------------------------------");


        // Operateur d'egalite relationnels

        int value1 = 1;
        int value2 = 2;
        boolean resultat;


        resultat = value1 == value2;
        System.out.println(resultat); // false

        resultat = value1 != value2;
        System.out.println(resultat); // true

        resultat = value1 > value2;
        System.out.println(resultat); // false

        resultat = value1 >= 1;
        System.out.println(resultat); // true

        resultat = value1 < value2;
        System.out.println(resultat); // true

        resultat = value1 <= 2;
        System.out.println(resultat); // true


        System.out.println("---------------------------------------");

        // ET : les deux conditions doivent être vraies
        resultat = (value1 == 1) && (value2 == 2);
        System.out.println(resultat); // true

        // OU : l'une ou l'autre des conditions doit être vraie
        resultat = (value1 == 1) || (value2 == 2);
        System.out.println(resultat); // true

        System.out.println("---------------------------------------");

        String chaineA = "abc";
        String chaineB = "ab" + "c";

//        System.out.println(chaineA == chaineB); // ne pas utiliser cette méthode pour la comparaison de String

        System.out.println(chaineA.equals(chaineB));


        System.out.println("---------------------------------------");

        // concaténation
        String abc = "abc" + "def" + 1;
        System.out.println(abc);
        System.out.println(abc + " : " + abc + 234 );

        System.out.println("\t\t" + abc + "\n\t" + abc);
        System.out.println("aaaa " + 5.);

        System.out.println("---------------------------------------");

        // ternaires
        // <boolean/condition> ? <valeur si vrai> : <valeur si faux>

        String texte = 5>9 ? "Bonjour" : "Adieu";
        System.out.println(texte);


        texte = 5>9 ? "Bonjour" : (false ? "Adieu" : "Autre chose");
        System.out.println(texte);
    }
}
