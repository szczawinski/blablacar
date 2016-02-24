package pl.szczawip.blablacar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@Import({Config.class, TestProperties.class})
public class ControllersConfig {
}
