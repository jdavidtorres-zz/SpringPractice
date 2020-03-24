package co.com.jdti.springbootdi.app.controllers;

import co.com.jdti.springbootdi.app.models.services.IServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private IServices service;

    @GetMapping({"/index", "", "/"})
    public String index(Model model) {
        model.addAttribute("object", service.operation());
        return "index";
    }

}
