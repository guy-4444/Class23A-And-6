package com.guy.class23a_and_6;

public class Car {

    public enum TYPE {
        NA,
        GAS,
        HYBRID,
        ELECTRIC,
        HYDROGEN
    }

    public String license;
    public String model = "";
    public int km = 0;
    public long price = 0;
    public double kml = 0.0;
    public boolean fourWD = false;
    public TYPE type = TYPE.NA;

    public Car() {}

    public Car(String license) {
        this.license = license;
    }

    public String getLicense() {
        return license;
    }


    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public int getKm() {
        return km;
    }

    public Car setKm(int km) {
        this.km = km;
        return this;
    }

    public long getPrice() {
        return price;
    }

    public Car setPrice(long price) {
        this.price = price;
        return this;
    }

    public double getKml() {
        return kml;
    }

    public Car setKml(double kml) {
        this.kml = kml;
        return this;
    }

    public boolean isFourWD() {
        return fourWD;
    }

    public Car setFourWD(boolean fourWD) {
        this.fourWD = fourWD;
        return this;
    }

    public TYPE getType() {
        return type;
    }

    public Car setType(TYPE type) {
        this.type = type;
        return this;
    }
}
