package com.guy.class23a_and_6;

import java.util.ArrayList;
import java.util.HashMap;

public class Garage {

    private String address = "";
    private HashMap<String, Car> cars = new HashMap<>();

    public Garage() {
    }

    public String getAddress() {
        return address;
    }

    public Garage setAddress(String address) {
        this.address = address;
        return this;
    }

    public HashMap<String, Car> getCars() {
        return cars;
    }

    public Garage setCars(HashMap<String, Car> cars) {
        this.cars = cars;
        return this;
    }
}
