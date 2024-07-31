package org.example.Exercice4;

public class Main {
    public static void main(String[] args) {
        Plante plante = new Plante("tulipe",20.5f,"Rose");
        Arbre arbre = new Arbre(25.5f,"Chene",10000f,"Verte");

        plante.affichage();
        arbre.affichage();
    }
}
