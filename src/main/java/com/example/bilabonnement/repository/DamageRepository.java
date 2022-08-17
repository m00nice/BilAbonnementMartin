package com.example.bilabonnement.repository;

import com.example.bilabonnement.model.Damage;
import com.example.bilabonnement.utility.DataBaseConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DamageRepository  extends Repository {


    static DamageRepository damageRepository = new DamageRepository();
    private DamageRepository(){}


    public static Damage getCarDamage(int carID){

        try {
            PreparedStatement pstmt = DataBaseConnectionManager.getConnection().prepareStatement("SELECT * FROM damage");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                if (rs.getInt(1) == carID){
                    return new Damage(rs.getInt(1), rs.getString(2),rs.getDouble(3) );
                }
            }
        } catch (SQLException e) {
            System.out.println("Noget er gået galt i CustomerRepository -> getAllCustomers");
            e.printStackTrace();
        }
        return new Damage(0,"",0);
    }




}
