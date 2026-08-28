package iti.resources;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("welcome")
public class WelcomeResource {
    private final static String SERVICE_NAME = "SERVICE_NAME";
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public String welcome() {
        var sName = System.getenv(SERVICE_NAME);
        var serviceName = sName!= null? sName: "e-app";
        System.out.println("Welcome to our system");
        return "Hello From " + serviceName + "APP";
    }

}
