package de.dobermai;

import de.dobermai.model.TestEntity;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Logger;

/**
 * @author dobermai
 */
@Startup
@Singleton
public class StartupBean {

    private final static Logger logger = Logger.getLogger("StartupBean");

    @PersistenceContext
    EntityManager manager;

    @PostConstruct
    public void init() {
        logger.info("Persisting new Test Entity");
        manager.persist(new TestEntity());
    }

}
