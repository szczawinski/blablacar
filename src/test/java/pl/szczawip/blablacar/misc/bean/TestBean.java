package pl.szczawip.blablacar.misc.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class TestBean {

    private String name;

    @Autowired
    private InjectedBean injectedBean;

    public TestBean(){
        name = "constructor";
    }

    public TestBean(String name){
        this.name = name;
    }

    public static TestBean createInstance(){
        return new TestBean("newInstance");
    }

    public String getName(){
        return name;
    }

    public InjectedBean getInjectedBean(){
        return injectedBean;

    }
}
