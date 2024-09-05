package org.example.exercice6_voiture_api_rest.ressource;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.exercice6_voiture_api_rest.model.Voiture;
import org.example.exercice6_voiture_api_rest.service.VoitureService;

import java.util.List;

@Path("/voiture")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VoitureResource {

    private VoitureService voitureService;

    // CDI
    @Inject
    public VoitureResource(VoitureService voitureService){
        this.voitureService = voitureService;
    }

    @GET
    @Path("/{id}") // http://localhost:8080/exercice6_voiture_api_rest_war_exploded/api/voiture/XX XX => id de la voiture
    public Voiture finfById(@PathParam("id")Long id){
        return voitureService.findById(id);
    }

    @GET // http://localhost:8080/exercice6_voiture_api_rest_war_exploded/api/voiture
    public List<Voiture> findAll(){
        return voitureService.findAll();
    }

    @POST // http://localhost:8080/exercice6_voiture_api_rest_war_exploded/api/voiture
    public Voiture create(Voiture voiture){
        voitureService.create(voiture);
        return voiture;
    }

    @PUT
    @Path("/{id}") // http://localhost:8080/exercice6_voiture_api_rest_war_exploded/api/voiture/XX XX => id de la voiture
    public Voiture update(@PathParam("id") Long id,Voiture voiture){
        voiture.setId(id);
        return voitureService.update(voiture);
    }

    @DELETE
    @Path("/{id}") // http://localhost:8080/exercice6_voiture_api_rest_war_exploded/api/voiture/XX XX => id de la voiture
    public List<Voiture> delete(@PathParam("id")Long id){
        voitureService.delete(id);
        return voitureService.findAll();
    }

}
