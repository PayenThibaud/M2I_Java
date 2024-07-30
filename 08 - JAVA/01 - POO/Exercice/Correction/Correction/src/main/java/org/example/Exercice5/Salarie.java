package org.example.Exercice5;

public class Salarie {
    protected String matricule;
    protected String service;
    protected String categorie;
    protected String nom;
    protected float salaire;

    private static int numberSalarie = 0;
    private static float totalSalary = 0;

    public Salarie(String matricule, String service, String categorie, String nom, float salaire) {
        this.matricule = matricule;
        this.service = service;
        this.categorie = categorie;
        this.nom = nom;
        this.salaire = salaire;
        numberSalarie++;
        totalSalary+= salaire;
    }

    public void afficheSalaire  (){
        System.out.println("Le salaire de mon employée est de : "+ salaire+" €" );
    }

    public static int getNumberSalarie() {
        return numberSalarie;
    }

    public static float getTotalSalary() {
        return totalSalary;
    }

    public static void resetSalarieAndSalary (){
        numberSalarie = 0;
        totalSalary = 0;
    }
}
