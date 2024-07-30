package org.example.ExoRecette;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Recette> recettes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Créer une nouvelle recette");
            System.out.println("2. Modifier une recette");
            System.out.println("3. Supprimer une recette");
            System.out.println("4. Ajouter un ingrédient à une recette");
            System.out.println("5. Supprimer un ingrédient d'une recette");
            System.out.println("6. Ajouter une étape à une recette");
            System.out.println("7. Supprimer une étape d'une recette");
            System.out.println("8. Ajouter un commentaire à une recette");
            System.out.println("9. Supprimer un commentaire d'une recette");
            System.out.println("10. Afficher les détails d'une recette");
            System.out.println("11. Quitter");

            int choix = lireEntier();

            switch (choix) {
                case 1:
                    creerRecette();
                    break;
                case 2:
                    modifierRecette();
                    break;
                case 3:
                    supprimerRecette();
                    break;
                case 4:
                    ajouterIngredient();
                    break;
                case 5:
                    supprimerIngredient();
                    break;
                case 6:
                    ajouterEtape();
                    break;
                case 7:
                    supprimerEtape();
                    break;
                case 8:
                    ajouterCommentaire();
                    break;
                case 9:
                    supprimerCommentaire();
                    break;
                case 10:
                    afficherRecette();
                    break;
                case 11:
                    System.out.println("Au revoir !");
                    scanner.close();
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    private static void creerRecette() {
        System.out.println("Entrez le nom de la recette : ");
        String nom = scanner.nextLine();
        System.out.println("Entrez le temps de préparation en minutes : ");
        int tempsPrep = lireEntier();
        System.out.println("Entrez le temps de cuisson en minutes : ");
        int tempsCuisson = lireEntier();
        System.out.println("Entrez le niveau de difficulté : ");
        String difficulte = scanner.nextLine();


        Recette recette = new Recette(nom, tempsPrep, tempsCuisson, difficulte);
        recettes.add(recette);
        System.out.println("Recette créée !");
    }

    private static void modifierRecette() {
        System.out.println("Entrez l'index de la recette à modifier : ");
        int index = lireIndex();
        if (index >= 0 && index < recettes.size()) {
            Recette recette = recettes.get(index);
            System.out.println("Entrez le nouveau nom de la recette (laisser vide pour ne pas modifier) : ");
            String nom = scanner.nextLine();
            if (!nom.isEmpty()) {
                recette.setNom(nom);
            }
            System.out.println("Entrez le nouveau temps de préparation en minutes (laisser vide pour ne pas modifier) : ");
            String tempsPrepStr = scanner.nextLine();
            if (!tempsPrepStr.isEmpty()) {
                recette.setTempsPrep(Integer.parseInt(tempsPrepStr));
            }
            System.out.println("Entrez le nouveau temps de cuisson en minutes (laisser vide pour ne pas modifier) : ");
            String tempsCuissonStr = scanner.nextLine();
            if (!tempsCuissonStr.isEmpty()) {
                recette.setTempsCuisson(Integer.parseInt(tempsCuissonStr));
            }
            System.out.println("Entrez le nouveau niveau de difficulté (laisser vide pour ne pas modifier) : ");
            String difficulte = scanner.nextLine();
            if (!difficulte.isEmpty()) {
                recette.setDifficulte(difficulte);
            }
            System.out.println("Recette modifiée !");
        } else {
            System.out.println("Index invalide.");
        }
    }

    private static void supprimerRecette() {
        System.out.println("Entrez l'index de la recette à supprimer : ");
        int index = lireIndex();
        if (index >= 0 && index < recettes.size()) {
            recettes.remove(index);
            System.out.println("Recette supprimée !");
        } else {
            System.out.println("Index invalide.");
        }
    }

    private static void ajouterIngredient() {
        System.out.println("Entrez l'index de la recette à laquelle ajouter un ingrédient : ");
        int index = lireIndex();
        if (index >= 0 && index < recettes.size()) {
            Recette recette = recettes.get(index);
            System.out.println("Entrez le nom de l'ingrédient : ");
            String nom = scanner.nextLine();
            Ingredient ingredient = new Ingredient(nom);
            recette.ajouterIngredient(ingredient);
            System.out.println("Ingrédient ajouté !");
        } else {
            System.out.println("Index invalide.");
        }
    }

    private static void supprimerIngredient() {
        System.out.println("Entrez l'index de la recette dont vous souhaitez supprimer un ingrédient : ");
        int index = lireIndex();
        if (index >= 0 && index < recettes.size()) {
            Recette recette = recettes.get(index);
            System.out.println("Entrez le nom de l'ingrédient à supprimer : ");
            String nom = scanner.nextLine();
            Ingredient ingredient = new Ingredient(nom);
            recette.supprimerIngredient(ingredient);
            System.out.println("Ingrédient supprimé !");
        } else {
            System.out.println("Index invalide.");
        }
    }

    private static void ajouterEtape() {
        System.out.println("Entrez l'index de la recette à laquelle ajouter une étape : ");
        int index = lireIndex();
        if (index >= 0 && index < recettes.size()) {
            Recette recette = recettes.get(index);
            System.out.println("Entrez la description de l'étape : ");
            String description = scanner.nextLine();
            Etape etape = new Etape(description);
            recette.ajouterEtape(etape);
            System.out.println("Étape ajoutée !");
        } else {
            System.out.println("Index invalide.");
        }
    }

    private static void supprimerEtape() {
        System.out.println("Entrez l'index de la recette dont vous souhaitez supprimer une étape : ");
        int index = lireIndex();
        if (index >= 0 && index < recettes.size()) {
            Recette recette = recettes.get(index);
            System.out.println("Entrez la description de l'étape à supprimer : ");
            String description = scanner.nextLine();
            Etape etape = new Etape(description);
            recette.supprimerEtape(etape);
            System.out.println("Étape supprimée !");
        } else {
            System.out.println("Index invalide.");
        }
    }

    private static void ajouterCommentaire() {
        System.out.println("Entrez l'index de la recette à laquelle ajouter un commentaire : ");
        int index = lireIndex();
        if (index >= 0 && index < recettes.size()) {
            Recette recette = recettes.get(index);
            System.out.println("Entrez la description du commentaire : ");
            String description = scanner.nextLine();
            Commentaire commentaire = new Commentaire(description);
            recette.ajouterCommentaire(commentaire);
            System.out.println("Commentaire ajouté !");
        } else {
            System.out.println("Index invalide.");
        }
    }

    private static void supprimerCommentaire() {
        System.out.println("Entrez l'index de la recette dont vous souhaitez supprimer un commentaire : ");
        int index = lireIndex();
        if (index >= 0 && index < recettes.size()) {
            Recette recette = recettes.get(index);
            System.out.println("Entrez la description du commentaire à supprimer : ");
            String description = scanner.nextLine();
            Commentaire commentaire = new Commentaire(description);
            recette.supprimerCommentaire(commentaire);
            System.out.println("Commentaire supprimé !");
        } else {
            System.out.println("Index invalide.");
        }
    }

    private static void afficherRecette() {
        System.out.println("Entrez l'index de la recette à afficher : ");
        int index = lireIndex();
        if (index >= 0 && index < recettes.size()) {
            Recette recette = recettes.get(index);
            System.out.println(recette);
            System.out.println("Ingrédients : " + recette.getIngredients());
            System.out.println("Étapes : " + recette.getEtapes());
            System.out.println("Commentaires : " + recette.getCommentaires());
        } else {
            System.out.println("Index invalide.");
        }
    }

    private static int lireEntier() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        }
    }

    private static int lireIndex() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un index numérique valide.");
            }
        }
    }
}
