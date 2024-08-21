package org.example.tp.batiment;

public class Caserne extends BatimentProd{
    private int nbrSoldat;

    private Caserne (CaserneBuilder builder){
        this.style = builder.style;
        this.taille = builder.taille;
        this.nbrSoldat = builder.nbrSoldat;
    }

    public static class CaserneBuilder extends AbstractBatimentBuilder {
        private String style;
        private int taille;
        private int nbrSoldat;



        public CaserneBuilder style (String style){
            this.style = style;
            return this;
        }

        public CaserneBuilder taille (int taille){
            this.taille = taille;
            return this;
        }

        public CaserneBuilder nbrSoldat (int nbrSoldat){
            this.nbrSoldat = nbrSoldat;
            return this;
        }

        @Override
        public Batiment build() {
            return new Caserne(this);
        }
    }
}
