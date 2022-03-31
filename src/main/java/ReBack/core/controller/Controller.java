package ReBack.core.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/education")
    public String education() {return "education";}

    @GetMapping("/share")
    public String share() {return"share";}

    @GetMapping("/userlist")
    public String userlist() {return"userlist";}
}
