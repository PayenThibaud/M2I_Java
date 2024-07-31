package org.example.Exercice5;

public class Commercial extends Salarie{
    private float chiffreAffaire ;
    private int commission;

    public Commercial(String matricule, String service, String categorie, String nom, float salaire) {
        super(matricule, service, categorie, nom, salaire);
    }

    public Commercial(String matricule, String service, String categorie, String nom, float salaire,float chiffreAffaire,int commission) {
        super(matricule, service, categorie, nom, salaire);
        this.chiffreAffaire = chiffreAffaire;
        this.commission = commission;
    }

    @Override
    public void afficheSalaire() {
        System.out.println("le salaire de l'employee est de : "+(salaire+(chiffreAffaire*(commission/100)))+" €");
    }

    @Override
    public String toString() {
        return super.toString()
                + ", chiffreAffaire : "+ chiffreAffaire
                + ", commission en % : "+commission ;
    }
}
