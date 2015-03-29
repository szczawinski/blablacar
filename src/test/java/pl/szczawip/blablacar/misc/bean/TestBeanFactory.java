package pl.szczawip.blablacar.misc.bean;

import pl.szczawip.blablacar.misc.bean.TestBean;

/**
 * Created by szczawip on 3/23/2015.
 */
public class TestBeanFactory {

    public TestBean createTestBean(){
        return new TestBean("factory");
    }
}
