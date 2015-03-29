package pl.szczawip.blablacar.misc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.szczawip.blablacar.misc.bean.TestBean;

/**
 * Created by szczawip on 3/19/2015.
 */
public class SpringTest {


    ApplicationContext context;

    @Before
    public void before(){

        context = new ClassPathXmlApplicationContext(new String[] {"applicationContext-test.xml"});
    }

    @Test
    public void beanConstruction() {
        //when
        TestBean testBean = context.getBean("testBean1", TestBean.class);
        //then
        Assert.assertNotNull(testBean);
        Assert.assertEquals("constructor", testBean.getName());
    }


    @Test
    public void beanConstructionByFactoryMethod() {
        //when
        TestBean testBean = context.getBean("testBean2", TestBean.class);
        //then
        Assert.assertNotNull(testBean);
        Assert.assertEquals("newInstance", testBean.getName());
    }

    @Test
    public void beanConstructionByFactoryBean() {
        //when
        TestBean testBean = context.getBean("testBean3", TestBean.class);
        //then
        Assert.assertNotNull(testBean);
        Assert.assertEquals("factory", testBean.getName());
    }

    @Test
    public void beanConstructionByConstructorArg() {
        //when
        TestBean testBean = context.getBean("testBean4", TestBean.class);
        //then
        Assert.assertNotNull(testBean);
        Assert.assertEquals("constructor-arg", testBean.getName());
    }

    @Test
    public void beanWithReplacedMethod() {
        //when
        TestBean testBean = context.getBean("testBean5", TestBean.class);
        //then
        Assert.assertNotNull(testBean);
        Assert.assertEquals("method-replaced", testBean.getName());
    }

    @Test
    public void beanWithAutowiredBean() {
        //when
        TestBean testBean = context.getBean("testBean1", TestBean.class);
        //then
        Assert.assertNotNull(testBean);
        Assert.assertNotNull(testBean.getInjectedBean());
        Assert.assertEquals("autowired", testBean.getInjectedBean().getName());
    }


}
