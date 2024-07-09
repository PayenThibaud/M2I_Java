package org.example.Exercices;

import java.util.Scanner;

public class Exo11 {
    public static void main(String[] args) {
        double ci,t,n,cf; // capital initial,taux, nombre d'annees, capital final
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir le capital de depart : ");
        ci = scanner.nextDouble();
        System.out.println("Saisir le taux en % : ");
        t = scanner.nextDouble() / 100;
        System.out.println("Saisir le nombres d'annees : ");
        n = scanner.nextDouble();
        // récuperation utilisateur fini

        // formule pour calcul cf (capital final)
        cf = ci * Math.pow((1+t),n);

        System.out.println("Pour un montant initial de : "+ci+" avec un taux de : "+t+"% et un nombre d'annees "+n+" votre capital final sera de "+Math.round(cf)+" €");
        System.out.println("Votre gain sera de "+Math.round(cf-ci));
    }
}
