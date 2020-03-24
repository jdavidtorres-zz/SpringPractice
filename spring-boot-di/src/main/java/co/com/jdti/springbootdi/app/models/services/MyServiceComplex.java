package co.com.jdti.springbootdi.app.models.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class MyServiceComplex implements IServices {

    @Override
    public String operation() {
        return "Execute complex...";
    }

}
