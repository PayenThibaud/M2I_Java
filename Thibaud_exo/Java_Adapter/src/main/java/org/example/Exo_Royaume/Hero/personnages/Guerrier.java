package org.example.Exo_Royaume.Hero.personnages;

import org.example.Exo_Royaume.Hero.abstracts.Personnage;
import org.example.Exo_Royaume.Hero.competences.Magie;
import org.example.Exo_Royaume.Hero.competences.Physique;
import org.example.Exo_Royaume.Hero.interfaces.IGuerrierBuilder;

import java.util.List;

public class Guerrier extends Personnage {

    protected int BonusPointVie;

    public Guerrier(GuerrierBuilder builder) {
        super(builder.name, builder.magie, builder.physique, builder.level, builder.pv, builder.pm, builder.pa);
        BonusPointVie = builder.bonusPointVie;
    }

    public int getBonusPointVie() {
        return BonusPointVie;
    }
    public void setBonusPointVie(int bonusPointVie) {
        BonusPointVie = bonusPointVie;
    }

    @Override
    public String toString() {
        return super.toString() + ", bonus des guerriers, points de vie bonus : " + BonusPointVie;
    }

    public static class GuerrierBuilder implements IGuerrierBuilder {

        protected String name;
        protected List<Magie> magie;
        protected List<Physique> physique;
        protected int level;
        protected int pv;
        protected int pm;
        protected int pa;
        protected int bonusPointVie;

        public GuerrierBuilder name (String name) {
            this.name = name;
            return this;
        }
        public GuerrierBuilder magie(List<Magie> magie) {
            this.magie = magie;
            return this;
        }
        public GuerrierBuilder physique(List<Physique> physique) {
            this.physique = physique;
            return this;
        }
        public GuerrierBuilder level(int level) {
            this.level = level;
            return this;
        }
        public GuerrierBuilder pv(int pv) {
            this.pv = pv;
            return this;
        }
        public GuerrierBuilder pm(int pm) {
            this.pm = pm;
            return this;
        }
        public GuerrierBuilder pa(int pa) {
            this.pa = pa;
            return this;
        }
        public GuerrierBuilder bonusPointVie(int bonusPointVie) {
            this.bonusPointVie = bonusPointVie;
            return this;
        }

        @Override
        public Guerrier build() {
            return new Guerrier(this);
        }
    }
}
