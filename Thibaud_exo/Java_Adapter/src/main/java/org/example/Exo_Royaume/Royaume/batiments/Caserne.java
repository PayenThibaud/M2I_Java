package org.example.Exo_Royaume.Royaume.batiments;

import org.example.Exo_Royaume.Royaume.enums.Style;
import org.example.Exo_Royaume.Royaume.enums.Taille;
import org.example.Exo_Royaume.Royaume.interfaces.ICaserneBuilder;
import org.example.Exo_Royaume.Royaume.abstracts.Batiment;

public class Caserne extends Batiment {

    protected int nombreEquipent;


    public Caserne(CaserneBuilder builder) {
        super(builder.taille, builder.style, builder.nom);
        this.nombreEquipent = builder.nombreEquipent;
    }

    public int getnombreEquipent() {
        return nombreEquipent;
    }
    public void setnombreEquipent(int nombreEquipent) {
        this.nombreEquipent = nombreEquipent;
    }

    @Override
    public String toString() {
        return super.toString() + ", avec " + nombreEquipent + " de casernier dedans";
    }

    public static class CaserneBuilder implements ICaserneBuilder {

        private Taille taille;
        private Style style;
        private String nom;
        private int nombreEquipent;

        public CaserneBuilder taille(Taille taille) {
            this.taille = taille;
            return this;
        }

        public CaserneBuilder style(Style style) {
            this.style = style;
            return this;
        }

        public CaserneBuilder nom(String nom) {
            this.nom = nom;
            return this;
        }

        public CaserneBuilder nombreEquipent(int nombreEquipent) {
            this.nombreEquipent = nombreEquipent;
            return this;
        }

        @Override
        public Caserne build() {
            return new Caserne(this);

        }
    }
}
