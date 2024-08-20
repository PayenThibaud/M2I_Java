package org.example.Exo_Royaume.Hero.abstracts;

import org.example.Exo_Royaume.Hero.competences.Magie;
import org.example.Exo_Royaume.Hero.competences.Physique;

import java.util.List;

public abstract class Personnage {
    protected String name;
    protected List<Magie> magie;
    protected List<Physique> physique;
    protected int level;
    protected int pv;
    protected int pm;
    protected int pa;

    public Personnage(String name, List<Magie> magie, List<Physique> physique, int level, int pv, int pm, int pa) {
        this.name = name;
        this.magie = magie;
        this.physique = physique;
        this.level = level;
        this.pv = pv;
        this.pm = pm;
        this.pa = pa;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Magie> getMagie() {
        return magie;
    }
    public void setMagie(List<Magie> magie) {
        this.magie = magie;
    }
    public List<Physique> getPhysique() {
        return physique;
    }
    public void setPhysique(List<Physique> physique) {
        this.physique = physique;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getPv() {
        return pv;
    }
    public void setPv(int pv) {
        this.pv = pv;
    }
    public int getPm() {
        return pm;
    }
    public void setPm(int pm) {
        this.pm = pm;
    }
    public int getPa() {
        return pa;
    }
    public void setPa(int pa) {
        this.pa = pa;
    }

    @Override
    public String toString() {
        return name + " pv : "+ pv + " level : "+ level + " pm : "+ pm + " pa : "+ pa + ", ces competences magiques : " + magie + ", ces competences physiques : " + physique;
    }
}
