package pl.szczawip.blablacar.config;


import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
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
import pl.szczawip.blablacar.web.controller.RideController;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class HibetnatePostgreSQLConfig {


    @Bean
    public RideController rideController(){
        return  new RideController();
    }

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
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://127.0.0.1:5433/blablacar_test");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");
        return dataSource;
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


}
