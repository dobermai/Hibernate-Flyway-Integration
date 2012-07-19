package de.dobermai;

import com.googlecode.flyway.core.Flyway;
import com.googlecode.flyway.core.util.jdbc.DriverDataSource;
import com.mysql.jdbc.Driver;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.metamodel.source.MetadataImplementor;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

import java.sql.SQLException;

/**
 * @author dobermai
 */
public class FlywayIntegrator implements Integrator {
    @Override
    public void integrate(final Configuration configuration, final SessionFactoryImplementor sessionFactoryImplementor, final SessionFactoryServiceRegistry sessionFactoryServiceRegistry) {
        System.out.println("I do it!");
        final Flyway flyway = new Flyway();
        try {
            flyway.setDataSource(new DriverDataSource(new Driver(), "jdbc:mysql://localhost:8889/testdb", "root", "root"));
        } catch (SQLException e) {
            System.out.println(e);
        }
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
