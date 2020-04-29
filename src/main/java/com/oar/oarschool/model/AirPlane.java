package com.oar.oarschool.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "air_plane")
public class AirPlane implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private Brand brand;

    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade=CascadeType.ALL)
    private AirPlaneEquipment airPlaneEquipment;

    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade=CascadeType.ALL)
    private AirPlaneSpecs airPlaneSpecs;
}
