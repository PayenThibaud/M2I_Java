package org.example.ExerciceException.Exo1;

import java.util.Scanner;

public class Exo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            try{
                System.out.println("Entrer une valeur numérique");
                String entryStr = scanner.nextLine();
                int entry = Integer.parseInt(entryStr);
                System.out.println("la valeur est : "+entry);
                break;
            }catch (NumberFormatException e){
                System.out.println("La valeur doit etre un entier !");
            }
        }
    }
}
