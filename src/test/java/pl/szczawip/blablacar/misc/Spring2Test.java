package pl.szczawip.blablacar.misc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.szczawip.blablacar.misc.bean.anotated.TestBean;


public class Spring2Test {


    @Test
    public void beanConstruction() {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext-test2.xml"});
        //when
        TestBean testBean = context.getBean("testBean", TestBean.class);
        //then
        Assert.assertNotNull(testBean);
    }


    @Test
    public void messageSource() {
        MessageSource resources = new ClassPathXmlApplicationContext("applicationContext-messageSource.xml");
        String message = resources.getMessage("message", null, "Default", null);
        Assert.assertEquals("Alligators rock!", message);
    }


}
