package org.example.Exercices;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exo31ADN {
    public static void main(String[] args) {

//        System.out.println(verifADN("actacgTagctgacga"));
//        System.out.println(verifADN("abcdef"));

        String chaineAdn = saisieChaineAdn("Saisir la chaine : ");
        String sequence = saisieChaineAdn("Saisir la séquence : ");

        System.out.println("chaine : " + chaineAdn);
        System.out.println("sequence : " + sequence);

        double pourcent = pourcentageSequence(chaineAdn, sequence);
        System.out.println("Pourcentage : " + pourcent);


//        // split
//        String chaine = "1,2,3,abc,5,dhskjdfkshfkskdh,.....,.";
//        String[] chaineDecoupee = chaine.split(",");
//        System.out.println(Arrays.toString(chaineDecoupee));
    }

    public static boolean verifADN(String chaineAdn) {
//        //première version
//        for(int i = 0; i < chaineAdn.length(); i++){
//            if(!"actg".contains(Character.toString(chaineAdn.charAt(i))))
//                return false;
//        }
//        return true;

//        //seconde version
//        // convertir la chaine en tableau
//        String[] chaineAdnSplit = chaineAdn.split("");
//        for (String charAdn : chaineAdnSplit) {
//            if (!"actg".contains(charAdn)) {
//                return false;
//            }
//        }
//        return true;


        // en une ligne
        return chaineAdn.matches("[atcgATCG]+");
    }

    public static String saisieChaineAdn(String messageAffiche) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(messageAffiche);
        String chaine = scanner.nextLine()
                .trim()         // retire les espaces avant et après
                .toLowerCase(); // minuscule
        while (!verifADN(chaine)){
            System.out.print("ERREUR ! " + messageAffiche);
            chaine = scanner.nextLine().trim().toLowerCase();
        }
        return chaine;
    }

    public static double pourcentageSequence(String chaineAdn, String sequence) {
//        double occurences = 0;
//
//        for (int i = 0; i < chaineAdn.length(); i++) {
//            if (chaineAdn.startsWith(sequence, i)) { // commence par
//                occurences += sequence.length(); // on saute en cas de chaine trouvée pour optimiser
//                i += sequence.length();
//            }
//        }
//
//        return (int) (occurences / chaineAdn.length() * 100);

        Pattern pattern = Pattern.compile(sequence);
        Matcher matcher = pattern.matcher(chaineAdn);
        int occurrences = 0;

        // tant qu'il y a la sequence dans la chaine de caractère l'occurences s'incrémente de 1
        while (matcher.find()) {
            occurrences++;
        }
        return (double) occurrences * sequence.length() / chaineAdn.length() * 100;
    }
}
