package iti.daos;

import iti.domain.utils.JpaUtils;
import iti.entities.Product;
import jakarta.persistence.Query;

import java.util.List;


public class ProductDao {

    public Product getProductById(long id) {
        var em = JpaUtils.createEntityManager();
        try {
            return em.find(Product.class, id);
        } finally {
            em.close();
        }
    }

    public List<Product> getAllProducts() {
        var em = JpaUtils.createEntityManager();
        try {

            String qlQuery = "SELECT p FROM Product p";
            Query query = em.createQuery(qlQuery);
            List<Product> products = query.getResultList();
            if (!products.isEmpty())
                return products;
            return List.of();
        } finally {
            em.close();
        }
    }

    public void addProduct(Product product) {
        var em = JpaUtils.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    public void deleteProduct(long id) {
        var em = JpaUtils.createEntityManager();
        Product product = em.find(Product.class, id);
        if (product != null) {
            em.getTransaction().begin();
            em.remove(product);
            em.getTransaction().commit();
        }
    }

    public void deleteAllProduct() {
        var em = JpaUtils.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createNativeQuery("Delete from products");
        query.executeUpdate();
        em.getTransaction().commit();
    }

}
