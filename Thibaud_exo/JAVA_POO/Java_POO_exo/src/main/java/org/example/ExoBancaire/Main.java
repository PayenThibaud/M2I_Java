package org.example.ExoBancaire;

import org.example.ExoBancaire.Class.Client;
import org.example.ExoBancaire.Class.CompteBancaire;
import org.example.ExoBancaire.Class.CompteCourant;
import org.example.ExoBancaire.Class.CompteEpargne;
import org.example.ExoBancaire.Class.ComptePayant;
import org.example.ExoBancaire.Class.Operation;
import org.example.ExoBancaire.Enum.TypeOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<CompteBancaire> comptes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            afficherMenu();
            int choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    listerComptes();
                    break;
                case 2:
                    creerCompte();
                    break;
                case 3:
                    effectuerDepot();
                    break;
                case 4:
                    effectuerRetrait();
                    break;
                case 5:
                    afficherOperations();
                    break;
                case 6:
                    afficherSolde();
                    break;
                case 7:
                    running = false;
                    System.out.println("bye bye!");
                    break;
                default:
                    System.out.println("erreur");
                    break;
            }
        }
    }

    private static void afficherMenu() {
        System.out.println("\n=== Menu Principal ===");
        System.out.println("1. Lister les comptes bancaires");
        System.out.println("2. Créer un compte bancaire");
        System.out.println("3. Effectuer un dépôt");
        System.out.println("4. Effectuer un retrait");
        System.out.println("5. Afficher les opérations d'un compte");
        System.out.println("6. Afficher le solde d'un compte");
        System.out.println("7. Quitter");
        System.out.print("Entrez votre choix : ");
    }

    private static void listerComptes() {
        if (comptes.isEmpty()) {
            System.out.println("Aucun compte bancaire disponible.");
        } else {
            for (int i = 0; i < comptes.size(); i++) {
                System.out.println((i + 1) + ". " + comptes.get(i));
            }
        }
    }

    private static void creerCompte() {
        System.out.print("Entrez le nom du client : ");
        String nom = scanner.nextLine();
        System.out.print("Entrez le prénom du client : ");
        String prenom = scanner.nextLine();
        System.out.print("Entrez l'identifiant du client : ");
        int identifiant = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Entrez le téléphone du client : ");
        String tel = scanner.nextLine();
        Client client = new Client(nom, prenom, identifiant, tel);

        System.out.println("Choisissez le type de compte :");
        System.out.println("1. Compte Courant");
        System.out.println("2. Compte Épargne");
        System.out.println("3. Compte Payant");
        int typeCompte = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Entrez le solde initial : ");
        double solde = scanner.nextDouble();
        scanner.nextLine();

        CompteBancaire compte = null;
        switch (typeCompte) {
            case 1:
                compte = new CompteCourant(solde, client, new ArrayList<Operation>());
                break;
            case 2:
                compte = new CompteEpargne(solde, client, new ArrayList<Operation>());
                break;
            case 3:
                compte = new ComptePayant(solde, client, new ArrayList<Operation>());
                break;
            default:
                System.out.println("Type de compte invalide.");
                return;
        }

        comptes.add(compte);
        System.out.println("Compte créé avec succès !");
    }

    private static void effectuerDepot() {
        listerComptes();
        System.out.print("Entrez le numéro du compte pour le dépôt : ");
        int numeroCompte = scanner.nextInt();
        scanner.nextLine();
        if (numeroCompte < 1 || numeroCompte > comptes.size()) {
            System.out.println("Numéro de compte invalide.");
            return;
        }
        System.out.print("Entrez le montant à déposer : ");
        double montant = scanner.nextDouble();
        scanner.nextLine();

        comptes.get(numeroCompte - 1).ajouterOperation(TypeOperation.DEPOT, montant);
        System.out.println("Dépôt effectué avec succès !");
    }

    private static void effectuerRetrait() {
        listerComptes();
        System.out.print("Entrez le numéro du compte pour le retrait : ");
        int numeroCompte = scanner.nextInt();
        scanner.nextLine();
        if (numeroCompte < 1 || numeroCompte > comptes.size()) {
            System.out.println("Numéro de compte invalide.");
            return;
        }
        System.out.print("Entrez le montant à retirer : ");
        double montant = scanner.nextDouble();
        scanner.nextLine();

        comptes.get(numeroCompte - 1).ajouterOperation(TypeOperation.RETRAIT, montant);
        System.out.println("Retrait effectué avec succès !");
    }

    private static void afficherOperations() {
        listerComptes();
        System.out.print("Entrez le numéro du compte pour afficher les opérations : ");
        int numeroCompte = scanner.nextInt();
        scanner.nextLine();
        if (numeroCompte < 1 || numeroCompte > comptes.size()) {
            System.out.println("Numéro de compte invalide.");
            return;
        }
        CompteBancaire compte = comptes.get(numeroCompte - 1);
        for (Operation op : compte.getOperations()) {
            System.out.println(op);
        }
    }

    private static void afficherSolde() {
        listerComptes();
        System.out.print("Entrez le numéro du compte pour afficher le solde : ");
        int numeroCompte = scanner.nextInt();
        scanner.nextLine();
        if (numeroCompte < 1 || numeroCompte > comptes.size()) {
            System.out.println("Numéro de compte invalide.");
            return;
        }
        CompteBancaire compte = comptes.get(numeroCompte - 1);
        System.out.println("Solde du compte : " + compte.getSolde());
    }
}
