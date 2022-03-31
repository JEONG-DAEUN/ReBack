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

    @GetMapping("/fitedu")
    public String fitedu() {return "fitedu";}

    @GetMapping("/shareedu")
    public String shareedu() {return "shareedu";}
}
