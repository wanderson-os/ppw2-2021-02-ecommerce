package br.edu.iftm.ecommerce.util;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class PersistenceFactory implements Serializable {
    
    @Produces
    public EntityManager getEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecommercePU");
        EntityManager em = emf.createEntityManager();
        return em;
    }
    
}
