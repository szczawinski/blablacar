package pl.szczawip.blablacar.misc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.szczawip.blablacar.misc.bean.TestBean;


public class JavaConfigTest {


    @Test
    public void shouldLoadJavaBasedConfig(){
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
        //when
        TestBean testBean = context.getBean("bean1", TestBean.class);
        //then
        Assert.assertNotNull(testBean);
        Assert.assertNotNull(testBean.getInjectedBean());
        Assert.assertEquals("autowired", testBean.getInjectedBean().getName());
    }


}