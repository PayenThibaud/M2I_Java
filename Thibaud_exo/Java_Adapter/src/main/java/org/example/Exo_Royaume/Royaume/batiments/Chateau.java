package org.example.Exo_Royaume.Royaume.batiments;

import org.example.Exo_Royaume.Royaume.enums.Taille;
import org.example.Exo_Royaume.Royaume.abstracts.Batiment;
import org.example.Exo_Royaume.Royaume.enums.Style;
import org.example.Exo_Royaume.Royaume.interfaces.IChateauBuilder;

public class Chateau extends Batiment {

    protected int citoyen;


    public Chateau(ChateauBuilder builder) {
        super(builder.taille, builder.style, builder.nom);
        this.citoyen = builder.citoyen;
    }

    public int getcitoyen() {
        return citoyen;
    }
    public void setcitoyen(int citoyen) {
        this.citoyen = citoyen;
    }

    @Override
    public String toString() {
        return super.toString() + ", avec " + citoyen + " de noble dedans";
    }

    public static class ChateauBuilder implements IChateauBuilder{

        private Taille taille;
        private Style style;
        private String nom;
        private int citoyen;

        public ChateauBuilder taille (Taille taille) {
            this.taille = taille;
            return this;
        }

        public ChateauBuilder style (Style style) {
            this.style = style;
            return this;
        }

        public ChateauBuilder nom (String nom) {
            this.nom = nom;
            return this;
        }

        public ChateauBuilder citoyen (int citoyen) {
            this.citoyen = citoyen;
            return this;
        }

        @Override
        public Chateau build() {
            return new Chateau(this);
        }
    }
}

