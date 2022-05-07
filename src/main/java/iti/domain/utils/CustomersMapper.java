package iti.domain.utils;

import iti.domain.customers.dtos.CustomerGetDto;
import iti.domain.customers.dtos.CustomerPostDto;
import iti.entities.Customer;

public class CustomersMapper {
    

    public static CustomerGetDto entityToGet( Customer entity ) {
        CustomerGetDto getDto = new CustomerGetDto(entity.getId(), entity.getName(), entity.getEmail(), entity.getGender());
        return getDto;
    }

    public static Customer postToEntity( CustomerPostDto customerPostDto ) {
        Customer customer = new Customer(null, customerPostDto.getName(), customerPostDto.getEmail(), customerPostDto.getGender());
        return customer;
    }

}
