package pl.szczawip.blablacar.misc.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class LifecycleBean {
    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("init");
    }

    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("destroy");
    }
}
