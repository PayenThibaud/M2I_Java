package org.example.Exo_Royaume.Hero.competences;

import org.example.Exo_Royaume.Hero.enums.PouvoirMagique;

public class Magie {

    private PouvoirMagique pouvoirMagique;
    private int level;

    public Magie(PouvoirMagique pouvoirMagique, int level) {
        this.pouvoirMagique = pouvoirMagique;
        this.level = level;
    }

    public PouvoirMagique getPouvoirMagique() {
        return pouvoirMagique;
    }
    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return pouvoirMagique + " niv " + level;
    }


}
