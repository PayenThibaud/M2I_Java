package org.example.Exo_Royaume.Royaume.batiments;

import org.example.Exo_Royaume.Royaume.enums.Style;
import org.example.Exo_Royaume.Royaume.enums.Taille;
import org.example.Exo_Royaume.Royaume.abstracts.Batiment;
import org.example.Exo_Royaume.Royaume.interfaces.IForgeBuilder;

public class Forge extends Batiment {

    protected int nombreDeForge;

    public Forge(Taille taille, Style style, String nom, int nombreDeForge) {
        super(taille, style, nom);
        this.nombreDeForge = nombreDeForge;
    }

    public int getnombreDeForge() {
        return nombreDeForge;
    }

    public void setnombreDeForge(int nombreDeForge) {
        this.nombreDeForge = nombreDeForge;
    }

    @Override
    public String toString() {
        return super.toString() + ", avec " + nombreDeForge + " de casernier dedans";
    }

    public static class ForgeBuilder implements IForgeBuilder {

        private int nombreDeForge;
        private Style style;
        private String nom;
        private Taille taille;

        public ForgeBuilder nombreDeForge(int nombreDeForge) {
            this.nombreDeForge = nombreDeForge;
            return this;
        }

        public ForgeBuilder style(Style style) {
            this.style = style;
            return this;
        }

        public ForgeBuilder nom(String nom) {
            this.nom = nom;
            return this;
        }

        public ForgeBuilder taille(Taille taille) {
            this.taille = taille;
            return this;
        }

        @Override
        public Forge build() {
            return null;
        }
    }
}

