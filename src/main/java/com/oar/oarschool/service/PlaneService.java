package com.oar.oarschool.service;

import com.oar.oarschool.model.AirPlane;
import com.oar.oarschool.model.AirPlaneEquipment;
import com.oar.oarschool.model.AirPlaneSpecs;
import com.oar.oarschool.repository.PlaneEquipmentRepository;
import com.oar.oarschool.repository.PlaneRepository;
import com.oar.oarschool.repository.PlaneSpecsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
@AllArgsConstructor
public class PlaneService {

    private final PlaneRepository planeRepository;
    private final PlaneSpecsRepository planeSpecsRepository;
    private final PlaneEquipmentRepository planeEquipmentRepository;

    public AirPlane findPlaneById(Long planeId) {
        return planeRepository
                .findById(planeId)
                .orElseThrow(() -> new RuntimeException("Plane doesn't exist"));
    }

    public void addPlane(AirPlane airPlane) {

        AirPlaneEquipment equipment = airPlane.getAirPlaneEquipment();
        equipment.setAirPlane(airPlane);
        planeEquipmentRepository.save(equipment);

        AirPlaneSpecs specs = airPlane.getAirPlaneSpecs();
        specs.setAirPlane(airPlane);
        planeSpecsRepository.save(specs);
    }

    public List<AirPlane> getAllPlanes() {

        return StreamSupport
                .stream(planeRepository
                        .findAll()
                        .spliterator(), false)
                .collect(Collectors.toList());
    }
}
