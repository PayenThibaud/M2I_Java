package org.example.Exercice1;

public class Main {
    public static void main(String[] args) {
        Chaise chaise = new Chaise();
        Chaise chaise2 = new Chaise(6,"Plastique","Bleu");
        System.out.println(chaise);
        chaise2.afficher();
    }
}
