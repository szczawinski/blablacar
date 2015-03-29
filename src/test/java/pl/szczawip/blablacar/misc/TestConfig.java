package pl.szczawip.blablacar.misc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.szczawip.blablacar.misc.bean.InjectedBean;
import pl.szczawip.blablacar.misc.bean.TestBean;

@Configuration
public class TestConfig {

    @Bean(name = "bean1")
    public TestBean testBean(){
        return new TestBean();
    }

    @Bean
    public InjectedBean injectedBean(){
        return new InjectedBean();
    }
}
