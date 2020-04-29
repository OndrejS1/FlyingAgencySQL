package com.oar.oarschool.controller;


import com.oar.oarschool.model.Passenger;
import com.oar.oarschool.model.Ticket;
import com.oar.oarschool.service.PassengerService;
import com.oar.oarschool.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService ticketService;
    private final PassengerService passengerService;


    @PostMapping("/addTicket")
    public Ticket addTicket(@RequestBody Ticket ticket) {
        return ticketService.modifyOrAddTicket(ticket);
    }

    @PutMapping("/modifyTicket")
    public Ticket modifyTicket(@RequestBody Ticket ticket) {
        return ticketService.modifyOrAddTicket(ticket);
    }

    @DeleteMapping("/deleteTicketById")
    public void modifyTicket(@RequestParam Long ticketId) {
         ticketService.deleteTicketById(ticketId);
    }

    @GetMapping("/findTicketById")
    public Ticket getTicketById(@RequestParam Long ticketId) {
         return ticketService.getTicketById(ticketId);
    }

    @GetMapping("/getAllTicketsByPassengerId")
    public List<Ticket> getAllTicketsByPassengerId(@RequestParam("passengerId") Long passengerId) {
        return ticketService.getAllTicketsByPassengerId(passengerId);
    }
}
