package org.example.Exo_Royaume;

import org.example.Exo_Royaume.Hero.competences.Magie;
import org.example.Exo_Royaume.Hero.competences.Physique;
import org.example.Exo_Royaume.Hero.enums.AbiliterPhysique;
import org.example.Exo_Royaume.Hero.enums.PouvoirMagique;
import org.example.Exo_Royaume.Hero.personnages.Archer;
import org.example.Exo_Royaume.Hero.personnages.Guerrier;
import org.example.Exo_Royaume.Hero.personnages.Mage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Bienvenue dans le jeu ===");
        System.out.println("1. Créer un Guerrier");
        System.out.println("2. Créer un Archer");
        System.out.println("3. Créer un Mage");
        System.out.print("Choisissez un type de personnage : ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> createGuerrier(scanner);
            case 2 -> createArcher(scanner);
            case 3 -> createMage(scanner);
            default -> System.out.println("Choix invalide, veuillez redémarrer le programme.");
        }

        System.out.println("Bravo vous avez battu le roi Demon, fin du jeu");
    }

    private static void createGuerrier(Scanner scanner) {
        System.out.print("Entrez le nom du Guerrier : ");
        String name = scanner.nextLine();

        System.out.print("Entrez le niveau du Guerrier : ");
        int level = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Entrez les points de vie du Guerrier : ");
        int pv = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Entrez les points d'action du Guerrier : ");
        int pa = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Entrez le bonus de points de vie du Guerrier : ");
        int bonusVie = scanner.nextInt();
        scanner.nextLine();

        List<Physique> competencesPhysiques = createPhysiqueCompetences(scanner);

        Guerrier guerrier = new Guerrier.GuerrierBuilder()
                .name(name)
                .level(level)
                .pv(pv)
                .pa(pa)
                .physique(competencesPhysiques)
                .bonusPointVie(bonusVie)
                .build();

        System.out.println("Votre Guerrier a été créé :");
        System.out.println(guerrier);
    }

    private static void createArcher(Scanner scanner) {
        System.out.print("Entrez le nom de l'Archer : ");
        String name = scanner.nextLine();

        System.out.print("Entrez le niveau de l'Archer : ");
        int level = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Entrez les points de vie de l'Archer : ");
        int pv = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Entrez les points d'action de l'Archer : ");
        int pa = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Entrez le bonus de points d'agilité de l'Archer : ");
        int bonusAgilite = scanner.nextInt();
        scanner.nextLine();

        List<Physique> competencesPhysiques = createPhysiqueCompetences(scanner);

        Archer archer = new Archer.ArcherBuilder()
                .name(name)
                .level(level)
                .pv(pv)
                .pa(pa)
                .physique(competencesPhysiques)
                .bonusPointAgiliter(bonusAgilite)
                .build();

        System.out.println("Votre Archer a été créé :");
        System.out.println(archer);
    }

    private static void createMage(Scanner scanner) {
        System.out.print("Entrez le nom du Mage : ");
        String name = scanner.nextLine();

        System.out.print("Entrez le niveau du Mage : ");
        int level = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Entrez les points de vie du Mage : ");
        int pv = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Entrez les points de magie du Mage : ");
        int pm = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Entrez le bonus de points magiques du Mage : ");
        int bonusMagique = scanner.nextInt();
        scanner.nextLine();

        List<Magie> competencesMagiques = createMagieCompetences(scanner);

        Mage mage = new Mage.MageBuilder()
                .name(name)
                .level(level)
                .pv(pv)
                .pm(pm)
                .magie(competencesMagiques)
                .bonusPointMagique(bonusMagique)
                .build();

        System.out.println("Votre Mage a été créé :");
        System.out.println(mage);
    }

    private static List<Physique> createPhysiqueCompetences(Scanner scanner) {
        List<Physique> competences = new ArrayList<>();
        boolean ajouter = true;

        while (ajouter) {
            System.out.println("Choisissez une compétence physique :");
            for (int i = 0; i < AbiliterPhysique.values().length; i++) {
                System.out.println((i + 1) + ". " + AbiliterPhysique.values()[i]);
            }
            int choixCompetence = scanner.nextInt();
            scanner.nextLine();

            if (choixCompetence > 0 && choixCompetence <= AbiliterPhysique.values().length) {
                AbiliterPhysique abiliter = AbiliterPhysique.values()[choixCompetence - 1];

                System.out.print("Entrez le niveau de cette compétence : ");
                int niveau = scanner.nextInt();
                scanner.nextLine();

                competences.add(new Physique(abiliter, niveau));
            } else {
                System.out.println("Choix invalide.");
            }

            System.out.print("Voulez-vous ajouter une autre compétence physique ? (y/n) : ");
            ajouter = scanner.nextLine().equalsIgnoreCase("y");
        }

        return competences;
    }

    private static List<Magie> createMagieCompetences(Scanner scanner) {
        List<Magie> competences = new ArrayList<>();
        boolean ajouter = true;

        while (ajouter) {
            System.out.println("Choisissez une compétence magique :");
            for (int i = 0; i < PouvoirMagique.values().length; i++) {
                System.out.println((i + 1) + ". " + PouvoirMagique.values()[i]);
            }
            int choixCompetence = scanner.nextInt();
            scanner.nextLine();

            if (choixCompetence > 0 && choixCompetence <= PouvoirMagique.values().length) {
                PouvoirMagique pouvoir = PouvoirMagique.values()[choixCompetence - 1];

                System.out.print("Entrez le niveau de ce pouvoir : ");
                int niveau = scanner.nextInt();
                scanner.nextLine();

                competences.add(new Magie(pouvoir, niveau));
            } else {
                System.out.println("Choix invalide.");
            }

            System.out.print("Voulez-vous ajouter une autre compétence magique ? (y/n) : ");
            ajouter = scanner.nextLine().equalsIgnoreCase("y");
        }

        return competences;

    }
}
