package org.example.demo_api_rest;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/person")
public class PersonResource {

    private final PersoService persoService;

    @Inject
    public PersonResource(PersoService persoService){
        this.persoService = persoService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Person hello(){
        Person person = new Person(42,"toto",25);
        return  person;
    }

    @GET
    @Path("/service")
    @Produces(MediaType.APPLICATION_JSON)
    public Person helloService(){
        return  persoService.save(88,"tutu",99);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Person postPerson(Person person){
        person.setId(55);
        return person;
    }


    @POST
    @Path("/params")
    @Produces(MediaType.APPLICATION_JSON)
    public Person postPersonV2(@QueryParam("name") String name,@QueryParam("age") int age){
        return new Person(44,name,age);
    }

    @DELETE
    @Path("{id}") // verbe DELETE  http://localhost:8080/demo_api_rest_war_exploded/api/person/XX
    public int delete(@PathParam("id") int id){
        return id;
    }
}
