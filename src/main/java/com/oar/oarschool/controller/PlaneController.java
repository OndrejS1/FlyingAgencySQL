package com.oar.oarschool.controller;

import com.oar.oarschool.model.Flight;
import com.oar.oarschool.model.AirPlane;
import com.oar.oarschool.service.FlightService;
import com.oar.oarschool.service.PlaneService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/plane")
public class PlaneController {

    private final PlaneService planeService;
    private final FlightService flightService;

    @GetMapping("/available")
    public List<AirPlane> getAllAvailablePlanes(@RequestParam Date fromDate, @RequestParam Date endDate) {

        List<Flight> flights = flightService.getFlightsInTimeLine(fromDate, endDate);

        return flights
                .stream()
                .map(flight -> planeService.findPlaneById(flight.getPlaneId()))
                .collect(Collectors
                        .toCollection(ArrayList::new));
    }

    @GetMapping("/all")
    public List<AirPlane> getAllPlanes() {
        return planeService.getAllPlanes();
    }

    @PostMapping("/add")
    public void addPlane(@RequestBody AirPlane planeResource) {
         planeService.addPlane(planeResource);
    }
}
