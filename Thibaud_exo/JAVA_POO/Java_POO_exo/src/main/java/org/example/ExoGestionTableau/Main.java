package org.example.ExoGestionTableau;

import org.example.ExoGestionTableau.Exception.IndexNonExistant;

public class Main {
        public static void main(String[] args) {
            int[] tableau = new int[5];

            try {
                int sixiemeElement = getElement(tableau, 5);
                System.out.println("Le sixième élément est : " + sixiemeElement);
            } catch (IndexNonExistant e) {
                System.out.println(e.getMessage());
            }
        }

        public static int getElement(int[] tableau, int index) {
            if (index < 0 || index >= tableau.length) {
                throw new IndexNonExistant("Hors limite du tableau");
            }
            return tableau[index];
        }
    }
