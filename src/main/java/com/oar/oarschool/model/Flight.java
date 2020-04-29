package com.oar.oarschool.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@Data
@Entity
public class Flight implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long flightId;

    private Long planeId;

    @DateTimeFormat
    private Date boardingTime;

    @DateTimeFormat
    private Date landingTime;

    @DateTimeFormat
    private Date departureTime;
    private int delay;
    private String gate;

}
