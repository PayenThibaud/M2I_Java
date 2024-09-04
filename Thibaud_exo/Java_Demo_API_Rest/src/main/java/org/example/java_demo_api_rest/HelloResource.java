package org.example.java_demo_api_rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello-world")
public class HelloResource {


    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }

    @GET
    @Path("/hello-u")
    @Produces("text/plain")
    public String helloU() {
        return "Hello, World!";
    }

    @GET
    @Path("/hello-json")
    @Produces("application/json")
    public String helloJson() {
        return "Hello, World!";
    }

    @GET
    @Path("/hello-json2")
    @Produces(MediaType.APPLICATION_JSON)
    public String helloJson2() {
        return "Hello, World!";
    }
}