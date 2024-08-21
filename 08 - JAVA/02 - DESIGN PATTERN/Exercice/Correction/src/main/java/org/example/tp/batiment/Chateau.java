package org.example.tp.batiment;

import java.util.List;

public class Chateau extends Batiment{

    private List<BatimentProd> Batiment ;

    private Chateau (ChateauBuilder builder){
        this.style = builder.style;
        this.taille = builder.taille;
        this.Batiment = builder.batiment;
    }

    public static class ChateauBuilder extends AbstractBatimentBuilder {
        private String style;
        private int taille;
        private List<BatimentProd> batiment;

        public ChateauBuilder style (String style){
            this.style = style;
            return this;
        }

        public ChateauBuilder taille (int taille){
            this.taille = taille;
            return this;
        }

        public ChateauBuilder batiment (List<BatimentProd> batiment){
            this.batiment = batiment;
            return this;
        }

        @Override
        public Batiment build() {
            return new Chateau(this);
        }
    }

    @Override
    public String toString() {
        return "Chateau{" +
                "Batiment=" + Batiment +
                ", style='" + style + '\'' +
                ", taille=" + taille +
                '}';
    }
}
