package com.carwash.app.Controller;

import com.carwash.app.Model.VehicleType;
import com.carwash.app.Repository.VehicleRepository;
import com.carwash.app.Request.VehicleTypeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VehicleController {
    @Autowired
    VehicleRepository vehicleRepository;

    @RequestMapping("vehicle-type")
    public String index(Model model) {
        Iterable<VehicleType> vehicleTypes = vehicleRepository.findAll();
        model.addAttribute("vehicleTypes", vehicleTypes);
        return "vehicle_type";
    }

    @RequestMapping("vehicle-type/add")
    public String viewAdd() {
        return "vehicle_type_add";
    }

    @RequestMapping(value = "vehicle-type/add", method = RequestMethod.POST)
    public ModelAndView postAdd(@ModelAttribute VehicleTypeRequest vehicleTypeRequest) {
        VehicleType vehicleType = new VehicleType();
        vehicleType.setName(vehicleTypeRequest.getVehicle_type());
        vehicleType.setPrice(vehicleTypeRequest.getPrice());

        vehicleRepository.save(vehicleType);
        return new ModelAndView("redirect:/vehicle-type");
    }

    @RequestMapping("vehicle-type/edit/{id}")
    public String edit(@PathVariable(value = "id") Integer id, Model model) {
        VehicleType vehicleType = vehicleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("vehicleType", vehicleType);
        return "vehicle_type_edit";
    }

    @RequestMapping(value = "vehicle-type/edit/{id}", method = RequestMethod.POST)
    public ModelAndView postEdit(@ModelAttribute VehicleTypeRequest vehicleTypeRequest, @PathVariable(value = "id") Integer id) {
        VehicleType vehicleType = new VehicleType();
        vehicleType.setId(id);
        vehicleType.setName(vehicleTypeRequest.getVehicle_type());
        vehicleType.setPrice(vehicleTypeRequest.getPrice());

        vehicleRepository.save(vehicleType);
        return new ModelAndView("redirect:/vehicle-type");
    }
}
