package org.example.java_jee_rest_voiture;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;


import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Path("/voiture")
public class VoitureRessource {

    private VoitureService voitureService;

    @Inject
    public VoitureRessource(VoitureService voitureService) {
        this.voitureService = voitureService;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Voiture ajout(Voiture voiture){

        Voiture ajoutVoiture = voitureService.save(
                voiture.getId(),
                voiture.getNom(),
                voiture.getDateDeFabrication(),
                voiture.getCouleur()
        );
        return ajoutVoiture;
    }

    @DELETE
    @Path("/{id}")
    public Voiture deleteByID(@PathParam("id") int id) {
        return voitureService.getVoiture(id);
    }

    @GET
    @Path("/{id}")
    public Voiture getByID(@PathParam("id") int id) {
        return voitureService.getVoiture(id);
    }

    @GET
    public List<Voiture> getAll() {
        return voitureService.getAllVoitures();
    }

    @PATCH
    @Path("/{id}")
    public Voiture updateById(@PathParam("id") int id,  String nom, Date dateDeFabrication, String couleur) {
        return voitureService.updateVoiture(id , nom, dateDeFabrication, couleur);
    }



}
