package org.example.Exercice8.util;

import org.example.Exercice8.Models.Client;
import org.example.Exercice8.Models.CompteBancaire.CompteCourant;
import org.example.Exercice8.Models.CompteBancaire.CompteEpargne;
import org.example.Exercice8.Models.CompteBancaire.ComptePayant;

import java.util.List;
import java.util.Scanner;

public class IHMCompte {

    private Scanner scanner;
    private List<Client> clients;

    public IHMCompte(Scanner scanner,List<Client> clients) {
        this.scanner = scanner;
        this.clients = clients;
    }

    public void startMenu(){
        while(true)
        {
            afficheMenuBase();
            String choix = scanner.nextLine();

            switch (choix){
                case "1" -> creeCompteCourant();
                case "2" -> creeCompteEpargne();
                case "3" -> creeComptePayant();

                case "0" -> {
                    return;

                }
                default -> System.out.println("Choix invalide !!!!");
            }

        }
    }

    private void afficheMenuBase (){
        System.out.println("""
                --- Menu Compte ---
                1/ cree compte courant
                2/ cree compte epargne
                3/ cree compte payant
                """);
    }

    private void creeCompteCourant(){
        System.out.println("-- Creation compte courant --");
        System.out.println("Selectioner un client");
        for (int i = 0; i< clients.size();i++){
            System.out.println((i+1)+"/ "+clients.get(i).getNom()+" "+clients.get(i).getPrenom());
        }

        int indexClient = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Solde de depart du compte");
        double solde = scanner.nextDouble();
        scanner.nextLine();

        Client client = clients.get(indexClient-1);
        client.addCompteBancaire(new CompteCourant(solde,client));
    }

    private void creeCompteEpargne(){
        System.out.println("-- Creation compte Epargne --");
        System.out.println("Selectioner un client");
        for (int i = 0; i< clients.size();i++){
            System.out.println((i+1)+"/ "+clients.get(i).getNom()+" "+clients.get(i).getPrenom());
        }

        int indexClient = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Solde de depart du compte");
        double solde = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Taux du compte epargne :");
        double taux = scanner.nextDouble();
        scanner.nextLine();

        Client client = clients.get(indexClient-1);
        client.addCompteBancaire(new CompteEpargne(solde,client,taux));
    }

    private void creeComptePayant(){
        System.out.println("-- Creation compte payant --");
        System.out.println("Selectioner un client");
        for (int i = 0; i< clients.size();i++){
            System.out.println((i+1)+"/ "+clients.get(i).getNom()+" "+clients.get(i).getPrenom());
        }

        int indexClient = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Solde de depart du compte");
        double solde = scanner.nextDouble();
        scanner.nextLine();

        Client client = clients.get(indexClient-1);
        client.addCompteBancaire(new ComptePayant(solde,client));
    }
}
