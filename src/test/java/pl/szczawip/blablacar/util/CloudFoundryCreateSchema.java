package pl.szczawip.blablacar.util;

import org.hibernate.HibernateException;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;
import pl.szczawip.blablacar.domain.Driver;
import pl.szczawip.blablacar.domain.Ride;

import java.sql.SQLException;

public class CloudFoundryCreateSchema {


    @Test
    public void schemaExport() throws HibernateException, SQLException {
        final org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.setProperty(AvailableSettings.USER, "crmqylzt")
                .setProperty(AvailableSettings.PASS, "PVXqTBAIQNsM-UGmFOSmTvYjp688-lOg")
                .setProperty(AvailableSettings.URL, "jdbc:postgresql://babar.elephantsql.com:5432/crmqylzt")
                .setProperty(AvailableSettings.DIALECT, "org.hibernate.dialect.PostgreSQLDialect")
                .setProperty(AvailableSettings.DRIVER, "org.postgresql.Driver")
                .addAnnotatedClass(Ride.class)
                .addAnnotatedClass(Driver.class);
        SchemaExport schemaExport =  new SchemaExport(configuration);

        schemaExport.drop(true,true);
        schemaExport.create(true, true);
    }
}
