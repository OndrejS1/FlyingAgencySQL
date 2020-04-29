package com.oar.oarschool.repository;


import com.oar.oarschool.model.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {

    Iterable<Ticket> findAllByFlightId(Long flightId);

    Iterable<Ticket> findAllByPassengerId(Long passengerId);

}
