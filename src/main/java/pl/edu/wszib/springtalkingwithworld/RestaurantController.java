package pl.edu.wszib.springtalkingwithworld;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.wszib.springtalkingwithworld.model.Customer;
import pl.edu.wszib.springtalkingwithworld.model.Restaurant;

// /restaurant/cost?imie=Adam&imie_osoby_tow=Test&imie_zwierz=asdfas&imie_dziecka=sdf

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

    @GetMapping("/cost")
    public ResponseEntity cost(@RequestParam String name,
                               @RequestParam(required = false) String partnerName,
                               @RequestParam(required = false) String childName,
                               @RequestParam(required =false) String petName){



        Customer customer = new Customer(name,isNotNull(partnerName),isNotNull(childName),isNotNull(petName));
        double result = Restaurant.visitCost(customer);

        return ResponseEntity.ok(Restaurant.visitCost(customer));
    }




    public boolean isNotNull(String string){
        return string!=null;
    }
}


