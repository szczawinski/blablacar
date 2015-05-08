package pl.szczawip.blablacar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@Import(HibetnatePostgreSQLConfig.class)
public class ControllersConfig {
}
