package com.oar.oarschool.controller;

import com.oar.oarschool.model.Passenger;
import com.oar.oarschool.service.PassengerService;
import com.oar.oarschool.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/passenger")
public class PassengerController {

    private final TicketService ticketService;
    private final PassengerService passengerService;

    @PostMapping("/addPassenger")
    public Passenger addPassenger(@RequestBody Passenger passenger) {
        return passengerService.addPassenger(passenger);
    }

    @PutMapping("/modifyPassenger")
    public Passenger modifyTicket(@RequestBody Passenger passenger) {
        return passengerService.modifyPassenger(passenger);
    }

    @DeleteMapping("/deletePassengerById")
    public void deletePassengerById(@RequestParam Long passengerId) {
        passengerService.deletePassengerById(passengerId);
    }

    @GetMapping("/getPassengerById")
    public Passenger getPassengerById(@RequestParam Long passengerId) {
        return passengerService.getPassenger(passengerId);
    }
}
