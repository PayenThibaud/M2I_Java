package org.example.exo2;

import org.example.exo2.DAO.AnimauxDAO;
import org.example.exo2.DAO.GardienDAO;
import org.example.exo2.DAO.RepasDAO;
import org.example.exo2.entity.Animaux;
import org.example.exo2.entity.Gardien;
import org.example.exo2.entity.Repas;
import org.example.exo2.enums.AnimauxEnum;

import java.io.PrintStream;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {

        AnimauxDAO animauxDAO = new AnimauxDAO();
//        Animaux animal = Animaux.builder()
//                .nom("pumna")
//                .race("Panthera leo")
//                .description("Grand prédateur du continent africain")
//                .habitat("Savane")
//                .age(5)
//                .build();
//
//        animauxDAO.enregistrementAnimaux(animal);
//
//        int idAnimauxDonnerUnRepas = 5;
//
//
//        RepasDAO repasDAO = new RepasDAO();
//        Repas repas = Repas.builder()
//                .date("2024-08-22")
//                .heure("15:00")
//                .detail("Viande de cheval")
//                .animaux_id(idAnimauxDonnerUnRepas)
//                .build();
//
//        repasDAO.enregistrerRepas(repas);
//
//
//        int idAnimaux = 2;
//
//        System.out.println(animauxDAO.getAnimauxById(idAnimaux));
//
//        List<Animaux> animauxList = animauxDAO.getAnimaux(AnimauxEnum.nom, "Lion");
//
//        if (!animauxList.isEmpty()) {
//            for (Animaux animal2 : animauxList) {
//                System.out.println("Animal récupéré :");
//                System.out.println("ID : " + animal2.getId());
//                System.out.println("Nom : " + animal2.getNom());
//                System.out.println("Race : " + animal2.getRace());
//                System.out.println("Description : " + animal2.getDescription());
//                System.out.println("Habitat : " + animal2.getHabitat());
//                System.out.println("Âge : " + animal2.getAge());
//                System.out.println("Repas : " + animal2.getRepas());
//                System.out.println("-- -  --  --  --  --  ---  ---  ---  --  --  -  -");
//            }
//        }
//
//        List<Repas> repasList = repasDAO.getAllRepasByIdAnimaux(idAnimaux);
//        System.out.println("Repas pour l'animal : " + animauxDAO.getAnimauxById(idAnimaux).getNom());
//        for (Repas r : repasList) {
//            System.out.println("ID : " + r.getId());
//            System.out.println("Date : " + r.getDate());
//            System.out.println("Heure : " + r.getHeure());
//            System.out.println("Détail : " + r.getDetail());
//            System.out.println("animaux_id: " + r.getAnimaux_id());
//            System.out.println("--------------------------");
//        }

        GardienDAO gardienDAO = new GardienDAO();

        Gardien gardien = Gardien.builder()
                .nom("Titi")
                .build();

        gardienDAO.Enregistrergardien(gardien);

        gardienDAO.lierAnimauxAuxGardiens(3,41);
        gardienDAO.lierAnimauxAuxGardiens(4,41);

        System.out.println(gardienDAO.getGardienById(1));
        System.out.println(animauxDAO.getAnimauxById(40));
    }
}



