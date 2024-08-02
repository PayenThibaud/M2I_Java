package org.example.ExoBancaire.Class;

import java.util.List;

public class Client {
    private String nom;
    private String prenom;
    private int identifiant;
    private List<CompteBancaire> compteBancaireList;
    private String tel;


    public Client(String nom, String prenom, int identifiant , String tel, List<CompteBancaire> compteBancaireList) {
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
        this.tel = tel;
        this.compteBancaireList = compteBancaireList;
    }

    public Client(String dupont, String jean, int identifiant, String number) {
        this.nom = dupont;
        this.prenom = jean;
        this.identifiant = identifiant;
        this.tel = number;
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

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public List<CompteBancaire> getCompteBancaireList() {
        return compteBancaireList;
    }

    public void setCompteBancaireList(List<CompteBancaire> compteBancaireList) {
        this.compteBancaireList = compteBancaireList;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Client : nom = " + nom + " prenom = " + prenom + " identifiant = " + identifiant + " tel = " + tel;
    }

}
