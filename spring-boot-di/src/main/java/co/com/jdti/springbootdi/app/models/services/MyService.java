package co.com.jdti.springbootdi.app.models.services;

//@Component
public class MyService implements IServices {

    @Override
    public String operation() {
        return "Execute simple service...";
    }

}
