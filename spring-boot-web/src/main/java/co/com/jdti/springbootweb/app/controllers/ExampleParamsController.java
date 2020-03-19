package co.com.jdti.springbootweb.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/param")
public class ExampleParamsController {

    @GetMapping("/string")
    public String param(@RequestParam String text, Model model) {
        return "params/see";
    }
}
