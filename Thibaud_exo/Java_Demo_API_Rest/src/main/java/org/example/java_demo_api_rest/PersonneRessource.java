package org.example.java_demo_api_rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/personne")
public class PersonneRessource {

    private PersonneService personneService;

    @Inject
    public PersonneRessource(PersonneService personneService) {
        this.personneService = personneService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonne() {
        Person person = new Person("Titi", "Papa" , 10);
        return person;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Person addPerson(Person person) {
        person.setAge(4);
        return person;

    }

    @POST
    @Path("/post")
    @Produces(MediaType.APPLICATION_JSON)
    public Person ajoutPerson(@QueryParam("nom") String nom, @QueryParam("prenom") String prenom, @QueryParam("age") int age) {
        return new Person(nom, prenom, 50);
    }

    @DELETE
    @Path("{id}")
    public int deletePerson(@PathParam("id") int id) {
        return id;
    }

    @GET
    @Path("/service")
    @Produces(MediaType.APPLICATION_JSON)
    public Person helloService(){
        return  personneService.save("Tototototototo", "TIITITITITTIIT" , 540);
    }

}
