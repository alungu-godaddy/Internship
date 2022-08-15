package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/hello") // high level mapping
public class HelloWorldController {
    @RequestMapping("/showForm")
    public String showMyForm() {
        return "hello-world-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "process-form";
    }

    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(@RequestParam("studentName") String name,
                                Model model) {
        name = name.toUpperCase();

        model.addAttribute("message", name);

        return "process-form";
    }
}
