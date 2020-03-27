package co.com.jdti.springbootdi.app.models.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Component
public class Bill {

    @Value("${bill.description}")
    private String description;

    @Autowired
    private Client client;

    @Autowired
    private List<ItemBill> items;

    @PostConstruct
    public void init() {
        client.setName(client.getName() + " " + client.getSurname());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Bill destroyed");
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<ItemBill> getItems() {
        return items;
    }

    public void setItems(List<ItemBill> items) {
        this.items = items;
    }
}
