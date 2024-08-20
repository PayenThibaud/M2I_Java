package org.example.tp.batiment;

public class Forge extends BatimentProd{

    private float ratioProd;

    private Forge (ForgeBuilder builder){
        this.style = builder.style;
        this.taille = builder.taille;
        this.ratioProd = builder.ratioProd;
    }

    public static class ForgeBuilder extends AbstractBatimentBuilder {
        private String style;
        private int taille;
        private float ratioProd;

        public ForgeBuilder style (String style){
            this.style = style;
            return this;
        }

        public ForgeBuilder taille (int taille){
            this.taille = taille;
            return this;
        }

        public ForgeBuilder ratioProd (float ratioProd){
            this.ratioProd = ratioProd;
            return this;
        }

        @Override
        public Batiment build() {
            return new Forge(this);
        }
    }
}
