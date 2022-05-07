package iti;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
public class App {
public static void main(String[] args) {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecommerce");
    EntityManager em = emf.createEntityManager();
    /*
    em.getTransaction().begin();
    var customer = new Customer();
    var order = new Order();
    order.setName("Hosam order");
    List<Order> orders = new LinkedList<>();
    orders.add(order);
    customer.setName("Hosam Bakalola");
    customer.setOrders(orders);

    em.persist(order);
    em.persist(customer);
    em.getTransaction().commit();

    em.close();
   */
}
}