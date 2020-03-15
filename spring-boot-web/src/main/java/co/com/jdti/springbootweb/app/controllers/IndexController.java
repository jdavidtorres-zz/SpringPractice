package co.com.jdti.springbootweb.app.controllers;

import co.com.jdti.springbootweb.app.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class IndexController {

    @GetMapping({"/index", "/", "", "/home"})
    public String index(Model model) {
        model.addAttribute("title", "Hello World");
        return "index";
    }

    @GetMapping("/profile")
    public String getProfile(Model model) {
        User user = new User();
        user.setName("fulanito");
        user.setSurname("de tal");
        user.setEmail("fulano@mail.com");
        model.addAttribute("user", user);
        model.addAttribute("title", "Welcome!!");
        model.addAttribute("subTitle", "Welcome " + user.getName());
        return "profile";
    }
}
