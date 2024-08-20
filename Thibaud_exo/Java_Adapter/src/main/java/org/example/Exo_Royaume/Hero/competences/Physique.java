package org.example.Exo_Royaume.Hero.competences;

import org.example.Exo_Royaume.Hero.enums.AbiliterPhysique;

public class Physique {
    private AbiliterPhysique abiliterPhysique;
    private int level;

    public Physique(AbiliterPhysique abiliterPhysique, int level) {
        this.abiliterPhysique = abiliterPhysique;
        this.level = level;
    }

    public AbiliterPhysique getAbiliterPhysique() {
        return abiliterPhysique;
    }
    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return abiliterPhysique + " niv " + level;
    }

}
