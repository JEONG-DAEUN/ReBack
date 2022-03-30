package ReBack.core.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/denied")
    public String denied() {
        return "denied";
    }


    @GetMapping("/singUp")
    public String singUp() {

        return "singUp";
    }
}
