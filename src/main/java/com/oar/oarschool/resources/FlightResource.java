package com.oar.oarschool.resources;

import com.oar.oarschool.model.Flight;
import com.oar.oarschool.model.AirPlane;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FlightResource {

    private Flight flight;
    private AirPlane airPlane;

}
