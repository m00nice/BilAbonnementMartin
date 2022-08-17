package com.example.bilabonnement.testRepository;

import com.example.bilabonnement.delete.controller.models.Bil;
import com.example.bilabonnement.delete.controller.models.Reservation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
// Forfatter @Cemakay Türker @August Høg Dedenroth @Tobias Winkel
public class TestRepository {
    public List<Bil> getAlleBiler() {
        ArrayList<Bil> bilArrayList = new ArrayList<>(
                Arrays.asList(
                        new Bil(2011, "Skoda", "Citigo", "Hvid", 1, 1, 11, "null", 0),
                        new Bil(2011, "Skoda", "Fabia", "Sort", 2, 2, 22, "null", 0),
                        new Bil(2011, "Skoda", "Octavia", "Sølv", 3, 0, 11, "motor", 10000)
                )
        );
        return bilArrayList;
    }

    public List<Reservation> reservationsArrayList(){
        Date date1 = new Date(2022-05-20);
        Date date2 = new Date(2022-05-23);

        Date date3 = new Date(2022-03-20);
        Date date4 = new Date(2022-04-23);

        Date date5 = new Date(2022-06-20);
        Date date6 = new Date(2022-07-23);


        ArrayList<Reservation> reservationArrayList = new ArrayList<>(
                Arrays.asList(
                       new Reservation(1,1,date1,date2,false,1),
                       new Reservation(2,2,date3,date4,true,2),
                       new Reservation(3,3,date5,date6,false,3)
                )
        );

        return reservationArrayList;
    }

}

