package co.com.jdti.springbootweb.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/param")
public class ExampleParamsController {

    @GetMapping("/")
    public String sendParam() {
        return "params/index";
    }

    @GetMapping("/string")
    public String param(@RequestParam(required = false, defaultValue = "empty") String text, Model model) {
        model.addAttribute("result", "The text sent is: " + text);
        return "params/see";
    }

    @GetMapping("/mix-param")
    public String param(@RequestParam(required = false, defaultValue = "empty") String text, @RequestParam int num, Model model) {
        model.addAttribute("result", "The text sent is: '" + text + "' and the number is: '" + num + "'");
        return "params/see";
    }
}
