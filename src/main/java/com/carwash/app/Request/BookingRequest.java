package com.carwash.app.Request;

public class BookingRequest {
    private String location;
    private Integer vehicle_type;
    private Integer wash_type;
    private Integer phone;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(Integer vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public Integer getWash_type() {
        return wash_type;
    }

    public void setWash_type(Integer wash_type) {
        this.wash_type = wash_type;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }
}
