package com.example.bilabonnement.model;

public class City {
    private int cityID;
    private String cityName;
    private int cityZipcode;

    public City(String cityName, int cityZipcode) {
        this.cityName = cityName;
        this.cityZipcode = cityZipcode;
    }

    public int getCityID() {
        return cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public int getCityZipcode() {
        return cityZipcode;
    }
}
