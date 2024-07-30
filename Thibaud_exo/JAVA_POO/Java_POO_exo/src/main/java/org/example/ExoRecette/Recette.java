package org.example.ExoRecette;

import java.util.ArrayList;
import java.util.List;

public class Recette {
    private String nom;
    private int tempsPrep;
    private int tempsCuisson;
    private String difficulte;
    private List<Ingredient> ingredients;
    private List<Etape> etapes;
    private List<Commentaire> commentaires;
    private List<Categorie> categorie;

    public Recette(String nom, int tempsPrep, int tempsCuisson, String difficulte) {
        this.nom = nom;
        this.tempsPrep = tempsPrep;
        this.tempsCuisson = tempsCuisson;
        this.difficulte = difficulte;
        this.categorie = new ArrayList<>();
        this.ingredients = new ArrayList<>();
        this.etapes = new ArrayList<>();
        this.commentaires = new ArrayList<>();
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTempsPrep() {
        return tempsPrep;
    }

    public void setTempsPrep(int tempsPrep) {
        this.tempsPrep = tempsPrep;
    }

    public int getTempsCuisson() {
        return tempsCuisson;
    }

    public void setTempsCuisson(int tempsCuisson) {
        this.tempsCuisson = tempsCuisson;
    }

    public String getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }

    public List<Categorie> getCategorie() {
        return categorie;
    }

    public void ajouterCategorie(Categorie categorie) {
        this.categorie.add(categorie);
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void ajouterIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public void supprimerIngredient(Ingredient ingredient) {
        this.ingredients.remove(ingredient);
    }

    public List<Etape> getEtapes() {
        return etapes;
    }

    public void ajouterEtape(Etape etape) {
        this.etapes.add(etape);
    }

    public void supprimerEtape(Etape etape) {
        this.etapes.remove(etape);
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void ajouterCommentaire(Commentaire commentaire) {
        this.commentaires.add(commentaire);
    }

    public void supprimerCommentaire(Commentaire commentaire) {
        this.commentaires.remove(commentaire);
    }

    @Override
    public String toString() {
        return "Recette: " + nom + "\nTemps de préparation: " + tempsPrep + " minutes\nTemps de cuisson: " + tempsCuisson + " minutes\nDifficulté: " + difficulte + "\nCatégorie: " + categorie;
    }
}
