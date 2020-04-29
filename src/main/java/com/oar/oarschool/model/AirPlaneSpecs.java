package com.oar.oarschool.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "AirPlaneSpecs")
@Table(name = "air_plane_specs")
public class AirPlaneSpecs implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "air_plane_id", referencedColumnName = "id")
    private AirPlane airPlane;

    private Double cabinLength;
    private Double overallLength;
    private Double range;
    private Double height;
    private Double track;
    private Double wheelBase;

}
