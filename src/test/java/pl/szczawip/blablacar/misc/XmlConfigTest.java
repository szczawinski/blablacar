package pl.szczawip.blablacar.misc;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.sql.DataSource;

public class XmlConfigTest {


    @Test
    @Ignore
    public void loadXmlConfig() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");//"application-config.xml");
        DataSource bean = context.getBean("dataSource", DataSource.class);


    }
}
