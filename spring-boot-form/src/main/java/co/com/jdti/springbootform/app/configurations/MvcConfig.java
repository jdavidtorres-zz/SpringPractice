package co.com.jdti.springbootform.app.configurations;

import co.com.jdti.springbootform.app.interceptors.TimeElapsedInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    private TimeElapsedInterceptor timeElapsed;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeElapsed);
    }
}
