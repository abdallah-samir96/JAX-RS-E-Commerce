package iti.daos;

import iti.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProductDao {
    private EntityManagerFactory emf;
    private EntityManager em;

    public ProductDao(){
        emf =Persistence.createEntityManagerFactory("ecommerce");
        em = emf.createEntityManager();
    }

    //getAll => GET
    //getOne => GET
    //addOne => POST
    //editOne => PATCH
    //deleteOne => DELETE

    /*
    ** URL products [getAll & addOne]
    ** URL profuct/{id} [getOne & editOne & deleteOne]
    */

    public Product getProductById(long id){
        //return service.findProduct(id);
        Product product = em.find(Product.class, id);
        if(product != null){
            em.close();
            return product;
        }else {
            em.close();
            return null;
        }
    }
}
