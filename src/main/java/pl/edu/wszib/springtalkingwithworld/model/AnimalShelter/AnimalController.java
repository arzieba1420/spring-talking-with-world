package pl.edu.wszib.springtalkingwithworld.model.AnimalShelter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Stream;

@Controller
@RequestMapping("/shelter")
public class AnimalController {

    private Map<String,Animal> animals = new HashMap<>();
    private Map<String,String> reservations = new HashMap<>();  //key-reservation code value-animal ID

    /*@PostMapping("/give")
    public ResponseEntity giveAnimalToShelter(@RequestParam("animalName") String name,
                                              @RequestParam("animalAge") int age,
                                              @RequestParam("animalType") AnimalType animalType,
                                              @RequestParam("animalGender") AnimalGender animalGender){

        String id = String.valueOf( new Random().nextInt());
        Animal animal = new Animal();
        animal.name = name;
        animal.age = age;
        animal.animalGender=animalGender;
        animal.animalType=animalType;

        animals.put(id,animal);


        return new ResponseEntity(id,HttpStatus.OK);
    }*/

    @PostMapping("/add")
    public ResponseEntity addAnimalToShelter(@RequestBody AnimalDTO animalDTO){
        String id = String.valueOf( new Random().nextInt());

        animals.put(id,convert(animalDTO,id));
        return new ResponseEntity(id,HttpStatus.OK);
    }



    @GetMapping("/getDetails}")
    public ResponseEntity getAnimalById(@RequestParam("animalID") String id){

        if (animals.containsKey(id)) {
            return new ResponseEntity(animals.get(id).toString(),HttpStatus.OK);

        }
        return new ResponseEntity("Animal Not Found",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAllAnimals")
    public ResponseEntity getAllAnimals(){

        List<Animal> list = new ArrayList<Animal>(animals.values());

        String response ="";
        for (int i=0; i<list.size();i++){
            response= response+ "name: "+list.get(i).name+ " id: "+ list.get(i).id+"\n";
        }

        System.out.println(response);

        return new ResponseEntity(response,HttpStatus.OK);
    }

    @DeleteMapping("/adoptAnimal")
    public ResponseEntity adoptAnimalById(@RequestParam("Animal ID") String id, @RequestParam(value = "ResCode", required = false) String resCode ){

        if(animals.containsKey(id) && animals.get(id).isReserved==false ) {
            animals.remove(id);
            return new ResponseEntity("Animal has been adopted", HttpStatus.OK);
        }

        else if( animals.containsKey(id) && animals.get(id).isReserved==true && resCode==null)
        return  new ResponseEntity("Animal reserved. Please enter your resCode", HttpStatus.BAD_REQUEST);

        else if(animals.containsKey(id) && animals.get(id).isReserved==true && !reservations.containsKey(resCode)){

            return new ResponseEntity("Invalid resCode",HttpStatus.BAD_REQUEST);

        }



        else if(animals.containsKey(id) && animals.get(id).isReserved==true && reservations.get(resCode)==id){

            removeReservationByResCode(resCode);
            animals.remove(id);
            return new ResponseEntity("Animal has been adopted by resCode",HttpStatus.OK);

        }




        return new ResponseEntity("Animal Not Found",HttpStatus.NOT_FOUND);


    };

    @PostMapping("/reserveAnimal")
    public ResponseEntity reserveAnimalById(@RequestParam("Animal ID") String id){
        if(animals.containsKey(id)){
            String reservationCode = String.valueOf( new Random().nextInt());
            animals.get(id).isReserved = true;
            reservations.put(reservationCode,id);

            return new ResponseEntity("Reservation done! Res code: "+reservationCode,HttpStatus.OK);
        }
        return new ResponseEntity("Animal Not Found",HttpStatus.NOT_FOUND);

    }

    @PutMapping("/removeReservation")
    public ResponseEntity removeReservationByResCode(@RequestParam("Res Code") String resCode){
        if(reservations.containsKey(resCode)){
            animals.get(reservations.get(resCode)).isReserved=false;
            reservations.remove(resCode);
            return new ResponseEntity("Reservation has been removed",HttpStatus.OK);
        }
        return new ResponseEntity("Reservation Not Found",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAllReservations")
    public ResponseEntity getAllReservations(){

        List<String> resCodes = new ArrayList<String>(reservations.keySet());
        List<String> resValues = new ArrayList<String>(reservations.values());

        String response="";

        for (int i=0; i<resCodes.size();i++){
            response=response+" resCode:"+ resCodes.get(i)+" animalID: "+ reservations.get(resCodes.get(i)) +" animalName: "
            + animals.get(reservations.get(resCodes.get(i))).name+"\n";


        }

        return new ResponseEntity(response,HttpStatus.OK);
    }



    public AnimalDTO convert (Animal animal){
        AnimalDTO animalDTO = new AnimalDTO();
        animalDTO.name=animal.name;
        animalDTO.age=animal.age;
        animalDTO.animalGender=animal.animalGender;
        animalDTO.animalType=animal.animalType;
        return animalDTO;
    }

    public Animal convert (AnimalDTO animalDTO, String id){
        Animal animal = new Animal();
        animal.name = animalDTO.name;
        animal.animalType=animalDTO.animalType;
        animal.animalGender=animalDTO.animalGender;
        animal.age=animalDTO.age;
        animal.id = id;
        return animal;
    }

}
