package iti.daos;

import java.util.List;

import iti.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;


public class ProductDao {
    private EntityManagerFactory emf;
    private EntityManager em;

    public ProductDao() {
        emf = Persistence.createEntityManagerFactory("ecommerce");
        em = emf.createEntityManager();
    }

    public Product getProductById(long id) {
        // return service.findProduct(id);
        Product product = em.find(Product.class, id);
        if (product != null) {
            em.close();
            return product;
        } else {
            em.close();
            return null;
        }
    }

    public List<Product> getAllProducts() {

        String qlQuery = "SELECT p FROM Product p";
        Query query = em.createQuery(qlQuery);
        List<Product> products = query.getResultList();
        if (products.size() > 0)
            return products;
        return null;
    }

    public void addProduct(Product product) {
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
    }

    public void deleteProduct(long id) {

        Product product = em.find(Product.class, id);
        if (product != null) {
            em.getTransaction().begin();
            em.remove(product);
            em.getTransaction().commit();
        }
    }

    public void deleteAllProduct() {
        em.getTransaction().begin();
        Query query = em.createNativeQuery("Delete from products");
        query.executeUpdate();
        em.getTransaction().commit();
    }

}
