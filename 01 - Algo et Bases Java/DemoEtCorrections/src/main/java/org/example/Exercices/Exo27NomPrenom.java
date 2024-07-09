package org.example.Exercices;

public class Exo27NomPrenom {
    public static String nomComplet(String prenom, String nom){
        return prenom + " " + nom;
    }

    public static void main(String[] args) {
        System.out.println(nomComplet("Guillaume", "Mairesse"));
    }
}
