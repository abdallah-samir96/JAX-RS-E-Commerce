package iti.resources;

import iti.domain.order.dtos.OrderPostDto;
import iti.services.OrderService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("orders")
public class OrderResource {
    private final OrderService service;

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
        var entity = new GenericEntity<>(list) {};
        return Response.ok().entity(entity).build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addOrder(OrderPostDto dto){
          service.addOrder(dto);
          return Response.ok().status(200).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response deleteOrder(@PathParam("id") long id){
            service.deleteOrder(id);
            return Response.ok().status(200).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAllOrders(){
            service.deleteAllOrders();
            return Response.ok().status(200).build();
    }
}
