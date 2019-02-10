package pl.edu.wszib.springtalkingwithworld;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/User")
public class UserController {


    List<String> personalDatas = new ArrayList<String>();

    @GetMapping("/istnieje/{imie}/{nazwisko}")
    public ResponseEntity exist(@PathVariable() String imie, @PathVariable String nazwisko){
        String personalData = imie + " "+nazwisko;


            if(personalDatas.contains(personalData)){
                return new ResponseEntity(HttpStatus.OK);

        }else return new ResponseEntity(HttpStatus.NOT_FOUND);

    };

    @PostMapping("/zapisz/{imie}/{nazwisko}")
    public ResponseEntity write(@PathVariable() String imie, @PathVariable String nazwisko ){
        String personalData = imie+" "+nazwisko;



        if(personalDatas.contains(personalData))
            return new ResponseEntity(HttpStatus.ALREADY_REPORTED) ;
        else {
            personalDatas.add(personalData);
            return new ResponseEntity(HttpStatus.OK);
        }




    }

}
