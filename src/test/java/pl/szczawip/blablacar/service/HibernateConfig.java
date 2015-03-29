package pl.szczawip.blablacar.service;


import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pl.szczawip.blablacar.model.Ride;
import pl.szczawip.blablacar.repository.RideRepository;
import pl.szczawip.blablacar.repository.hibernate.HibernateRideRepositoryImpl;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {


    @Bean
    public BlaBlaService blaBlaService() {
        return new BlaBlaServiceImpl();
    }

    @Bean
    public RideRepository rideRepository(){
        return new HibernateRideRepositoryImpl();
    }


    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://127.0.0.1:5433/blablacar");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");
        return dataSource;
    }

    @Bean
    public SessionFactory sessionFactory() {
        final LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource());
        localSessionFactoryBuilder.addAnnotatedClass(Ride.class);
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
        configuration.setProperty(AvailableSettings.USER, "postgres")
                .setProperty(AvailableSettings.PASS, "postgres")
                .setProperty(AvailableSettings.URL, "jdbc:postgresql://localhost:5433/blablacar")
                .setProperty(AvailableSettings.DIALECT, "org.hibernate.dialect.PostgreSQLDialect")
                .setProperty(AvailableSettings.DRIVER, "org.postgresql.Driver")
                .addAnnotatedClass(Ride.class);
        return new SchemaExport(configuration);
    }
}
