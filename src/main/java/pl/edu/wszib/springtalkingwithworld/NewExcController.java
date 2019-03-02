package pl.edu.wszib.springtalkingwithworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/new")
public class NewExcController {

    @GetMapping
    public String exc(){
        throw new HeaderController.Exc2();
    }

}
