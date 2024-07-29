package org.example.Exercice2;

import java.sql.Statement;

public class Joueur {
    private String nom = "";
    private int niveau = 1;
    private int xp = 0;
    private static  int nombreJoueur = 0;

    public Joueur (){
        nombreJoueur ++;
    }

    public Joueur (String nom){
        this();
        this.nom = nom;
    }

    public Joueur (String nom,int niveau, int xp){
        this(nom);
        this.niveau = niveau;
        this.xp = xp;
    }

    public void validerLaQuete (int xp){
        this.xp += xp;
        System.out.println("l'xp du joueur est de : "+this.xp);
        monterDeNiveau();
    }

    private void monterDeNiveau(){
        if(xp >= 100){
            xp = 0;
            niveau ++;
            System.out.println("le niveau du joueur est : "+niveau);
        }else{
            System.out.println("xp insuffisante");
        }
    }

    public static int getNumberJoueur(){
        return nombreJoueur;
    }
}
