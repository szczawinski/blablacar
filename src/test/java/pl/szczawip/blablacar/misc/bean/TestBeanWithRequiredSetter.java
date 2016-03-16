package pl.szczawip.blablacar.misc.bean;

import org.springframework.beans.factory.annotation.Required;

public class TestBeanWithRequiredSetter {


    private String name;

    @Required
    public void setName(String name){
        this.name = name;
    }

    public String getName(){return  name;}
}
