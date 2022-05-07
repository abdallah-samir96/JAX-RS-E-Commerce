package iti.resources;

import java.util.List;

import iti.domain.category.dtos.CategoryGetDto;
import iti.domain.order.dtos.OrderGetDto;
import iti.services.OrderService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("orders")
public class OrderResource {
    private OrderService service;

    public OrderResource(){
        this.service = new OrderService();
    }

     
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findOrder(@PathParam("id") long id){
        var order = service.findOrder(id);
        return Response.ok().entity(order).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOrders(){
        
        var list = service.getAllOrders();
        GenericEntity entity = new GenericEntity<List<OrderGetDto>>(list){};
        return Response.ok().entity(entity).build();

    }
}
