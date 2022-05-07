package iti.resources;

import java.util.List;

import iti.domain.category.dtos.CategoryGetDto;
import iti.services.CategoryService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("categories")
public class CategoryResource {
    private CategoryService service;

    public CategoryResource(){
        this.service = new CategoryService();
    }

     
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCategory(@PathParam("id") long id){
        var category = service.findCategory(id);
        return Response.ok().entity(category).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCategories(){
        var list = service.getAllCategories();
        GenericEntity entity = new GenericEntity<List<CategoryGetDto>>(list){};
        return Response.ok(entity).build();

    }

}
