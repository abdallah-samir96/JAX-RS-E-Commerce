package iti.daos;

import iti.domain.utils.JpaUtils;
import iti.entities.Order;
import jakarta.persistence.Query;

import java.util.List;

public class OrderDao {

    public Order getOrderById(long id) {
        var em = JpaUtils.createEntityManager();
        try {
            return em.find(Order.class, id);
        }finally {
            em.close();
        }
    }

    public List<Order> getAllOrders() {
        var em = JpaUtils.createEntityManager();
        try {
            String qlQuery = "SELECT o FROM Order o";
            Query query = em.createQuery(qlQuery);
            List<Order> orders = query.getResultList();
            System.out.println("is the order empty: " + orders.isEmpty() + ", orders: " + orders);
            if (!orders.isEmpty())
                 return orders;
            return List.of();
        }finally {
            em.close();;
        }
    }

    public void addOrder(Order order) {
        var em = JpaUtils.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(order);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    public void deleteOrder(long id) {
        var em = JpaUtils.createEntityManager();
        try {
            Order order = em.find(Order.class, id);
            if (order != null) {
                em.getTransaction().begin();
                em.remove(order);
                em.getTransaction().commit();
            }
        }finally {
            em.close();;
        }

    }

    public void deleteAllOrders() {
        var em = JpaUtils.createEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createNativeQuery("Delete from orders");
            query.executeUpdate();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

}
