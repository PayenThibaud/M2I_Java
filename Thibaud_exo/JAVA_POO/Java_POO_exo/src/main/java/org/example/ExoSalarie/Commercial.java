package org.example.ExoSalarie;

public class Commercial extends Salarier {
    private double chiffreAffaire;
    private double commissionPourcentage;



    public Commercial(int matricule, String service, String categorie, String nom, int sal, double chiffreAffaire, double commissionPourcentage) {
        super(matricule, service, categorie, nom, sal);
        this.chiffreAffaire = chiffreAffaire;
        this.commissionPourcentage = commissionPourcentage;
    }

    public double getChiffreAffaire() {
        return chiffreAffaire;
    }

    public void setChiffreAffaire(double chiffreAffaire) {
        this.chiffreAffaire = chiffreAffaire;
    }

    public double getCommissionPourcentage() {
        return commissionPourcentage;
    }

    public void setCommissionPourcentage(double commissionPourcentage) {
        this.commissionPourcentage = commissionPourcentage;
    }


    public void afficherSalaire() {
        double commission = chiffreAffaire * (commissionPourcentage / 100);
        double salaireReel = salaire + commission;
        System.out.println("Salaire réel : " + salaireReel);
    }

    @Override
    public String toString() {
        return "Commercial {matricule=" + matricule + ", service='" + service + "', categorie='" + categorie + "', nom='" + nom + "', salaire=" + salaire + ", chiffre d'affaire=" + chiffreAffaire + ", commission pourcentage=" + commissionPourcentage + "}";
    }
}
