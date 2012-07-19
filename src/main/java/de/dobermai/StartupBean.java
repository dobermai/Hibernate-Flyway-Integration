package de.dobermai;

import de.dobermai.model.TestEntity;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author dobermai
 */
@Startup
@Singleton
public class StartupBean {

    @PersistenceContext(unitName = "")
    EntityManager manager;

    @PostConstruct
    public void init()
    {
        System.out.println("BLUB!");
        manager.persist(new TestEntity());
    }

}
