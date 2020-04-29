package com.oar.oarschool.service;


import com.oar.oarschool.model.Passenger;
import com.oar.oarschool.repository.PassengerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PassengerService {

    private final PassengerRepository passengerRepository;

    public Passenger getPassenger(Long passengerId) {
        return passengerRepository
                .findById(passengerId)
                .orElseThrow(() -> new RuntimeException("Passenger with this Id doesn't exist"));
    }

    public Passenger addPassenger(Passenger passenger) {
        return passengerRepository
                .save(passenger);
    }

    public Passenger modifyPassenger(Passenger passenger) {
        return passengerRepository
                .save(passenger);
    }

    public void deletePassengerById(Long passengerId) {
        passengerRepository.deleteById(passengerId);
    }

}
