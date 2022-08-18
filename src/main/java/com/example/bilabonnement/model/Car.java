package com.example.bilabonnement.model;

public class Car {

    private int carID;
    private String carName;
    private String carBrand;
    private String carColour;
    private int carVintage;
    private double rentPrice;
    private String damage;
    private double damagePrice;

    public Car(int carID, String carName, String carBrand, String carColour, int carVintage, String damage, double damagePrice, double rentPrice) {
        this.carID = carID;
        this.carName = carName;
        this.carBrand = carBrand;
        this.carColour = carColour;
        this.carVintage = carVintage;
        this.damage = damage;
        this.damagePrice = damagePrice;
        this.rentPrice = rentPrice;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarColour() {
        return carColour;
    }

    public void setCarColour(String carColour) {
        this.carColour = carColour;
    }

    public int getCarVintage() {
        return carVintage;
    }

    public void setCarVintage(int carVintage) {
        this.carVintage = carVintage;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public double getDamagePrice() {
        return damagePrice;
    }

    public void setDamagePrice(double damagePrice) {
        this.damagePrice = damagePrice;
    }
}
