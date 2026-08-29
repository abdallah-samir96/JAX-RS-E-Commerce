package iti.domain.utils;

import jakarta.annotation.PreDestroy;
import jakarta.ws.rs.core.Application;


public class JpaShutdownListener extends Application {

    @PreDestroy
    public void shutdown() {
        System.out.printf("Trying to destroy the EMF()!!!%n");
        JpaUtils.close();
    }
}
