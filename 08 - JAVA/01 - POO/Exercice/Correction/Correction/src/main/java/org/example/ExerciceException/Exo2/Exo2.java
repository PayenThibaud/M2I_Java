package org.example.ExerciceException.Exo2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            try{
                System.out.println("entrer un entier positif :");
                int entry = scanner.nextInt();
//                String entryStr = scanner.nextLine();
//                int entry = Integer.parseInt(entryStr);
                if(entry < 0){
                    throw new NegativeValueException("entrer une valeur positive !");
                }
                System.out.println("La racine carée de "+entry+" est : "+Math.sqrt(entry));
                break;
            }
//            catch (NumberFormatException e){
//                System.out.println("Entrer une valeur numerique !");
//            }
            catch (InputMismatchException e){
                System.out.println("Entrer une valeur numerique !");
            }
            catch (NegativeValueException e) {
                System.out.println(e.getMessage());
            }
            finally {
                scanner.nextLine();
            }
        }
    }

}
