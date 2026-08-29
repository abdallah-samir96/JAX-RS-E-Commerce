package iti.domain.utils;

import iti.domain.customers.dtos.CustomerGetDto;
import iti.domain.customers.dtos.CustomerPostDto;
import iti.entities.Customer;

public class CustomersMapper {
    

    public static CustomerGetDto entityToGet( Customer entity ) {
        return new CustomerGetDto(entity.getId(), entity.getName(), entity.getEmail(), entity.getGender());
    }

    public static Customer postToEntity( CustomerPostDto customerPostDto ) {
        return new Customer(null, customerPostDto.getName(), customerPostDto.getEmail(), customerPostDto.getGender());
    }

}
