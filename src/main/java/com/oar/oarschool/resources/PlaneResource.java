package com.oar.oarschool.resources;

import com.oar.oarschool.model.AirPlane;
import com.oar.oarschool.model.AirPlaneEquipment;
import com.oar.oarschool.model.AirPlaneSpecs;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlaneResource {

    private AirPlane airPlane;
    private AirPlaneEquipment airPlaneEquipment;
    private AirPlaneSpecs airPlaneSpecs;

}
