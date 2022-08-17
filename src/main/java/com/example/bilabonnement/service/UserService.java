package com.example.bilabonnement.service;

import com.example.bilabonnement.model.User;
import com.example.bilabonnement.repository.UserRepository;


import java.util.ArrayList;

public class UserService {

    static UserService userService = new UserService();
    UserService(){}


    public static boolean checkBruger(String username, String password) {
        ArrayList<User> userList = (ArrayList<User>) UserRepository.getAllUsers();
        for (User user: userList) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return true;}
        }
        return false;
    }

    public static String getRolle(String username, String password) {
        ArrayList<User> userList = (ArrayList<User>) UserRepository.getAllUsers();
        for (User user: userList) {
            if (user.getUsername().equals(username)&& user.getPassword().equals(password)) {
                return user.getRole();
            }
        }
        return "";
    }

}
