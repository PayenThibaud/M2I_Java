package org.example.Exo_Royaume.Royaume.abstracts;

import org.example.Exo_Royaume.Royaume.enums.Style;
import org.example.Exo_Royaume.Royaume.enums.Taille;

public abstract class Batiment {
    protected Taille taille;
    protected Style style;
    protected String nom;

    public Batiment(Taille taille, Style style, String nom) {
        this.taille = taille;
        this.style = style;
        this.nom = nom;
    }
    
    public Taille getTaille() {
        return taille;
    }
    public void setTaille(Taille taille) {
        this.taille = taille;
    }
    public Style getStyle() {
        return style;
    }
    public void setStyle(Style style) {
        this.style = style;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }


    @Override
    public String toString() {
        return nom + " sa taille est " + taille + ", avec un style " + style;
    }
}
