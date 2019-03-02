package pl.edu.wszib.springtalkingwithworld;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@ControllerAdvice
public class MyControllerAdvice {

/*    @ExceptionHandler(HeaderController.Exc1.class)
    public String exc1(){
        return "Wyjątek 1";
    }
    @ExceptionHandler(HeaderController.Exc2.class)
    public String exc2(){
        return "Wyjątek 2";
    }
    @ExceptionHandler(HeaderController.Exc3.class)
    public String exc3(){
        return "Wyjątek 3";
    }*/
}
