package org.example.Exo_Royaume.Hero.personnages;

import org.example.Exo_Royaume.Hero.abstracts.Personnage;
import org.example.Exo_Royaume.Hero.competences.Magie;
import org.example.Exo_Royaume.Hero.competences.Physique;
import org.example.Exo_Royaume.Hero.interfaces.IArcherBuilder;

import java.util.List;

public class Archer extends Personnage {

    protected int BonusPointAgiliter;

    public Archer(ArcherBuilder build) {
        super(build.name, build.magie, build.physique, build.level, build.pv, build.pm, build.pa);
        BonusPointAgiliter = build.bonusPointAgiliter;
    }

    public int getBonusPointAgiliter() {
        return BonusPointAgiliter;
    }
    public void setBonusPointAgiliter(int bonusPointAgiliter) {
        BonusPointAgiliter = bonusPointAgiliter;
    }

    @Override
    public String toString() {
        return super.toString() + ", bonus des Archers, Points d agiliter bonus : " + BonusPointAgiliter;
    }

    public static class ArcherBuilder implements IArcherBuilder {

        protected String name;
        protected List<Magie> magie;
        protected List<Physique> physique;
        protected int level;
        protected int pv;
        protected int pm;
        protected int pa;
        protected int bonusPointAgiliter;

        public ArcherBuilder name (String name) {
            this.name = name;
            return this;
        }
        public ArcherBuilder magie(List<Magie> magie) {
            this.magie = magie;
            return this;
        }
        public ArcherBuilder physique(List<Physique> physique) {
            this.physique = physique;
            return this;
        }
        public ArcherBuilder level(int level) {
            this.level = level;
            return this;
        }
        public ArcherBuilder pv(int pv) {
            this.pv = pv;
            return this;
        }
        public ArcherBuilder pm(int pm) {
            this.pm = pm;
            return this;
        }
        public ArcherBuilder pa(int pa) {
            this.pa = pa;
            return this;
        }
        public ArcherBuilder bonusPointAgiliter(int bonusPointAgiliter) {
            this.bonusPointAgiliter = bonusPointAgiliter;
            return this;
        }

        @Override
        public Archer build() {
            return new Archer(this);
        }
    }
}
