package iti.daos;

import iti.domain.utils.JpaUtils;
import iti.entities.Category;
import jakarta.persistence.Query;
import java.util.List;

public class CategoriesDao {

    public Category getCategoryById(long id) {
        var em = JpaUtils.createEntityManager();
        try {
            return em.find(Category.class, id);
        }finally {
            em.close();
        }
    }

    public List<Category> getAllCategories() {

        var em = JpaUtils.createEntityManager();
        try {
            String qlQuery = "SELECT c FROM Category c";
            Query query = em.createQuery(qlQuery);
            List<Category> categories = query.getResultList();
            if (!categories.isEmpty())
                return categories;
            return List.of();
        } finally {
            em.close();
        }
    }

    public void addCategory(Category category) {
        var em = JpaUtils.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(category);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    public void deleteCategory(long id) {

        var em = JpaUtils.createEntityManager();
        try {
            Category category = em.find(Category.class, id);
            if (category != null) {
                em.getTransaction().begin();
                em.remove(category);
                em.getTransaction().commit();
            }
        }finally {
            em.close();
        }

    }

    public void deleteAllCategories() {
        var em = JpaUtils.createEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createNativeQuery("Delete from categories");
            query.executeUpdate();
            em.getTransaction().commit();
        }finally {
            em.close();
        }

    }

}
