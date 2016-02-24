package pl.szczawip.blablacar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/datasource-test.properties")
public class TestProperties {
}
