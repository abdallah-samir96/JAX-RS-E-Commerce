package iti.resources;

import java.util.List;

import iti.domain.customers.dtos.CustomerGetDto;
import iti.services.CustomerService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("customers")
public class CustomerResource {
    private CustomerService service;

    public CustomerResource(){
        this.service = new CustomerService();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCustomer(@PathParam("id") long id){
        System.out.println("From Single Customer");
        CustomerGetDto customer = service.findCustomer(id);
        return Response.ok().entity(customer).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCustomers(){
        List<CustomerGetDto> list = service.getAllCustomers();
        GenericEntity entity = new GenericEntity<List<CustomerGetDto>>(list){};
        return Response.ok(entity).build();

    }
}
