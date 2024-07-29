package org.example;

import org.example.Demo1.MaClasse;
import org.example.Demo1.Voiture;

public class Main {
    public static void main(String[] args) {
//        MaClasse monObjet = new MaClasse();

        Voiture maVoiture = new Voiture("modele","rouge",63,755);
        Voiture voiture = new Voiture();
        maVoiture.setModel("Fiat");


        maVoiture.afficher();
        maVoiture.demarrer();
        maVoiture.demarrer();

        System.out.println("nombre de voiture : "+Voiture.getNombreVoiture());

    }
}