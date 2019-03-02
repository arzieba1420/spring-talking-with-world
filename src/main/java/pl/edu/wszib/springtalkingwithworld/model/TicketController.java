package pl.edu.wszib.springtalkingwithworld.model;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


@Controller
@RequestMapping("/tickets")
public class TicketController {

    private Map<String,Ticket> tickets = new HashMap<>();


    @GetMapping("/{id}")
    public ResponseEntity<TicketDTO> getTicket(@PathVariable String id){
        Ticket temp =tickets.get(id);
        return ResponseEntity.ok(convert(temp));
    }

    @PostMapping
    public ResponseEntity addTicket(@RequestBody TicketDTO ticket){
        String id = String.valueOf( new Random().nextInt());
        tickets.put(id, convert(ticket));
        return ResponseEntity.ok(id);
    }

    private TicketDTO convert(Ticket ticket){
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.date = ticket.date;
        ticketDTO.person = convert(ticket.person);
        return ticketDTO;
    }

    private PersonDTO convert(Person person){
        PersonDTO personDTO = new PersonDTO();
        personDTO.name = person.name;
        personDTO.age = person.age;
        return personDTO;
    }

    private Ticket convert(TicketDTO ticketDTO){
        Ticket ticket = new Ticket();
        ticket.date = ticketDTO.date;
        ticket.person = convert(ticketDTO.person);
        return ticket;
    }

    private Person convert(PersonDTO personDTO){
        Person person = new Person();
        person.name = personDTO.name;
        person.age = personDTO.age;
        return person;
    }

}
