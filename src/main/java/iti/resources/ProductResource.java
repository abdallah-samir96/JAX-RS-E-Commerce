package iti.resources;

import iti.services.ProductService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("products")
public class ProductResource {

    private ProductService service;

    public ProductResource(){
        this.service = new ProductService();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findProduct(@PathParam("id") long id){
        var product = service.findProduct(id);
        return Response.ok().entity(product).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProducts(){
        // return list of products
        var products = service.getAllProducts();
        return Response.ok().entity(products).build();
    }



}
