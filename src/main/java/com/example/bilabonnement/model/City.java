package com.example.bilabonnement.model;

public class City {
    private int cityID;
    private String cityName;
    private int cityZipcode;

    public City(int cityID, String cityName, int cityZipcode) {
        this.cityID = cityID;
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
