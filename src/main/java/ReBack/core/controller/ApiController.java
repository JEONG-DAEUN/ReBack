package ReBack.core.controller;

import ReBack.core.data.ClothingSponsor;
import ReBack.core.repository.ClothingSponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    ClothingSponsorRepository clothingSponsorRepository;

    @PostMapping("/donation/clothingSponsor") //의류 후원
    public String clothingSponsor(@RequestBody ClothingSponsor clothingSponsor){
        clothingSponsorRepository.save(clothingSponsor);

        return "clothingSponsor";
    }
}
