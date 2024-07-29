package org.example.Exercice2;

public class Main {
    public static void main(String[] args) {
        Joueur joueur = new Joueur("Player1");
        Joueur joueur1 = new Joueur();
        joueur.validerLaQuete(20);
        joueur.validerLaQuete(90);

        System.out.println(Joueur.getNumberJoueur());
    }
}
