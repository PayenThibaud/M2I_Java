package org.example.ExoPlante;

public class Arbre extends Plante {

    protected int circonferenceDuTronc;

    public Arbre(String nom ,int hauteur,  String couleur, int circonferenceDuTronc){
        super(nom,hauteur,couleur);
        this.circonferenceDuTronc = circonferenceDuTronc;
    }

    public int getCirconferenceDuTronc() {
        return this.circonferenceDuTronc;
    }

    public void setCirconferenceDuTronc(int circonferenceDuTronc) {
        this.circonferenceDuTronc = circonferenceDuTronc;
    }

    @Override
    public String toString() {
        return "Arbre{nom='" + nom + "', hauteur=" + hauteur + ", couleur='" + couleur + "', circonference du tronc=" + circonferenceDuTronc + "}";
    }
}
