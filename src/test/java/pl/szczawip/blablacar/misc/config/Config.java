package pl.szczawip.blablacar.misc.config;

import org.springframework.context.annotation.Configuration;
import pl.szczawip.blablacar.misc.bean.InjectedBean;
import pl.szczawip.blablacar.misc.bean.Bean;

@Configuration
public class Config {

    @org.springframework.context.annotation.Bean(name = "bean1")
    public Bean testBean(){
        return new Bean();
    }

    @org.springframework.context.annotation.Bean
    public InjectedBean injectedBean(){
        return new InjectedBean();
    }
}
