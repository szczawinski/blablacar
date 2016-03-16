package pl.szczawip.blablacar.misc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.szczawip.blablacar.misc.bean.LifecycleBean;
import pl.szczawip.blablacar.misc.bean.Bean;
import pl.szczawip.blablacar.misc.bean.TestBeanWithRequiredSetter;


public class SpringTest {


    ApplicationContext context;

    @Before
    public void before(){

        context = new ClassPathXmlApplicationContext(new String[] {"applicationContext-test.xml"});
    }

    @Test
    public void beanConstruction() {
        //when
        Bean bean = context.getBean("testBean1", Bean.class);
        //then
        Assert.assertNotNull(bean);
        Assert.assertEquals("constructor", bean.getName());
    }


    @Test
    public void beanConstructionByFactoryMethod() {
        //when
        Bean bean = context.getBean("testBean2", Bean.class);
        //then
        Assert.assertNotNull(bean);
        Assert.assertEquals("newInstance", bean.getName());
    }

    @Test
    public void beanConstructionByFactoryBean() {
        //when
        Bean bean = context.getBean("testBean3", Bean.class);
        //then
        Assert.assertNotNull(bean);
        Assert.assertEquals("factory", bean.getName());
    }

    @Test
    public void beanConstructionByConstructorArg() {
        //when
        Bean bean = context.getBean("testBean4", Bean.class);
        //then
        Assert.assertNotNull(bean);
        Assert.assertEquals("constructor-arg", bean.getName());
    }

    @Test
    public void beanWithReplacedMethod() {
        //when
        Bean bean = context.getBean("testBean5", Bean.class);
        //then
        Assert.assertNotNull(bean);
        Assert.assertEquals("method-replaced", bean.getName());
    }

    @Test
    public void beanWithAutowiredBean() {
        //when
        Bean bean = context.getBean("testBean1", Bean.class);
        //then
        Assert.assertNotNull(bean);
        Assert.assertNotNull(bean.getInjectedBean());
        Assert.assertEquals("autowired", bean.getInjectedBean().getName());
    }

    @Test
    public void beanWithRequiredSetter(){
        //when
        TestBeanWithRequiredSetter testBeanWithRequiredSetter = context.getBean("testBeanWithRequiredSetter", TestBeanWithRequiredSetter.class);
        //then
        Assert.assertNotNull(testBeanWithRequiredSetter);
        Assert.assertEquals("autowired", testBeanWithRequiredSetter.getName());
    }


    @Test
    public void lifecycleBean() {
        context.getBean("lifecycleBean", LifecycleBean.class);
    }

    @Test
    public void beanWithProperties() throws Exception {
        Bean beanWithProperties = context.getBean("beanWithProperties", Bean.class);
        Assert.assertEquals("nameFromProperties", beanWithProperties.getName());

    }
}
