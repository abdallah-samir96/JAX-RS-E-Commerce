package iti.resources;

import java.util.List;

import iti.domain.customers.dtos.CustomerGetDto;
import iti.domain.customers.dtos.CustomerPostDto;
import iti.domain.links.Link;
import iti.services.CustomerService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

@Path("customers")
public class CustomerResource {
    private CustomerService service;

    public CustomerResource(){
        this.service = new CustomerService();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCustomer(@PathParam("id") long id,@Context UriInfo uriInfo){
        String url1 = uriInfo.getBaseUriBuilder().path(CustomerResource.class).path(Integer.toString((int)id)).build().toString();
        String url2 = uriInfo.getBaseUriBuilder().path(CustomerResource.class).build().toString();
        Link self = new Link("self", url1);
        Link users = new Link("customers", url2);
        CustomerGetDto customer = service.findCustomer(id);
        customer.getLinks().add(self);
        customer.getLinks().add(users);
        return Response.ok().entity(customer).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCustomers(@Context UriInfo uriInfo){
        List<CustomerGetDto> list = service.getAllCustomers();
        
        list.forEach(customer->{
            
            String url1 = uriInfo.getBaseUriBuilder().path(CustomerResource.class).path(Integer.toString((int)customer.getId())).build().toString();
            String url2 = uriInfo.getBaseUriBuilder().path(CustomerResource.class).build().toString();
            Link self = new Link("self", url1);
            Link users = new Link("customers", url2);
            customer.getLinks().add(self);
            customer.getLinks().add(users);

        });

        GenericEntity entity = new GenericEntity<List<CustomerGetDto>>(list){};
        return Response.ok(entity).build();

    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCustomer(CustomerPostDto dto){
           
          service.addCustomer(dto);
          return Response.ok().status(200).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response deleteCustomer(@PathParam("id") long id){
            service.deleteCustomer(id);
            return Response.ok().status(200).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAllCustomers(){
            service.deleteAllCustomers();
            return Response.ok().status(200).build();
    }
}
