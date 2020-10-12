package co.com.jdti.springbootdi.app.models.services;

//@Primary
//@Component
public class MyServiceComplex implements IServices {

    @Override
    public String operation() {
        return "Execute complex service...";
    }

}
