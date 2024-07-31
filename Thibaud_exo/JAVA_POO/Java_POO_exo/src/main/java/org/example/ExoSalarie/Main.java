package org.example.ExoSalarie;

public class Main {
    public static void main(String[] args) {

        Salarier s1 = new Salarier(1, "IT", "Dev", "Bob", 3000);

        System.out.println(s1.toString());

        System.out.println(s1.getSalaire());

        Commercial c1 = new Commercial(2, "Vente", "V", "Toto", 2500, 50000, 10);
        Commercial c2 = new Commercial(3, "Vente", "T", "Titi", 2700, 60000, 15);

        System.out.println(c1.toString());
        System.out.println(c2.toString());

        c1.afficherSalaire();
        c2.afficherSalaire();

        System.out.println("Total Employés : " + Salarier.getTotalEmployes());
        System.out.println("Salaire Total (sans commision) : " + Salarier.getSalaireTotal());

        Salarier.resetTotalEmployes();

        System.out.println("On ferme la boite, nombre d employer : " + Salarier.getTotalEmployes());
    }
}
