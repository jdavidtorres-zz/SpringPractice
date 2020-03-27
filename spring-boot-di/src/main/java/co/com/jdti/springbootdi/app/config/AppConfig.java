package co.com.jdti.springbootdi.app.config;

import co.com.jdti.springbootdi.app.models.domain.ItemBill;
import co.com.jdti.springbootdi.app.models.domain.Product;
import co.com.jdti.springbootdi.app.models.services.IServices;
import co.com.jdti.springbootdi.app.models.services.MyServiceComplex;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean("MyComplexService")
    public IServices registerServices() {
        return new MyServiceComplex();
    }

    @Bean("itemsBill")
    public List<ItemBill> registerItem() {
        Product product1 = new Product("Camera Sony", 100);
        Product product2 = new Product("Bike Standard", 200);

        ItemBill line1 = new ItemBill(product1, 2);
        ItemBill line2 = new ItemBill(product2, 2);

        return Arrays.asList(line1, line2);
    }

    @Primary
    @Bean("itemsBillOffice")
    public List<ItemBill> registerItemOffice() {
        Product product1 = new Product("Screen LG LCD 24", 250);
        Product product2 = new Product("Notebook ASUS", 500);
        Product product3 = new Product("Printer HP", 80);
        Product product4 = new Product("Desk Office", 300);

        ItemBill line1 = new ItemBill(product1, 2);
        ItemBill line2 = new ItemBill(product2, 1);
        ItemBill line3 = new ItemBill(product3, 1);
        ItemBill line4 = new ItemBill(product4, 1);

        return Arrays.asList(line1, line2, line3, line4);
    }

}
