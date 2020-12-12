package com.carwash.app.Repository;

import com.carwash.app.Model.VehicleType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends CrudRepository<VehicleType, Integer> {
}
