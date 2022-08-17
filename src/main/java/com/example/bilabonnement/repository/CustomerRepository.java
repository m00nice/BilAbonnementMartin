package com.example.bilabonnement.repository;



import com.example.bilabonnement.model.Customer;
import com.example.bilabonnement.utility.DataBaseConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository  extends Repository {

    static CustomerRepository customerRepository = new CustomerRepository();
    private CustomerRepository(){}

    public static List<Customer> getAllCustomers(){
        List<Customer> allCustomers = new ArrayList<>();

        try {
            PreparedStatement pstmt = DataBaseConnectionManager.getConnection().prepareStatement("SELECT * FROM customer");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){

                Customer temp = new Customer(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        CityRepository.getCustomerCity(rs.getInt(6)).getCityName(),
                        CityRepository.getCustomerCity(rs.getInt(6)).getCityZipcode(),
                        rs.getString(7)
                );
                allCustomers.add(temp);
            }
        } catch (SQLException e) {
            System.out.println("Noget er gået galt i CustomerRepository -> getAllCustomers");
            e.printStackTrace();
        }
        return allCustomers;
    }

}
