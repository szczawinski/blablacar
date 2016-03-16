package pl.szczawip.blablacar.misc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.szczawip.blablacar.misc.bean.Bean;
import pl.szczawip.blablacar.misc.config.ComponentScanConfig;
import pl.szczawip.blablacar.misc.config.Config;
import pl.szczawip.blablacar.misc.config.ProfiledConfg;
import pl.szczawip.blablacar.misc.config.PropertySourceConfig;


public class Spring3Test {



    @Test
    public void testJavaConfig() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        Bean bean = ctx.getBean(Bean.class);
        Assert.assertNotNull(bean);
        Assert.assertNotNull(bean.getInjectedBean());

    }


    @Test
         public void buildContainerProgramatically() throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(Config.class);
        ctx.refresh();
        Bean bean = ctx.getBean(Bean.class);
        Assert.assertNotNull(bean);
        Assert.assertNotNull(bean.getInjectedBean());
    }


    @Test
    public void loadBeansFromComponentScan() throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        pl.szczawip.blablacar.misc.bean.anotated.TestBean testBean = ctx.getBean(pl.szczawip.blablacar.misc.bean.anotated.TestBean.class);
        Assert.assertNotNull(testBean);
    }


    @Test
    public void getProfiledBeans() throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("dev");
        ctx.register(ProfiledConfg.class);
        ctx.refresh();
        Bean bean = ctx.getBean(Bean.class);
        Assert.assertEquals("dev", bean.getName());
    }


    @Test
    public void testPropertySourceConfig() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(PropertySourceConfig.class);
        Bean bean = ctx.getBean(Bean.class);
        Assert.assertNotNull(bean);
        Assert.assertEquals("nameFromPropertySource", bean.getName());

    }
}
