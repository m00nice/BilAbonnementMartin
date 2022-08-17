package com.example.bilabonnement.repository;

import com.example.bilabonnement.utility.DataBaseConnectionManager;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Repository {


    public static void executeSQLsyntax(String syntax) {

        try {
            PreparedStatement preparedStatement = DataBaseConnectionManager.getConnection().prepareStatement(syntax);
            preparedStatement.execute();
        } catch (SQLException throwable) {
            System.out.println("Noget gik galt i executeSQLsyntax");
            throwable.printStackTrace();
        }

    }
    public static int executeSQLsyntaxWithReturnID(String syntax) {

        try {
            PreparedStatement preparedStatement = DataBaseConnectionManager.getConnection().prepareStatement(syntax,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);

        } catch (SQLException throwable) {
            System.out.println("Noget gik galt i executeSQLsyntax");
            throwable.printStackTrace();
        }
        return 0;
    }

}
