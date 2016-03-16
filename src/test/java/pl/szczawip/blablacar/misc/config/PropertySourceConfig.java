package pl.szczawip.blablacar.misc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import pl.szczawip.blablacar.misc.bean.Bean;

@Configuration
@PropertySource("classpath:test.properties")
public class PropertySourceConfig {

    @Autowired
    Environment env;


    @org.springframework.context.annotation.Bean
    public Bean propertyBean(){
        return new Bean(env.getProperty("name2"));
    }
}
