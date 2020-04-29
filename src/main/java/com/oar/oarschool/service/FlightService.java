package com.oar.oarschool.service;


import com.oar.oarschool.model.Flight;
import com.oar.oarschool.model.Passenger;
import com.oar.oarschool.repository.FlightRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;

    public List<Flight> getFlightsInTimeLine(Date startDate, Date endDate) {

        return StreamSupport
                .stream(flightRepository
                        .findAllByDepartureTimeLessThanEqualAndLandingTimeGreaterThanEqual(startDate, endDate)
                        .spliterator(), false)
                .collect(Collectors.toList());
    }

    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public void deleteFlightById(Long flightId) {
         flightRepository.deleteById(flightId);
    }

    public List<Flight> getAllFlights() {
        return StreamSupport
                .stream(flightRepository
                        .findAll()
                        .spliterator(), false)
                .collect(Collectors.toList());
    }
}
