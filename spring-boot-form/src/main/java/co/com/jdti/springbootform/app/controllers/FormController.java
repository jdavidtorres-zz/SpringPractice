package co.com.jdti.springbootform.app.controllers;

import co.com.jdti.springbootform.app.models.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class FormController {

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("title", "Form");
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/form")
    public String sendForm(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(err -> errors.put(err.getField(), "Error in " + err.getField() + " " + err.getDefaultMessage()));
            model.addAttribute("error", errors);
            return "form";
        }
        model.addAttribute("title", "Result!!");
        model.addAttribute("user", user);
        return "result";
    }
}
