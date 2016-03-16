package pl.szczawip.blablacar.misc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.szczawip.blablacar.misc.bean.Bean;
import pl.szczawip.blablacar.misc.config.Config;


public class JavaConfigTest {


    @Test
    public void shouldLoadJavaBasedConfig(){
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        //when
        Bean bean = context.getBean("bean1", Bean.class);
        //then
        Assert.assertNotNull(bean);
        Assert.assertNotNull(bean.getInjectedBean());
        Assert.assertEquals("autowired", bean.getInjectedBean().getName());
    }
}
