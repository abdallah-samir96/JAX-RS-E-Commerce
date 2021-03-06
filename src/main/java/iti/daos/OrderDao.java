package iti.daos;

import java.util.List;
import iti.entities.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class OrderDao {
    private EntityManagerFactory emf;
    private EntityManager em;

    public OrderDao() {
        emf = Persistence.createEntityManagerFactory("ecommerce");
        em = emf.createEntityManager();
    }

    public Order getOrderById(long id) {
        // return service.findProduct(id);
        Order order = em.find(Order.class, id);
        if (order != null) {
            em.close();
            return order;
        } else {
            em.close();
            return null;
        }
    }

    public List<Order> getAllOrders() {

        String qlQuery = "SELECT o FROM Order o";
        Query query = em.createQuery(qlQuery);
        List<Order> orders = query.getResultList();
        if (orders.size() > 0)
            return orders;
        return null;
    }

    public void addOrder(Order order) {
        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();
    }

    public void deleteOrder(long id) {

        Order order = em.find(Order.class, id);
        if (order != null) {
            em.getTransaction().begin();
            em.remove(order);
            em.getTransaction().commit();
        }

    }

    public void deleteAllOrders() {
        em.getTransaction().begin();
        Query query = em.createNativeQuery("Delete from orders");
        query.executeUpdate();
        em.getTransaction().commit();
    }

}
