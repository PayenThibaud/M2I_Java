package org.example.gestionInventaire;

import org.example.gestionInventaire.entity.*;
import org.example.gestionInventaire.enums.Categorie;
import org.example.gestionInventaire.enums.Status;
import org.example.gestionInventaire.repository.ArticleRepository;
import org.example.gestionInventaire.repository.ClientRepository;
import org.example.gestionInventaire.repository.VenteRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArticleRepository articleRepository = new ArticleRepository();
        ClientRepository clientRepository = new ClientRepository();
        VenteRepository venteRepository = new VenteRepository();

//        Article_electronique article_electronique = Article_electronique.builder()
//                .description("TV")
//                .prix(1000)
//                .quantite(50)
//                .dateDeRestock("20/20/2020")
//                .dureeBatterie("20 ans")
//                .build();
//
//        articleRepository.createOrUpdate(article_electronique);
//
//        Article_Nourriture article_nourriture = Article_Nourriture.builder()
//                .description("Pomme")
//                .prix(1)
//                .quantite(200)
//                .datePeremption("20/20/2040")
//                .build();
//
//        articleRepository.createOrUpdate(article_nourriture);
//
//        Article_Mode article_mode = Article_Mode.builder()
//                .description("T-shirt")
//                .prix(1)
//                .quantite(200)
//                .dateDeRestock("20/20/2040")
//                .categorie(Categorie.Femme)
//                .taille(170)
//                .build();
//
//        articleRepository.createOrUpdate(article_mode);
//
//        System.out.println(articleRepository.findById(3));
//    }

//        Client client = Client.builder()
//                .nom("Toto")
//                .mail("titi@gmail.com")
//                .build();
//
//        clientRepository.createOrUpdate(client);
////
//        Vente vente = Vente.builder()
//                .date("10/10/2020")
//                .status(Status.En_cours)
//                .client(clientRepository.findById(3))
//                .build();
//
//        venteRepository.createOrUpdate(vente);
//
//        venteRepository.addArticleInVente(5, List.of( articleRepository.findById(6)));
//
//
//        System.out.println(venteRepository.findById(2));

//        venteRepository.delete(venteRepository.findById(2));

//
//        System.out.println(venteRepository.findById(4));

//        venteRepository.addArticleInVente(4,List.of(articleRepository.findById(4)));
//
//        System.out.println(clientRepository.findById(2));
//        System.out.println(venteRepository.getVenteByArticle(4));
//        System.out.println(venteRepository.getVenteByCategorie(Categorie.Femme));
//        System.out.println(venteRepository.getVenteByClient(3));

//        venteRepository.deleteVenteAndArticle_Vente(2);

        System.out.println(venteRepository.findById(3));
        System.out.println(articleRepository.findById(4));
        System.out.println(clientRepository.findById(1));
        System.out.println(venteRepository.getVenteByClient(1));
    }
}

