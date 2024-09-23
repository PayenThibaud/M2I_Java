package org.example.micro_exo_1suite.service;

import org.example.micro_exo_1suite.dto.CommandeDtoReceive;
import org.example.micro_exo_1suite.dto.CommandeDtoSend;
import org.example.micro_exo_1suite.dto.UtilisateurDtoSend;
import org.example.micro_exo_1suite.entity.Commande;
import org.example.micro_exo_1suite.repository.CommandeRepository;
import org.example.micro_exo_1suite.util.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    private CommandeService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    private CommandeDtoSend commandeToCommandeDtoSend(Commande commande) {
        RestClient<UtilisateurDtoSend> utilisateurDtoSendRestClient = new RestClient<>("http://localhost:8081/utilisateur/" + commande.getUtilisateurId());
        UtilisateurDtoSend utilisateurDtoSend = utilisateurDtoSendRestClient.getRequest(UtilisateurDtoSend.class);

        return CommandeDtoSend.builder()
                .id(commande.getId())
                .product(commande.getProduct())
                .utilisateur(utilisateurDtoSend)
                .build();
    }

    private List<CommandeDtoSend> listCommandeToCommandeDtoSendList(List<Commande> commandes) {
        return commandes.stream().map(this::commandeToCommandeDtoSend).toList();
    }

    private Commande findById(int id) {
        return commandeRepository.findById(id).orElseThrow();
    }

    public CommandeDtoSend getById(int id) {
        return commandeToCommandeDtoSend(findById(id));
    }

    public List<CommandeDtoSend> getAll() {
        return listCommandeToCommandeDtoSendList((List<Commande>) commandeRepository.findAll());
    }

    public CommandeDtoSend save(CommandeDtoReceive commandeDtoReceive) {
        RestClient<UtilisateurDtoSend> utilisateurDtoSendRestClient = new RestClient<>("http://localhost:8081/utilisateur/" + commandeDtoReceive.getUtilisateurId());
        UtilisateurDtoSend utilisateurDtoSend = utilisateurDtoSendRestClient.getRequest(UtilisateurDtoSend.class);

        if (utilisateurDtoSend != null) {
            Commande commmande = Commande.builder()
                    .product(commandeDtoReceive.getProduct())
                    .utilisateurId(utilisateurDtoSend.getId())
                    .build();

            return commandeToCommandeDtoSend(commandeRepository.save(commmande));
        }
        throw new RuntimeException("Utilisateur introuvable");
    }

    public CommandeDtoSend update(int id, CommandeDtoReceive commandeDtoReceive) {
        RestClient<UtilisateurDtoSend> utilisateurDtoSendRestClient = new RestClient<>("http://localhost:8081/utilisateur/" + commandeDtoReceive.getUtilisateurId());
        UtilisateurDtoSend utilisateurDtoSend = utilisateurDtoSendRestClient.getRequest(UtilisateurDtoSend.class);

        if (utilisateurDtoSend != null) {
            Commande commmande = findById(id);
            commmande.setProduct(commandeDtoReceive.getProduct());
            commmande.setUtilisateurId(utilisateurDtoSend.getId());

            return commandeToCommandeDtoSend(commandeRepository.save(commmande));
        }
        throw new RuntimeException("Utilisateur introuvable");
    }

    public void delete(int id) {
        commandeRepository.delete(findById(id));
    }

}
