package pl.szczawip.blablacar.util;

import org.hibernate.HibernateException;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;
import pl.szczawip.blablacar.domain.Driver;
import pl.szczawip.blablacar.domain.Ride;

import java.sql.SQLException;

/**
 * Created by szczawip on 5/2/2015.
 */
public class LocalhostCreateSchema {



    @Test
    public void schemaExport() throws HibernateException, SQLException {
        final org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.setProperty(AvailableSettings.USER, "admin")
                .setProperty(AvailableSettings.PASS, "admin")
                .setProperty(AvailableSettings.URL, "jdbc:mysql://localhost:3306/blablacar-prod")
                .setProperty(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQLDialect")
                .setProperty(AvailableSettings.DRIVER, "com.mysql.jdbc.Driver")
                .addAnnotatedClass(Ride.class)
                .addAnnotatedClass(Driver.class);
        SchemaExport schemaExport =  new SchemaExport(configuration);

        schemaExport.drop(true,true);
        schemaExport.create(true, true);
    }
}
