package pl.szczawip.blablacar.misc.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class Bean {

    private String name;

    @Autowired(required = false)
    private InjectedBean injectedBean;

    public Bean(){
        name = "constructor";
    }

    public Bean(String name){
        this.name = name;
    }

    public static Bean createInstance(){
        return new Bean("newInstance");
    }

    public void setName(String name){this.name = name;}

    public String getName(){
        return name;
    }

    public InjectedBean getInjectedBean(){
        return injectedBean;

    }
}
