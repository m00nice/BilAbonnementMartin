package com.example.bilabonnement.repository;

import com.example.bilabonnement.model.User;
import com.example.bilabonnement.utility.DataBaseConnectionManager;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository extends Repository {

    static UserRepository userRepository = new UserRepository();
    private UserRepository(){}

    public static List<User> getAllUsers(){
        List<User> allUsers = new ArrayList<>();

        try {
            PreparedStatement pstmt = DataBaseConnectionManager.getConnection().prepareStatement("SELECT * FROM user");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){

                User temp = new User(
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(1),
                        rs.getString(4)
                );
                allUsers.add(temp);
            }
        } catch (SQLException e) {
            System.out.println("Noget er gået galt i UserRepository -> getAllUsers");
            e.printStackTrace();
        }
        return allUsers;
    }

    public static void executeSQLsyntax(String syntax) {

        try {
            PreparedStatement preparedStatement = DataBaseConnectionManager.getConnection().prepareStatement(syntax);
            preparedStatement.execute();
        } catch (SQLException throwable) {
            System.out.println("Noget gik galt i UserRepository -> executeSQLsyntax");
            throwable.printStackTrace();
        }

    }


}
