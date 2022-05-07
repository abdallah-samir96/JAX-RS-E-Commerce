package iti.services;

import java.util.List;
import java.util.stream.Collectors;

import iti.daos.CustomerDao;
import iti.domain.customers.dtos.CustomerGetDto;
import iti.domain.utils.CustomersMapper;

public class CustomerService {
    private CustomerDao dao;

    public CustomerService(){
        this.dao = new CustomerDao();
    }
       
    public CustomerGetDto findCustomer(long id){
        var customer = dao.getCustomerById(id);
        if( customer != null)
        return  CustomersMapper.entityToGet(customer);

        return null;
    }

    public List<CustomerGetDto> getAllCustomers(){
        var customerdtos = dao.getAllCustomers().stream().map(customer ->{
            return CustomersMapper.entityToGet(customer);
        }).collect(Collectors.toList());

        
        return customerdtos;
    }
}
