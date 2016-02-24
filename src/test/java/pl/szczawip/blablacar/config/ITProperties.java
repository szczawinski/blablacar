package pl.szczawip.blablacar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/datasource-it.properties")
public class ITProperties {
}
