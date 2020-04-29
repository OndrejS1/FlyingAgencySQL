package com.oar.oarschool.service;

import com.oar.oarschool.model.Passenger;
import com.oar.oarschool.model.Ticket;
import com.oar.oarschool.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
@AllArgsConstructor
public class TicketService {

    final private TicketRepository ticketRepository;

    public Ticket getTicketById(Long ticketId) {
        Optional<Ticket> maybeTicket = ticketRepository.findById(ticketId);
        return maybeTicket.orElseThrow(() -> new RuntimeException("Ticket with this ticketId doesn't exist"));
    }

    public Ticket modifyOrAddTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllPassengers(Long flightId) {
        return  StreamSupport
                .stream(ticketRepository
                        .findAllByFlightId(flightId)
                        .spliterator(), false)
                .collect(Collectors.toList());
    }

    public List<Ticket> getAllTicketsByPassengerId(Long passengerId) {

        return StreamSupport
                .stream(ticketRepository
                        .findAllByPassengerId(passengerId)
                        .spliterator(), false)
                .collect(Collectors.toList());
    }

    public void deleteTicketById(Long ticketId) {
        ticketRepository.deleteById(ticketId);
    }

}
