package iti.daos;

import java.util.List;
import iti.entities.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class CategoriesDao {
    private EntityManagerFactory emf;
    private EntityManager em;

    public CategoriesDao() {
        emf = Persistence.createEntityManagerFactory("ecommerce");
        em = emf.createEntityManager();
    }

    public Category getCategoryById(long id) {
        Category category = em.find(Category.class, id);
        if (category != null) {
            em.close();
            return category;
        } else {
            em.close();
            return null;
        }
    }

    public List<Category> getAllCategories() {

        String qlQuery = "SELECT c FROM Category c";
        Query query = em.createQuery(qlQuery);
        List<Category> categories = query.getResultList();
        if (categories.size() > 0)
            return categories;
        return null;
    }

    public void addCategory(Category category) {
        em.getTransaction().begin();
        em.persist(category);
        em.getTransaction().commit();
    }

    public void deleteCategory(long id) {

        Category category = em.find(Category.class, id);
        if (category != null) {
            em.getTransaction().begin();
            em.remove(category);
            em.getTransaction().commit();
        }

    }

    public void deleteAllCategories() {
        em.getTransaction().begin();

        Query query = em.createNativeQuery("Delete from categories");
        query.executeUpdate();
        em.getTransaction().commit();

    }

}
