package org.example.Exercices;

public class Exo18Population {
    public static void main(String[] args) {
//        int nobreAnnees = 0;
//        while (96809 * Math.pow(1 + 0.0089, nobreAnnees) < 120000) {
//            nobreAnnees = nobreAnnees + 1;
//        }
//        System.out.println("Au bout de " + nobreAnnees
//                + " ans à partir de 2015, Tourcoing aura dépassé les 120000 habitants. Nous serons en "
//                + (2015 + nobreAnnees));


        final double TAUX = 0.0089;
        final int OBJECTIF_HABITANTS = 120000;

        double habitants = 96809;

        int nbAnnees = 0;

        while (habitants < OBJECTIF_HABITANTS) {
//            habitants += habitants * TAUX;
            habitants *= 1 + TAUX;
            nbAnnees++;
        }

        System.out.printf("Il faudra %d année%s à la la ville de Tourcoing pour atteindre %d habitant%s.",
                nbAnnees,
                (nbAnnees > 1? "s" : ""),
                OBJECTIF_HABITANTS,
                (OBJECTIF_HABITANTS > 1? "s" : "")
        );
    }
}
