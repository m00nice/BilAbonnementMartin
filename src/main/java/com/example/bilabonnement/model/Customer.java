package com.example.bilabonnement.model;

public class Customer {

    private int customerId;
    private String name;
    private String email;
    private String phonenumber;
    private String streetAddress;
    private String cityAddress;
    private int zipcode;
    private String cpr_nr;

    public Customer(int customerId, String name, String email, String phonenumber, String streetAddress, String cityAddress, int zipcode, String cpr_nr) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phonenumber = phonenumber;
        this.streetAddress = streetAddress;
        this.cityAddress = cityAddress;
        this.zipcode = zipcode;
        this.cpr_nr = cpr_nr;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCityAddress() {
        return cityAddress;
    }

    public int getZipcode() {
        return zipcode;
    }

    public String getCpr_nr() {
        return cpr_nr;
    }
}
