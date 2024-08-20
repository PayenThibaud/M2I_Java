package org.example.tp.batiment;

public abstract class Batiment {
    protected String style;
    protected int taille;

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
