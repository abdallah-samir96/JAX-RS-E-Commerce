package iti.resources;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("hello")
public class DefaultResource {
    @GET
    @Path("/hello")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public String hello() {
        System.out.println("Hello From The Default Resource!!!");
        return "Hello Java";
    }

}
