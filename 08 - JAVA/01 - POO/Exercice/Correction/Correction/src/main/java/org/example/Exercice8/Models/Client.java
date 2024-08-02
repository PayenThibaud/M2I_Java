package org.example.Exercice8.Models;

import org.example.Exercice8.Models.CompteBancaire.CompteBancaire;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private static int nbClient=0;
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private final List<CompteBancaire> compteBancaires;

    public Client(String nom, String prenom, String email, List<CompteBancaire> compteBancaires) {
        this.id = ++ nbClient;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.compteBancaires = new ArrayList<>();
    }

    public Client(String nom, String prenom, String email) {
        this(nom,prenom,email,new ArrayList<>());
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addCompteBancaire (CompteBancaire compteBancaire){
        compteBancaires.add(compteBancaire);
    }

    public List<CompteBancaire> getCompteBancaires() {
        return compteBancaires;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", compteBancaires=" + compteBancaires +
                '}';
    }
}
