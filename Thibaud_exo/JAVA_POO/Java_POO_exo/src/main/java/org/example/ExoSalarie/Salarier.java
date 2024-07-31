package org.example.ExoSalarie;

public class Salarier {
    protected int matricule;
    protected String service;
    protected String categorie;
    protected String nom;
    protected int salaire;

    private static int totalEmployes = 0;
    private static int salaireTotal = 0;

    public Salarier() {
        totalEmployes++;
    }

    public Salarier(int matricule, String service, String categorie, String nom, int sal) {
        this.matricule = matricule;
        this.service = service;
        this.categorie = categorie;
        this.nom = nom;
        this.salaire = sal;

        totalEmployes++;
        salaireTotal += sal;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        salaireTotal -= this.salaire;
        this.salaire = salaire;
        salaireTotal += salaire;
    }

    public static int getTotalEmployes() {
        return totalEmployes;
    }

    public static int getSalaireTotal() {
        return salaireTotal;
    }

    public static void resetTotalEmployes() {
        totalEmployes = 0;
    }

    @Override
    public String toString() {
        return "Salarier {matricule=" + matricule + ", service='" + service + "', categorie='" + categorie + "', nom='" + nom + "', salaire=" + salaire + "}";
    }
}
