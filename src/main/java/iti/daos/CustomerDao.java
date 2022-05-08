package iti.daos;

import java.util.List;

import iti.entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class CustomerDao {
    private EntityManagerFactory emf;
    private EntityManager em;

    public CustomerDao() {
        emf = Persistence.createEntityManagerFactory("ecommerce");
        em = emf.createEntityManager();
    }

    public List<Customer> getAllCustomers() {

        String qlQuery = "SELECT c FROM Customer c";
        Query query = em.createQuery(qlQuery);
        List<Customer> customers = query.getResultList();
        if (customers.size() > 0)
            return customers;
        return null;
    }

    public Customer getCustomerById(long id) {

        Customer customer = em.find(Customer.class, id);
        em.close();
        if (customer != null)
            return customer;

        return null;
    }

    public void addCustomer(Customer customer) {
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
    }

    public void deleteCustomer(long id) {

        Customer customer = em.find(Customer.class, id);
        if (customer != null) {
            em.getTransaction().begin();
            em.remove(customer);
            em.getTransaction().commit();

        }

    }

    public void deleteAllCustomers() {
        em.getTransaction().begin();
        Query query = em.createNativeQuery("Delete from customers");
        query.executeUpdate();
        em.getTransaction().commit();

    }
}
