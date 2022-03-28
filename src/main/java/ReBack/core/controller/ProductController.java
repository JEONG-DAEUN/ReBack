package ReBack.core.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class ProductController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
