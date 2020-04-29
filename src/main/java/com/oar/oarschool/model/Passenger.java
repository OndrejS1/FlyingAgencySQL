package com.oar.oarschool.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Passenger implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long passengerId;

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.ORDINAL)
    private Nationality nationality;

    @DateTimeFormat
    private Date dateOfBirth;
    private String email;
    private String phone;
}
