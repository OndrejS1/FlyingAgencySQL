package com.oar.oarschool.model;

import com.oar.oarschool.resources.PlaneResource;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class AirPlaneEquipment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "air_plane_id", referencedColumnName = "id")
    private AirPlane airPlane;

    private int economySeatNumber;
    private int businessSeatNumber;
    private int amountOfExits;
    private int amountOfBars;



}
