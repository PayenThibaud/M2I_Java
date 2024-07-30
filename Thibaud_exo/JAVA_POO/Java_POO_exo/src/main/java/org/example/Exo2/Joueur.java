package org.example.Exo2;

public class Joueur {
    private String nom;
    private int exp;
    private int niveau;

    private static int nombreJoueurs = 0;

    public Joueur() {
        nombreJoueurs++;
    }

    public Joueur(String nom) {
        this();
        this.nom = nom;
    }

    public Joueur(String nom, int niveau, int exp) {
        this(nom);
        this.niveau = niveau;
        this.exp = exp;
    }

    public void validerLaQuete() {
        this.exp = this.exp + 50;
        System.out.println("exp du joueur est de : " +this.exp);
    }

    public void monterDeNiveau() {
        while (this.exp >= 100) {
            if (this.exp >= 100) {
                this.exp = this.exp - 100;
                this.niveau = this.niveau + 1;
                System.out.println("le niveau du joueur est de : " +this.niveau);
            }
        }
    }

}
