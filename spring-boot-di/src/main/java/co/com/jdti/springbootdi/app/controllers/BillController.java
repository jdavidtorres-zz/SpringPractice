package co.com.jdti.springbootdi.app.controllers;

import co.com.jdti.springbootdi.app.models.domain.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private Bill bill;

    @GetMapping("/")
    public String watch(Model model) {
        model.addAttribute("bill", bill);
        model.addAttribute("title", "Example with dependencies...");
        return "bill/watch";
    }
}
