package pl.edu.wszib.springtalkingwithworld;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class CalcTester {

    @GetMapping("/average")
    public ResponseEntity average(@RequestParam("nums") double[] nums ){

        return ResponseEntity.ok(Arrays.stream(nums).average());
    }

    @GetMapping("/sum")
    public ResponseEntity sum(@RequestParam("nums") double[] nums ){

        return ResponseEntity.ok(Arrays.stream(nums).sum());
    }

    @GetMapping("/product")
    public ResponseEntity product(@RequestParam("nums") double[] nums ){

        double temp =1;
        for (int i = 0; i <nums.length ; i++) {
            temp*=nums[i];
        }
       return ResponseEntity.ok(temp);
    }

    @GetMapping("/difference")
    public ResponseEntity difference(@RequestParam("nums") double[] nums ){

        double difference = nums[0];

        for (int i = 1; i <nums.length ; i++) {
            difference += nums[i]*(-1);
        }
        return ResponseEntity.ok(difference);
    }


}
