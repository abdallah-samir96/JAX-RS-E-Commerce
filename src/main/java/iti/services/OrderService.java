package iti.services;

import iti.daos.OrderDao;
import iti.domain.order.dtos.OrderGetDto;
import iti.domain.order.dtos.OrderPostDto;
import iti.domain.utils.OrderMapper;

import java.util.List;
import java.util.stream.Collectors;

public class OrderService {
    private final OrderDao dao;

    public OrderService(){
        this.dao = new OrderDao();
    }
       
    public OrderGetDto findOrder(long id){
        var order = dao.getOrderById(id);
        return (order != null)? OrderMapper.entityToGet(order): null;
    }

    public List<OrderGetDto> getAllOrders(){
        return dao.getAllOrders()
                .stream()
                .map(OrderMapper::entityToGet)
                .collect(Collectors.toList());
    }

    public void addOrder(OrderPostDto orderDto){
        var order =  OrderMapper.postToEntity(orderDto);
        dao.addOrder(order);
     }
 
     public void deleteOrder(long id){
         dao.deleteOrder(id);
     }
 
     public void deleteAllOrders(){
         dao.deleteAllOrders();
     }
}
