/*
 * Copyright (c) 2012 Dominik Obermaier.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author dobermai
 */
public class FlywayIntegrator implements Integrator {

    public static final Logger logger = Logger.getLogger("FlywayIntegrator");

    @Override
    public void integrate(final Configuration configuration, final SessionFactoryImplementor sessionFactoryImplementor, final SessionFactoryServiceRegistry sessionFactoryServiceRegistry) {

        logger.log(Level.INFO, "Starting Flyway Migration");

        final Flyway flyway = new Flyway();
        try {
            flyway.setDataSource(new DriverDataSource(new Driver(), "jdbc:mysql://localhost:8889/testdb", "root", "root"));
            flyway.migrate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error while migrating:", e);
        }
        logger.log(Level.INFO, "Finished Flyway Migration");
    }

    @Override
    public void integrate(final MetadataImplementor metadataImplementor, final SessionFactoryImplementor sessionFactoryImplementor, final SessionFactoryServiceRegistry sessionFactoryServiceRegistry) {
        //no-op
    }

    @Override
    public void disintegrate(final SessionFactoryImplementor sessionFactoryImplementor, final SessionFactoryServiceRegistry sessionFactoryServiceRegistry) {
        //no-op
    }
}
