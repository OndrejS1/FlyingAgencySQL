package com.oar.oarschool.repository;

import com.oar.oarschool.model.AirPlane;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends CrudRepository<AirPlane, Long> {

   //  Iterable<Plane> findAllByStartDateLessThanEqualAndEndDateGreaterThanEqual(Date startDate, Date endDate);

}
