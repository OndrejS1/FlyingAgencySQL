package com.oar.oarschool.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long ticketId;


    private Long flightId;


    private Long passengerId;

    private int cost;
    private String seat;

}
