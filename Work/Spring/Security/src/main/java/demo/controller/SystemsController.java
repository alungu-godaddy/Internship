package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SystemsController {

    @GetMapping("/systems")
    public String showSystems() {
        return "systems";
    }
}
