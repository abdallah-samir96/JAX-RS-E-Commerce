package iti.services;

import iti.daos.CustomerDao;
import iti.domain.customers.dtos.CustomerGetDto;
import iti.domain.customers.dtos.CustomerPostDto;
import iti.domain.utils.CustomersMapper;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerService {
    private final CustomerDao dao;

    public CustomerService() {
        this.dao = new CustomerDao();
    }

    public CustomerGetDto findCustomer(long id) {
        var customer = dao.getCustomerById(id);
        if (customer != null)
            return CustomersMapper.entityToGet(customer);
        return null;
    }

    public List<CustomerGetDto> getAllCustomers() {

        return dao.getAllCustomers().stream().map(CustomersMapper::entityToGet).collect(Collectors.toList());
    }

    public void addCustomer(CustomerPostDto customerDto) {
        var customer = CustomersMapper.postToEntity(customerDto);
        dao.addCustomer(customer);
    }

    public void deleteCustomer(long id) {
        dao.deleteCustomer(id);
    }

    public void deleteAllCustomers() {
        dao.deleteAllCustomers();
    }
}
