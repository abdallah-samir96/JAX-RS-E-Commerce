package iti.daos;

import iti.domain.utils.JpaUtils;
import iti.entities.Customer;
import jakarta.persistence.Query;

import java.util.List;

public class CustomerDao {

    public List<Customer> getAllCustomers() {

        var em = JpaUtils.createEntityManager();
        try {
            String qlQuery = "SELECT c FROM Customer c";
            Query query = em.createQuery(qlQuery);
            List<Customer> customers = query.getResultList();
            if (!customers.isEmpty())
                return customers;
            return List.of();
        }finally {
            em.close();
        }
    }

    public Customer getCustomerById(long id) {

        var em = JpaUtils.createEntityManager();
        try {
            return em.find(Customer.class, id);
        }finally {
            em.close();
        }
    }

    public void addCustomer(Customer customer) {
        var em = JpaUtils.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
        }finally {
            em.close();
        }

    }

    public void deleteCustomer(long id) {

        var em = JpaUtils.createEntityManager();
        try {
            Customer customer = em.find(Customer.class, id);
            if (customer != null) {
                em.getTransaction().begin();
                em.remove(customer);
                em.getTransaction().commit();
            }
        }finally {
            em.close();
        }

    }

    public void deleteAllCustomers() {
        var em = JpaUtils.createEntityManager();
        try {

            em.getTransaction().begin();
            Query query = em.createNativeQuery("Delete from customers");
            query.executeUpdate();
            em.getTransaction().commit();

        }finally {
            em.close();
        }

    }
}
