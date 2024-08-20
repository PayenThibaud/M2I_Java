package org.example.Exo_Royaume.Hero.personnages;

import org.example.Exo_Royaume.Hero.abstracts.Personnage;
import org.example.Exo_Royaume.Hero.competences.Magie;
import org.example.Exo_Royaume.Hero.competences.Physique;
import org.example.Exo_Royaume.Hero.interfaces.IRoiBuilder;

import java.util.List;

public class Roi extends Personnage {

    protected int BonusPointVie;

    public Roi(RoiBuilder builder) {
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
        return super.toString() + ", bonus du roi, invicible";
    }

    public static class RoiBuilder implements IRoiBuilder {

        protected String name;
        protected List<Magie> magie;
        protected List<Physique> physique;
        protected int level;
        protected int pv;
        protected int pm;
        protected int pa;
        protected int bonusPointVie;

        public RoiBuilder name (String name) {
            this.name = name;
            return this;
        }
        public RoiBuilder magie(List<Magie> magie) {
            this.magie = magie;
            return this;
        }
        public RoiBuilder physique(List<Physique> physique) {
            this.physique = physique;
            return this;
        }
        public RoiBuilder level(int level) {
            this.level = level;
            return this;
        }
        public RoiBuilder pv(int pv) {
            this.pv = pv;
            return this;
        }
        public RoiBuilder pm(int pm) {
            this.pm = pm;
            return this;
        }
        public RoiBuilder pa(int pa) {
            this.pa = pa;
            return this;
        }
        public RoiBuilder bonusPointVie(int bonusPointVie) {
            this.bonusPointVie = bonusPointVie;
            return this;
        }

        @Override
        public Roi build() {
            return new Roi(this);
        }
    }
}
