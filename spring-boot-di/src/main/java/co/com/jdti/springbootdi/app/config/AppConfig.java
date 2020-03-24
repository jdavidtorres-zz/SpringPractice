package co.com.jdti.springbootdi.app.config;

import co.com.jdti.springbootdi.app.models.services.IServices;
import co.com.jdti.springbootdi.app.models.services.MyService;
import co.com.jdti.springbootdi.app.models.services.MyServiceComplex;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean("MyComplexService")
    public IServices registerServices() {
        return new MyServiceComplex();
    }

}
