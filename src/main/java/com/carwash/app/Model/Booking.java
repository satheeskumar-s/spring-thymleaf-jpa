package com.carwash.app.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Integer user_id;
    private Integer vehicle_type;
    private Float price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(Integer vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
