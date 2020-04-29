package com.oar.oarschool.repository;

import com.oar.oarschool.model.AirPlaneSpecs;
import org.springframework.data.repository.CrudRepository;

public interface PlaneSpecsRepository extends CrudRepository<AirPlaneSpecs, Long> {
}
