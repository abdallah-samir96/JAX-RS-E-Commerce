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

    public CategoriesDao(){
        emf =Persistence.createEntityManagerFactory("ecommerce");
        em = emf.createEntityManager();
    }

   
    public Category getCategoryById(long id){
        Category category = em.find(Category.class, id);
        if(category != null){
            em.close();
            return category;
        }else {
            em.close();
            return null;
        }
    }
    public List<Category> getAllCategories(){

        String qlQuery = "SELECT c FROM Category c";
        Query query = em.createQuery(qlQuery);
        List<Category> categories = query.getResultList();
        if(categories.size() > 0)
            return categories;
        return null;
       }

}
