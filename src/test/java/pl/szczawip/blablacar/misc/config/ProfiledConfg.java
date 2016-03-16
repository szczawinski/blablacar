package pl.szczawip.blablacar.misc.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pl.szczawip.blablacar.misc.bean.Bean;

@Configuration
public class ProfiledConfg {

    @org.springframework.context.annotation.Bean
    @Profile("dev")
    public Bean devBean(){
        return new Bean("dev");
    }

    @org.springframework.context.annotation.Bean
    @Profile("prod")
    public Bean prodBean(){
        return new Bean("prod");
    }


}
