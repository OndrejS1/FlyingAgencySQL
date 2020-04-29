package com.oar.oarschool.controller;

import com.oar.oarschool.model.Flight;
import com.oar.oarschool.model.Passenger;
import com.oar.oarschool.resources.FlightResource;
import com.oar.oarschool.service.FlightService;
import com.oar.oarschool.service.PassengerService;
import com.oar.oarschool.service.PlaneService;
import com.oar.oarschool.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/flight")
public class FlightController {

    private final TicketService ticketService;
    private final PassengerService passengerService;
    private final FlightService flightService;
    private final PlaneService planeService;

    @GetMapping("/getAllPassengersOnFlight")
    public List<Passenger> getAllPassengers(@RequestParam("flightId") Long flightId) {

        return ticketService
                .getAllPassengers(flightId)
                .stream()
                .map(ticket -> passengerService.getPassenger(ticket.getPassengerId()))
                .collect(Collectors
                        .toCollection(ArrayList::new));

    }

    @GetMapping("/getAllFlights")
    public List<Flight> getAllFlights() {
        /*return flightService.getAllFlights()
                .stream()
                .map(flight -> new FlightResource(flight, planeService.findPlaneById(flight.getPlaneId())))
                .collect(Collectors.toList());*/

        return flightService.getAllFlights();
    }

    @PostMapping("/addFlight")
    public Flight addFlight(@RequestBody Flight flight) {
        return flightService.addFlight(flight);
    }

    @DeleteMapping("/deleteFlightById")
    public void deleteFlightById(@RequestParam Long flightId) {
        flightService.deleteFlightById(flightId);
    }
}
