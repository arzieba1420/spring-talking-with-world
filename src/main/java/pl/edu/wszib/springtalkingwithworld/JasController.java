package pl.edu.wszib.springtalkingwithworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

@RestController
@RequestMapping("/jas")
public class JasController {

    private static Logger logger = LoggerFactory.getLogger(JasController.class);


    @Autowired
    Ciastko ciastko;
    @GetMapping
    public String zjedz(){
        if(ciastko.isZjedzone()){
            logger.warn("Zjedzone");
        } else {
            logger.warn("Nie zjedzone");
            ciastko.zjedz();
        }
        return "";
    }
}
