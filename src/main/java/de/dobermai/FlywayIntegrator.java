package de.dobermai;

import com.googlecode.flyway.core.Flyway;
import com.googlecode.flyway.core.util.jdbc.DriverDataSource;
import org.h2.Driver;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.metamodel.source.MetadataImplementor;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

/**
 * @author dobermai
 */
public class FlywayIntegrator implements Integrator {
    @Override
    public void integrate(final Configuration configuration, final SessionFactoryImplementor sessionFactoryImplementor, final SessionFactoryServiceRegistry sessionFactoryServiceRegistry) {
        System.out.println("I do it!");
        final Flyway flyway = new Flyway();
        flyway.setDataSource(new DriverDataSource(new Driver(), "jdbc:h2:mem:flywayresource;DB_CLOSE_ON_EXIT=FALSE", "sa", "sa"));
        flyway.migrate();
        System.out.println("Im done!");
    }

    @Override
    public void integrate(final MetadataImplementor metadataImplementor, final SessionFactoryImplementor sessionFactoryImplementor, final SessionFactoryServiceRegistry sessionFactoryServiceRegistry) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void disintegrate(final SessionFactoryImplementor sessionFactoryImplementor, final SessionFactoryServiceRegistry sessionFactoryServiceRegistry) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
