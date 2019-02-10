package pl.edu.wszib.springtalkingwithworld;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
@RequestMapping("/parameterTest")
public class RequestParamController {

    @GetMapping
    public ResponseEntity get(@RequestParam("pierwsza") int num1,
                              @RequestParam("druga") int num2,
                              @RequestParam(value ="trzecia", required = false) Integer num3){
        return ResponseEntity.ok(num1 + num2);
    }

    @GetMapping("/get2")
    public ResponseEntity get2(@RequestParam("nums") int[] nums ){
        return ResponseEntity.ok(Arrays.stream(nums).count());
    }



}
