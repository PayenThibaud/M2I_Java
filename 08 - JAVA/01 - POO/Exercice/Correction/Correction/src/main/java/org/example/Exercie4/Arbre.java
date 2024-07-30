package org.example.Exercie4;

public class Arbre extends Plante{

    private float circonference;
    public Arbre(float circonference,String nom, float hauteur, String couleurFeuille) {
        super(nom, hauteur, couleurFeuille);
        this.circonference = circonference;
    }

    @Override
    public void affichage() {
        super.affichage();
        System.out.println(", circonference : "+circonference);
    }
}
