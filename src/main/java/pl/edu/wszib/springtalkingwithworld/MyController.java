package pl.edu.wszib.springtalkingwithworld;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/myCon")
public class MyController {

    //localhost/moj
    @GetMapping //skrócony zapis adnotacji RequesdtMapping z metodą HTTP get()
    public ResponseEntity get(){
        ResponseEntity entity= new ResponseEntity("Hello World", HttpStatus.OK);
        return entity;
    }
    //localhost/moj/json
    @RequestMapping(value = "/json", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getJson(){
        String json = "{\n" +
                "  \"imie\" : \"Adam\",\n" +
                "  \"szkola\" : {\n" +
                "    \"nazwa\" : \"SP nr 11\",\n" +
                "    \"adres\" : \"Test\"\n" +
                "  },\n" +
                "  \"oceny\" : [5,5,2]  \n" +
                "  \n" +
                "}";
        //MimeType.valueOf("application/json");
        ResponseEntity entity= new ResponseEntity(json, HttpStatus.OK);
        return entity;
    }



}
