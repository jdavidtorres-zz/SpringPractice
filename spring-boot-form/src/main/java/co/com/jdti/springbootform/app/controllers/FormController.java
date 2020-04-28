package co.com.jdti.springbootform.app.controllers;

import co.com.jdti.springbootform.app.models.domain.User;
import co.com.jdti.springbootform.app.validations.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@SessionAttributes("user")
public class FormController {

    static final String FORM_TITLE = "title";

    @Autowired
    private UserValidation validator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(validator);
    }

    @GetMapping("/form")
    public String form(Model model) {
        User user = new User();
        user.setId("12345-K");
        user.setName("Juan");
        user.setLastName("Doe");
        model.addAttribute(FORM_TITLE, "Form");
        model.addAttribute("user", user);
        return "form";
    }

    @PostMapping("/form")
    public String sendForm(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute(FORM_TITLE, "Form");
            return "form";
        }
        model.addAttribute(FORM_TITLE, "Result");
        model.addAttribute("user", user);
        status.setComplete();
        return "result";
    }
}
