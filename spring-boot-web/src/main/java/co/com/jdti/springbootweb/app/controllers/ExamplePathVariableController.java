package co.com.jdti.springbootweb.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class ExamplePathVariableController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Receive params from PathVariable");
        return "variables/index";
    }

    @GetMapping("/string/{text}")
    public String variable(@PathVariable String text, Model model) {
        model.addAttribute("title", "Receive params from PathVariable --> " + text);
        return "variables/see";
    }

    @GetMapping("/string/{text}/{number}")
    public String variable(@PathVariable String text, @PathVariable int number, Model model) {
        model.addAttribute("title", "Receive params from PathVariable --> '" + text + "' and the number is: '" + number + "'");
        return "variables/see";
    }
}
