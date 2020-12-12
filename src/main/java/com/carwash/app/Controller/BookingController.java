package com.carwash.app.Controller;

import com.carwash.app.Model.Booking;
import com.carwash.app.Model.User;
import com.carwash.app.Model.VehicleType;
import com.carwash.app.Repository.BookingRepository;
import com.carwash.app.Repository.UserRepository;
import com.carwash.app.Repository.VehicleRepository;
import com.carwash.app.Request.BookingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class BookingController {
    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookingRepository bookingRepository;

    @RequestMapping("booking")
    public String index(Model model) {
        Iterable<VehicleType> vehicleTypes = vehicleRepository.findAll();
        model.addAttribute("vehicleTypes", vehicleTypes);
        return "booking";
    }

    @RequestMapping(value = "post-booking", method = RequestMethod.POST)
    public String postBooking(@ModelAttribute BookingRequest bookingRequest, Model model) {
        User user = userRepository.findByPhone(bookingRequest.getPhone());
        VehicleType vehicleType = vehicleRepository.findById(bookingRequest.getVehicle_type())
                .orElse(null);

        Integer redeem = 0;
        Integer userId = 0;
        if (vehicleType != null) {
            if(user != null) {
                userId = user.getId();
                redeem = (int) (vehicleType.getPrice() * 50);
                user.setRedeem_point(redeem + user.getRedeem_point());
                userRepository.save(user);
            } else {
                User userNew = new User();
                userNew.setName("New user");
                userNew.setPhone(bookingRequest.getPhone());
                userRepository.save(userNew);
                userId = userNew.getId();
            }
        }

        Booking booking = new Booking();
        booking.setUser_id(userId);
        booking.setVehicle_type(vehicleType.getId());
        booking.setPrice(vehicleType.getPrice());
        bookingRepository.save(booking);

        model.addAttribute("redeem", redeem);
        return "redeem";
    }

    @RequestMapping("finish")
    public String finish() {
        return "finish";
    }
}
