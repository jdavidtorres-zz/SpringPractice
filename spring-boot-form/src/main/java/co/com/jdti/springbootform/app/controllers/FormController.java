package co.com.jdti.springbootform.app.controllers;

import co.com.jdti.springbootform.app.models.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@SessionAttributes("user")
public class FormController {

    @GetMapping("/form")
    public String form(Model model) {
        User user = new User();
        user.setId("12345-K");
        user.setName("Juan");
        user.setLastName("Doe");
        model.addAttribute("title", "Form");
        model.addAttribute("user", user);
        return "form";
    }

    @PostMapping("/form")
    public String sendForm(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("title", "Form");
            return "form";
        }
        model.addAttribute("title", "Result");
        model.addAttribute("user", user);
        status.setComplete();
        return "result";
    }
}
