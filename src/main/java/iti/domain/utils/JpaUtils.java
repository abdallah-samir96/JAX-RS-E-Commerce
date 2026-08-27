package iti.domain.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * For handling emf open & closing!!!
 * EntityManager Factory is one per the application
 * EntityManager should be per request, to handle the context, it's not thread safe
 * */
public class JpaUtils {

    private static final String PERSISTENCE_NAME = "ecommerce";
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_NAME);

    public static EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }
    public static EntityManager createEntityManager() {
        return emf.createEntityManager();
    }
    public static void close() {
        emf.close();
    }
}
