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

        return "writer";
    }

    @GetMapping("/pono")
    public String pono() {
        return "pono";
    }

    @GetMapping("/tjsxpr")
    public String tjsxpr() {

        return "tjsxpr";
    }

    @GetMapping("/mrmberhoewongaib")
    public String mrmberhoewongaib() {

        return "mrmberhoewongaib";
    }
    @GetMapping("/writer")
    public String writer() {

        return "writer";
    }

    @GetMapping("/company")
    public String company() {

        return "company";
    }


}
