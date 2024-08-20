package org.example.Exo_Royaume.Hero.personnages;

import org.example.Exo_Royaume.Hero.abstracts.Personnage;
import org.example.Exo_Royaume.Hero.competences.Magie;
import org.example.Exo_Royaume.Hero.competences.Physique;
import org.example.Exo_Royaume.Hero.interfaces.IMageBuilder;

import java.util.List;

public class Mage extends Personnage {

    protected int BonusPointMagique;


    public Mage(MageBuilder builder) {
        super(builder.name, builder.magie, builder.physique, builder.level, builder.pv, builder.pm, builder.pa);
        BonusPointMagique = builder.bonusPointMagique;
    }

    public int getBonusPointMagique() {
        return BonusPointMagique;
    }
    public void setBonusPointMagique(int bonusPointMagique) {
        BonusPointMagique = bonusPointMagique;
    }

    @Override
    public String toString() {
        return super.toString() + ", bonus des Mages, bonus points de magie : " + BonusPointMagique;
    }

    public static class MageBuilder implements IMageBuilder{

        protected String name;
        protected List<Magie> magie;
        protected List<Physique> physique;
        protected int level;
        protected int pv;
        protected int pm;
        protected int pa;
        protected int bonusPointMagique;

        public MageBuilder magie (List<Magie> magie) {
            this.magie = magie;
            return this;
        }
        public MageBuilder physique (List<Physique> physique) {
            this.physique = physique;
            return this;
        }
        public MageBuilder level (int level) {
            this.level = level;
            return this;
        }
        public MageBuilder pv (int pv) {
            this.pv = pv;
            return this;
        }
        public MageBuilder pm (int pm) {
            this.pm = pm;
            return this;
        }
        public MageBuilder pa (int pa) {
            this.pa = pa;
            return this;
        }
        public MageBuilder bonusPointMagique (int bonusPointMagique) {
            this.bonusPointMagique = bonusPointMagique;
            return this;
        }
        public MageBuilder name (String name) {
            this.name = name;
            return this;
        }

        @Override
        public Mage build() {
            return new Mage(this);
        }
    }
}
