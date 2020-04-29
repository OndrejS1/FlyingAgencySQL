package com.oar.oarschool.repository;

import com.oar.oarschool.model.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {

    Iterable<Flight> findAllByDepartureTimeLessThanEqualAndLandingTimeGreaterThanEqual(Date departureTime, Date landingTime);
}
