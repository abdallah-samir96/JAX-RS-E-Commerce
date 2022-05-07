package iti.domain.utils;

import iti.domain.order.dtos.OrderGetDto;
import iti.domain.order.dtos.OrderPostDto;
import iti.entities.Order;

public class OrderMapper {
 
    public static OrderGetDto entityToGet( Order entity ) {
        OrderGetDto getDto = new OrderGetDto(entity.getId(), entity.getName());
        return getDto;
    }

    public static Order postToEntity( OrderPostDto orderPostDto ) {
        Order order = new Order(null, orderPostDto.getName());
        return order;
    }
}
