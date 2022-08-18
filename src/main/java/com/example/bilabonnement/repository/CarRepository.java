package com.example.bilabonnement.repository;

import com.example.bilabonnement.model.Car;
import com.example.bilabonnement.utility.DataBaseConnectionManager;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarRepository extends Repository {

    static CarRepository carRepository = new CarRepository();
    private CarRepository(){}

    public static List<Car> getAllCars(){
        List<Car> allCars = new ArrayList<>();

        try {
            PreparedStatement pstmt = DataBaseConnectionManager.getConnection().prepareStatement("SELECT * FROM car");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){

                Car temp = new Car(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        DamageRepository.getCarDamage(rs.getInt(7)).getDamage(),
                        DamageRepository.getCarDamage(rs.getInt(7)).getDamagePrice(),
                        rs.getDouble(6)
                );
                allCars.add(temp);
            }
        } catch (SQLException e) {
            System.out.println("Noget er gået galt i CarRepository -> getAllCars");
            e.printStackTrace();
        }
        return allCars;
    }


}
