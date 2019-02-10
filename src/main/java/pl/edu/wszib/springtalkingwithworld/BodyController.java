package pl.edu.wszib.springtalkingwithworld;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.wszib.springtalkingwithworld.model.Customer;
import pl.edu.wszib.springtalkingwithworld.model.Restaurant;

@Controller
@RequestMapping("/body")
public class BodyController {


    /*@PostMapping
    public ResponseEntity post(@RequestBody new Customer("test",true,true,true)){
        return ResponseEntity.ok(Restaurant.visitCost(customer));
    }*/
}
