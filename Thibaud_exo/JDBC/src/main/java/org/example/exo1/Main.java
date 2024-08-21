package org.example.exo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Singleton singleton = Singleton.getInstance("jdbc:postgresql://localhost:5432/postgres?currentSchema=public");
        Singleton singleton2 = Singleton.getInstance("A");
        String url = singleton2.getUrlConnection();
        String user = "postgres";
        String password = "thibaud";

        Connection connection;

        try {
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Connexion ok");

                Scanner scanner = new Scanner(System.in);

                while (true) {
                    System.out.println("=== IHM ===");
                    System.out.println("1. Créer un Etudiant");
                    System.out.println("2. Afficher tous les Etudiants");
                    System.out.println("3. Trier les Etudiants");
                    System.out.println("4. Supprimer un Etudiant");
                    System.out.println("5. Quitter");

                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1:
                            System.out.print("Entrez le nom de l'étudiant: ");
                            String nom = scanner.nextLine();

                            System.out.print("Entrez le prénom de l'étudiant: ");
                            String prenom = scanner.nextLine();

                            System.out.print("Entrez le numéro de classe de l'étudiant : ");
                            String numeroDeClasse = scanner.nextLine();

                            System.out.print("Entrez la date de diplôme de l'étudiant : ");
                            String dateDeDiplome = scanner.nextLine();

                            Etudiant etudiant = Etudiant.builder()
                                    .nom(nom)
                                    .prenom(prenom)
                                    .numeroDeClasse(numeroDeClasse)
                                    .dateDeDiplome(dateDeDiplome)
                                    .build();

                            Utiliter.ajouterEtudiant(connection, etudiant);
                            System.out.println("Étudiant ajouté avec succès.");
                            break;

                        case 2:
                            Utiliter.afficherLesEtudiants(connection);
                            break;

                        case 3:
                            System.out.println("Filtrer par : \n1. Nom \n2. Prénom \n3. Numéro de classe \n4. Date de diplôme");
                            int filterChoice = scanner.nextInt();
                            scanner.nextLine();
                            Trie trie;

                            switch (filterChoice) {
                                case 1:
                                    trie = Trie.nom;
                                    break;
                                case 2:
                                    trie = Trie.prenom;
                                    break;
                                case 3:
                                    trie = Trie.numeroDeClasse;
                                    break;
                                case 4:
                                    trie = Trie.dateDeDiplome;
                                    break;
                                default:
                                    System.out.println("Choix de filtre invalide.");
                                    continue;
                            }

                            System.out.print("Entrez la valeur pour filtrer : ");
                            String valeur = scanner.nextLine();

                            Utiliter.trierEtudiants(connection, trie, valeur);
                            break;

                        case 4:
                            System.out.print("Entrez l'ID de l'étudiant à supprimer: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();

                            Utiliter.retirerEtudiant(connection, id);
                            break;

                        case 5:
                            System.out.println("bye");
                            return;

                        default:
                            System.out.println("Erreur de frappe, vous n'avez pas tapé 1/2/3/4/5");
                    }

                    System.out.println();
                }
            } else {
                System.out.println("Connexion fail");
            }
        } catch (SQLException e) {
            System.out.println("Erreur durant la connexion : " + e.getMessage());
        }
    }
}