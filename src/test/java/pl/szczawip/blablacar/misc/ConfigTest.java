package pl.szczawip.blablacar.misc;

import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.szczawip.blablacar.config.Config;
import pl.szczawip.blablacar.config.TestProperties;

import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class, TestProperties.class})
public class ConfigTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    SessionFactory sessionFactory;

    @Test
    public void loadPropertySource(){
        Assert.assertNotNull("Bean datasource not loaded", dataSource);
        DriverManagerDataSource driverManagerDataSource  = (DriverManagerDataSource) dataSource;
        System.out.println(driverManagerDataSource.getUrl());
        Assert.assertNotNull("Bean datasource not loaded", sessionFactory);
        System.out.println(sessionFactory.getClass());

    }
}