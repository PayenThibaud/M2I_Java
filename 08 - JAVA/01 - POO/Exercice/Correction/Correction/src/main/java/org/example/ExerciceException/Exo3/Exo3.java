package org.example.ExerciceException.Exo3;

public class Exo3 {
    public static void main(String[] args) {
        int[] tableau = new int[]{1,2,3,4,5};

        try{
            System.out.println(tableau[1]);
            System.out.println(tableau[6]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("l'element est hors du tableau");
        }

    }
}
