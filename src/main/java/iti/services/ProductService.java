package iti.services;

import iti.daos.ProductDao;
import iti.entities.Product;

public class ProductService {
    
    private ProductDao dao;

    public ProductService(){
        this.dao = new ProductDao();
    }
       
    public Product findProduct(long id){
        return dao.getProductById(id);
    }

    // @GET
    // @Path("{id}")
    // @Produces(MediaType.APPLICATION_JSON)
    // public ProductDto getProductById(@PathParam("id") int id , @Context UriInfo uriInfo){
    //     ProductDto dto = productService.getProduct(id);
    //     dto.addLink(getSelfUri(uriInfo, dto), "self");
    //     dto.addLink(getResourceUri(uriInfo), "all products");
    //     return dto;
    // }
}
