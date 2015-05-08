package pl.szczawip.blablacar.util;

import org.hibernate.HibernateException;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;
import pl.szczawip.blablacar.model.Driver;
import pl.szczawip.blablacar.model.Ride;

import java.sql.SQLException;

/**
 * Created by szczawip on 5/2/2015.
 */
public class LocalhostCreateSchema {



    @Test
//    @Ignore
    public void schemaExport() throws HibernateException, SQLException {
        final org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.setProperty(AvailableSettings.USER, "postgres")
                .setProperty(AvailableSettings.PASS, "postgres")
                .setProperty(AvailableSettings.URL, "jdbc:postgresql://localhost:5433/blablacar_test")
                .setProperty(AvailableSettings.DIALECT, "org.hibernate.dialect.PostgreSQLDialect")
                .setProperty(AvailableSettings.DRIVER, "org.postgresql.Driver")
                .addAnnotatedClass(Ride.class)
                .addAnnotatedClass(Driver.class);
        SchemaExport schemaExport =  new SchemaExport(configuration);

        schemaExport.drop(true,true);
        schemaExport.create(true, true);
    }
}
