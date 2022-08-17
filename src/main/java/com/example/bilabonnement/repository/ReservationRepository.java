package com.example.bilabonnement.repository;

import com.example.bilabonnement.model.Car;
import com.example.bilabonnement.model.Customer;
import com.example.bilabonnement.model.Reservation;
import com.example.bilabonnement.utility.DataBaseConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationRepository extends Repository {

    static ReservationRepository reservationRepository = new ReservationRepository();
    private ReservationRepository(){}

    public static List<Reservation> getAllReservation(){
        List<Reservation> allUsers = new ArrayList<>();

        try {
            PreparedStatement pstmt = DataBaseConnectionManager.getConnection().prepareStatement("SELECT * FROM car");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){

                Reservation temp = new Reservation(
                        rs.getInt(1),
                        getCarWithId(rs.getInt(2)),
                        getCustomerWithId(rs.getInt(3)),
                        rs.getDate(4),
                        rs.getDate(5),
                        rs.getBoolean(6)
                );
                allUsers.add(temp);
            }
        } catch (SQLException e) {
            System.out.println("Noget er gået galt i UserRepository -> getAllUsers");
            e.printStackTrace();
        }
        return allUsers;
    }

    private static Car getCarWithId(int carID){
        CarRepository.getAllCars();
        for (Car car:
             CarRepository.getAllCars()) {
            if (car.getCarID() == carID)
                return car;
        }
        return null;
    }
    private static Customer getCustomerWithId(int customerID){
        CustomerRepository.getAllCustomers();
        for (Customer customer:
                CustomerRepository.getAllCustomers()) {
            if (customer.getCustomerId() == customerID)
                return customer;
        }
        return null;
    }


}
