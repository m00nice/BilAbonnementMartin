package com.example.bilabonnement.service;

import com.example.bilabonnement.model.Customer;
import com.example.bilabonnement.repository.CustomerRepository;


import java.util.ArrayList;

public class CustomerService {

    static CustomerService customerService = new CustomerService();
    CustomerService(){}

    public static ArrayList getCustomerList(){
        return (ArrayList) CustomerRepository.getAllCustomers();
    }

    public static Customer getCustomer(int customerID){
        ArrayList<Customer> customers = getCustomerList();
        for (Customer customer: customers) {
            if (customer.getCustomerId() == customerID){
                return customer;
            }
        }
        return null;
    }


}
