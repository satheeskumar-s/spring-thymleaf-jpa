package com.carwash.app.Repository;

import com.carwash.app.Model.Booking;
import com.carwash.app.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer> {
}
