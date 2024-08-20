package org.example.demo_builder;

public class Voiture {
    private String couleur;
    private String marque;
    private String numeroSerie;
    private int nbrRoue;
    private int nbrPorte;
    private int reservoire;

    private Voiture (VoitureBuilder builder){
        this.couleur = builder.couleur;
        this.marque = builder.marque;
        this.numeroSerie = builder.numeroSerie;
        this.nbrRoue = builder.nbrRoue;
        this.nbrPorte = builder.nbrPorte;
        this.reservoire = builder.reservoire;
    }

    public static class VoitureBuilder implements IVoitureBuilder{
        private String couleur;
        private String marque;
        private String numeroSerie;
        private int nbrRoue;
        private int nbrPorte;
        private int reservoire;

        public VoitureBuilder couleur (String couleur){
            this.couleur = couleur;
            return this;
        }

        public VoitureBuilder marque (String marque){
            this.marque = marque;
            return this;
        }

        public VoitureBuilder numeroSerie (String numeroSerie){
            this.numeroSerie = numeroSerie;
            return this;
        }

        public VoitureBuilder nbrRoue (int nbrRoue){
            this.nbrRoue = nbrRoue;
            return this;
        }

        public VoitureBuilder nbrPorte (int nbrPorte){
            this.nbrPorte = nbrPorte;
            return this;
        }

        public VoitureBuilder reservoire (int reservoire){
            this.reservoire = reservoire;
            return this;
        }

        @Override
        public Voiture build() {
            return new Voiture(this);
        }
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "couleur='" + couleur + '\'' +
                ", marque='" + marque + '\'' +
                ", numeroSerie='" + numeroSerie + '\'' +
                ", nbrRoue=" + nbrRoue +
                ", nbrPorte=" + nbrPorte +
                ", reservoire=" + reservoire +
                '}';
    }
}
