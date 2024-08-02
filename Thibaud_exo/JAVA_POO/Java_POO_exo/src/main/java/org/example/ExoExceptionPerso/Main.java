package org.example.ExoExceptionPerso;

import org.example.ExoExceptionPerso.Class.Student;
import org.example.ExoExceptionPerso.Exception.InvalidAgeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean boucle = true;

        while (boucle) {
            System.out.print("Nom de l etudiant : ");
            String name = scanner.nextLine();

            int age = -1;
            while (age < 0) {
                try {
                    System.out.print("Age de l etudiant: ");
                    age = Integer.parseInt(scanner.nextLine());
                    if (age < 0) {
                        throw new InvalidAgeException("Age pas bon");
                    }
                } catch (InvalidAgeException e) {
                    System.out.println(e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println("Ceci n est pas un age");
                    age = -1;
                }
            }

            students.add(new Student(name, age));

            System.out.print("Ajouter un etudiant ? (1) : ");
            String reponse = scanner.nextLine();
            if (!reponse.equals("1")) {
                boucle = false;
            }
        }

        System.out.println("\nListe des étudiants :");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
