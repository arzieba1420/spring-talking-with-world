package pl.edu.wszib.springtalkingwithworld;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController //RestController ZAWSZE zwraca odpowiedz w body (@ResponseBody)
@RequestMapping("/headers")
public class HeaderController {

    /*@GetMapping
    public ResponseEntity test(@RequestHeader String testHeader){
        return ResponseEntity.ok(testHeader.toUpperCase());
    }*/

   /* @GetMapping
    @ResponseBody
    public String test(@RequestHeader String testHeader){
        return testHeader.toUpperCase();
    }*/

   /* @GetMapping  // ->ViewResolverConfig
    public String test(){
        return "index";
    }*/

   /* @GetMapping  // ->ViewResolverConfig
    public String test(){

         throw new RuntimeException();
    }

    @ExceptionHandler(RuntimeException.class)
    public String exceptionTest(){
        return "Runtime exception occured";
    }*/

   @ResponseStatus(HttpStatus.BAD_REQUEST)
   public  static class Exc1 extends RuntimeException{

   }
   @ResponseStatus(HttpStatus.OK)
    public static class Exc2 extends RuntimeException{

    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
     public static class Exc3 extends RuntimeException{

    }
   @GetMapping
    public void randomExc(){
       String test = String.valueOf(new Random().nextInt(3));
       if(test.equals("0")) throw new Exc1();
       if(test.equals("1")) throw new Exc2();
       if(test.equals("2")) throw new Exc3();
   }

   /*@ExceptionHandler(Exc1.class)
   public String exc1(){
       return "Wyjątek 1";
   }
    @ExceptionHandler(Exc2.class)
    public String exc2(){
        return "Wyjątek 2";
    }
    @ExceptionHandler(Exc3.class)
    public String exc3(){
        return "Wyjątek 3";
    }*/
}

