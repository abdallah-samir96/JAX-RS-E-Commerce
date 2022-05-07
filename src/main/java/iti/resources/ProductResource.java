package iti.resources;

import iti.entities.Product;
import iti.services.ProductService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("products")
public class ProductResource {

    private ProductService service;

    public ProductResource(){
        this.service = new ProductService();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product findProduct(@PathParam("id") long id){
        System.out.println(id);
        return service.findProduct(id);
    }

}
