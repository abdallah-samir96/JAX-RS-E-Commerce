package iti.resources;

import iti.domain.product.dtos.ProductPostDto;
import iti.services.ProductService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProduct(ProductPostDto product){
          service.addProduct(product);
          return Response.ok().status(200).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProduct(@PathParam("id") long id){
          service.deleteProduct(id);
          return Response.ok().status(200).build();
    }
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAllProducts(){
            service.deleteAllProducts();
            return Response.ok().status(200).build();
    }
   
}
