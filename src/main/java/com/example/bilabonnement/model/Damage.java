package com.example.bilabonnement.model;

public class Damage {

    private int damageID;
    private String damage;
    private double damagePrice;

    public Damage(int damageID, String damage, double damagePrice) {
        this.damageID = damageID;
        this.damage = damage;
        this.damagePrice = damagePrice;
    }

    public int getDamageID() {
        return damageID;
    }

    public String getDamage() {
        return damage;
    }

    public double getDamagePrice() {
        return damagePrice;
    }
}
