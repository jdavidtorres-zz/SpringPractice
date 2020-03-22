package co.com.jdti.springbootdi.app.models.services;

import org.springframework.stereotype.Component;

@Component
public class MyService implements IServices{

    @Override
    public String operation() {
        return "Execute...";
    }

}
