package org.example.Exo3;

public class WaterTank {
    private int poidsVide;
    private int capaciterTotal;
    private int niveauRemplissage;

    private static int poidsEauTotal = 0;

    public WaterTank() {
    }

    public WaterTank(int poidsVide, int capaciterTotal, int niveauRemplissage) {
        this.capaciterTotal = capaciterTotal;
        this.niveauRemplissage = niveauRemplissage;
        this.poidsVide = poidsVide;
        poidsEauTotal += niveauRemplissage;
    }

    public void getPoidsVide() {
        System.out.println("Poids Vide: " + this.poidsVide);
    }

    public void getPoidsTotal() {
        System.out.println("Poids total: " + (this.poidsVide + this.niveauRemplissage));
    }

    public void remplirCiterne(int nombreLitre){
        if (this.capaciterTotal >= this.niveauRemplissage + nombreLitre){
            this.niveauRemplissage += nombreLitre;
            this.poidsEauTotal += nombreLitre;
            System.out.println("Citer niveau: " + this.niveauRemplissage);
        } else {
            nombreLitre = nombreLitre - this.capaciterTotal + this.niveauRemplissage;
            this.poidsEauTotal += (this.capaciterTotal - this.niveauRemplissage);
            this.niveauRemplissage = this.capaciterTotal;
            System.out.println("Citer niveau: " + this.capaciterTotal + " avec un exces de " + (nombreLitre));
        }
    }

    public void viderCiterne(int nombreLitre) {
        if (this.niveauRemplissage >= nombreLitre) {
            this.niveauRemplissage -= nombreLitre;
            this.poidsEauTotal -= nombreLitre;
            System.out.println("Citerne niveau: " + this.niveauRemplissage);
        } else {
            nombreLitre = nombreLitre - this.niveauRemplissage;
            this.poidsEauTotal -= this.niveauRemplissage;
            this.niveauRemplissage = 0;
            System.out.println("Citerne niveau: " + this.niveauRemplissage + " avec un manque de " + nombreLitre);
        }
    }

    public static void getPoidsEauTotal() {
        System.out.println("Poids total en eau des citernes: " + poidsEauTotal);
    }


}
