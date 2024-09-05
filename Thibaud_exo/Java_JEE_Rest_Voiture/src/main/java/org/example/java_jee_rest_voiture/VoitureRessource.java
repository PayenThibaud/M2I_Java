package org.example.java_jee_rest_voiture;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Path("/voiture")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VoitureRessource {

    private VoitureService voitureService;

    @Inject
    public VoitureRessource(VoitureService voitureService) {
        this.voitureService = voitureService;
    }

    @POST
    public Response ajout(Voiture voiture){

        Voiture ajoutVoiture = voitureService.save(
                voiture.getId(),
                voiture.getNom(),
                voiture.getDateDeFabrication(),
                voiture.getCouleur()
        );
        return Response.status(Response.Status.CREATED).entity(ajoutVoiture).build();
    }

    @DELETE
    @Path("/{id}")
    public Voiture deleteByID(@PathParam("id") int id) {
        voitureService.deleteVoiture(id);
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
    public Voiture updateById(@PathParam("id") int id, Voiture voiture) {
        return voitureService.updateVoiture(id, voiture.getNom(), voiture.getDateDeFabrication(), voiture.getCouleur());
    }




}
