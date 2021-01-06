package th.ac.ku.atm.controller;

import jdk.jfr.ContentType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String getHomepage(Model model) {
        model.addAttribute("greeting","Sawaddee");
        return "home";    // home template (home.html)

    }
}
