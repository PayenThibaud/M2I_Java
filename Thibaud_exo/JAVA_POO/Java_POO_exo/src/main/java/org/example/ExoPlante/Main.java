package org.example.ExoPlante;

public class Main {
        public static void main(String[] args) {
                Plante plante = new Plante("Rose", 5, "Rouge");
                Arbre arbre = new Arbre("Boulo", 55500, "Vert", 500);

               System.out.println(arbre);
               System.out.println(plante);
        }
}
