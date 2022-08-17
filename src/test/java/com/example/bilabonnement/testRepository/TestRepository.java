package com.example.bilabonnement.testRepository;

import com.example.bilabonnement.model.Car;
import com.example.bilabonnement.model.Customer;
import com.example.bilabonnement.model.Reservation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TestRepository {




    public List<Car> getAlleBiler() {
        ArrayList<Car> CarList = new ArrayList<>(
                Arrays.asList(
                        new Car(2011, "Skoda", "Citigo", "Hvid", 1, 1, "bruh", 1000, 0),
                        new Car(2011, "Skoda", "Fabia", "Sort", 2, 2, "bruh", 1000, 0),
                        new Car(2011, "Skoda", "Octavia", "Sølv", 3, 0, "bruh", 1000, 0)
                )
        );
        return CarList;
    }

    public List<Reservation> reservationsArrayList(){

        Car car1 = new Car(2011, "Skoda", "Citigo", "Hvid", 1, 1, "bruh", 1000, 0);
        Customer customer1 = new Customer(1,"John Johnson","John@mail.dk","34224242","Johnvej 1","København",1000,"1212121212");
        Date date1 = new Date(2022-05-20);
        Date date2 = new Date(2022-05-23);

        Car car2 = new Car(2011, "Skoda", "Fabia", "Sort", 2, 2, "bruh", 1000, 0);
        Customer customer2 = new Customer(2,"John Johnson II","John2@mail.dk","44224242","Johnvej 2","København",1000,"1312121212");
        Date date3 = new Date(2022-03-20);
        Date date4 = new Date(2022-04-23);

        Car car3 = new Car(2011, "Skoda", "Octavia", "Sølv", 3, 0, "bruh", 1000, 0);
        Customer customer3 = new Customer(3,"John Johnson III","John3@mail.dk","54224242","Johnvej 3","København",1000,"1412121212");
        Date date5 = new Date(2022-06-20);
        Date date6 = new Date(2022-07-23);


        ArrayList<Reservation> reservationArrayList = new ArrayList<>(
                Arrays.asList(
                       new Reservation(1,car1,customer1,date1,date2,false),
                       new Reservation(2,car2,customer2,date3,date4,true),
                       new Reservation(3,car3,customer3,date5,date6,true)
                )
        );

        return reservationArrayList;
    }

}

