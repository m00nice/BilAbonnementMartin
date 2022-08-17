package com.example.bilabonnement.repository;

import com.example.bilabonnement.model.City;
import com.example.bilabonnement.utility.DataBaseConnectionManager;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityRepository  extends Repository {


    static CityRepository cityRepository = new CityRepository();
    private CityRepository(){}

    public static City getCustomerCity(int customerID){

        try {
            PreparedStatement pstmt = DataBaseConnectionManager.getConnection().prepareStatement("SELECT * FROM cities");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                if (rs.getInt(1) == customerID){
                    return new City(rs.getInt(1), rs.getString(2),rs.getInt(3) );
                }
            }
        } catch (SQLException e) {
            System.out.println("Noget er gået galt i CustomerRepository -> getAllCustomers");
            e.printStackTrace();
        }
        return null;
    }


}
