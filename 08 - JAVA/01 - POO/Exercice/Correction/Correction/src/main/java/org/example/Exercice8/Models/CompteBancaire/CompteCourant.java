package org.example.Exercice8.Models.CompteBancaire;

import org.example.Exercice8.Models.Client;

public class CompteCourant extends CompteBancaire{
    public CompteCourant(double solde, Client client) {
        super(solde, client);
    }

    public CompteCourant(Client client) {
        super(client);
    }
}
