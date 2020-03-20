package co.com.jdti.springbootweb.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource("classpath:text.properties")
})
public class TextPropertiesConfig {
}
