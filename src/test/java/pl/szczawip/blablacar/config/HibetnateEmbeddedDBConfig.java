package pl.szczawip.blablacar.config;


import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import pl.szczawip.blablacar.model.Driver;
import pl.szczawip.blablacar.model.Ride;
import pl.szczawip.blablacar.repository.DriverRepository;
import pl.szczawip.blablacar.repository.RideRepository;
import pl.szczawip.blablacar.repository.hibernate.HibernateDriverRepository;
import pl.szczawip.blablacar.repository.hibernate.HibernateRideRepository;
import pl.szczawip.blablacar.service.BlaBlaService;
import pl.szczawip.blablacar.service.BlaBlaServiceImpl;

@Configuration
@EnableTransactionManagement
public class HibetnateEmbeddedDBConfig {


    @Bean
    public BlaBlaService blaBlaService() {
        return new BlaBlaServiceImpl();
    }

    @Bean
    public RideRepository rideRepository(){
        return new HibernateRideRepository();
    }
    @Bean
    public DriverRepository driverRepository(){
        return new HibernateDriverRepository();
    }

    @Bean
    public DataSource dataSource() {
        return new  EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL).setName("mydb").addScript("schema.sql")
                .build();

    }

    @Bean
    public SessionFactory sessionFactory() {
        final LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource());
        localSessionFactoryBuilder.addAnnotatedClass(Ride.class);
        localSessionFactoryBuilder.addAnnotatedClass(Driver.class);
        localSessionFactoryBuilder.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        return localSessionFactoryBuilder.buildSessionFactory();
    }

    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new HibernateTransactionManager(sessionFactory());
    }

    @Bean
    public SchemaExport schemaExport() throws HibernateException, SQLException {
        final org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.setProperty(AvailableSettings.USER, "sa")
                .setProperty(AvailableSettings.PASS, "")
                .setProperty(AvailableSettings.URL, "jdbc:hsqldb:mem:mydb")
                .setProperty(AvailableSettings.DIALECT, "org.hibernate.dialect.HSQLDialect")
                .setProperty(AvailableSettings.DRIVER, "org.hsqldb.jdbcDriver")
                .addAnnotatedClass(Ride.class)
                .addAnnotatedClass(Driver.class);
        return new SchemaExport(configuration);
    }
}
