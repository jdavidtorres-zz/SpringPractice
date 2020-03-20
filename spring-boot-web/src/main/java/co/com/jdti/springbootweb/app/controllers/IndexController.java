package co.com.jdti.springbootweb.app.controllers;

import co.com.jdti.springbootweb.app.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController {

    private static final String TITLE_CONSTANT = "title";

    @Value("${text.index-controller.index.title}")
    private String indexText;

    @Value("${text.index-controller.profile.title}")
    private String profileText;

    @Value("${text.index-controller.list.title}")
    private String listText;

    @GetMapping({"/index", "/", "", "/home"})
    public String index(Model model) {
        model.addAttribute(TITLE_CONSTANT, indexText);
        return "index";
    }

    @GetMapping("/profile")
    public String getProfile(Model model) {
        User user = new User();
        user.setName("fulanito");
        user.setSurname("de tal");
        user.setEmail("fulano@mail.com");
        model.addAttribute("user", user);
        model.addAttribute(TITLE_CONSTANT, "Welcome!!");
        return "profile";
    }

    @GetMapping("/list")
    public String toList(Model model) {
        model.addAttribute(TITLE_CONSTANT, listText);
        return "list";
    }

    @ModelAttribute("users")
    public List<User> populateList() {
        List<User> users = new ArrayList<>();
        users.add(new User("Fulano", "De tal", "fulano@mail.com"));
        users.add(new User("Sutano", "Perez", "sutano@mail.com"));
        users.add(new User("Mengano", "Patolo", "mengano@mail.com"));
        users.add(new User("Tornado", "Roe", "tornado@mail.com"));
        users.add(new User("John", "Doe", "doe@mail.com"));
        return users;
    }
}
