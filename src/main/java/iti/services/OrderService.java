package iti.services;

import java.util.List;
import java.util.stream.Collectors;

import iti.daos.OrderDao;
import iti.domain.order.dtos.OrderGetDto;
import iti.domain.utils.OrderMapper;

public class OrderService {
    private OrderDao dao;

    public OrderService(){
        this.dao = new OrderDao();
    }
       
    public OrderGetDto findOrder(long id){
        var order = dao.getOrderById(id);
        if( order != null)
        return  OrderMapper.entityToGet(order);

        return null;
    }

    public List<OrderGetDto> getAllOrders(){
        var orderdtos = dao.getAllOrders().stream().map(order ->{
            return OrderMapper.entityToGet(order);
        }).collect(Collectors.toList());

        
        return orderdtos;
    }
}
