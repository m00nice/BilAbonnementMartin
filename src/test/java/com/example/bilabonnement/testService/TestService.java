package com.example.bilabonnement.testService;


import com.example.bilabonnement.model.Car;
import com.example.bilabonnement.model.Reservation;
import com.example.bilabonnement.testRepository.TestRepository;

import java.util.ArrayList;
import java.util.List;
// Forfatter @Cemakay Türker @August Høg Dedenroth @Tobias Winkel
public class TestService {

    TestRepository testRepository = new TestRepository();

       public double getTotalPrisPåUdlejedeBiler(){

        List<Car> carList = testRepository.getAlleBiler();
        double pris = 0;
        for (Car car : carList){
            if (car.getCarID() > 0) {
                pris += car.getRentPrice();
            }
        }
        return (Math.round(pris*100.0)/100.0);
    }

    public boolean erPrisOverGennemsnit(Car car){
        List<Car> bilListe = testRepository.getAlleBiler();
        int gennemsnit = 0;

        for (int i = 0; i < bilListe.size(); i++) {
            gennemsnit += bilListe.get(i).getRentPrice();
        }
        gennemsnit = gennemsnit / bilListe.size();


        if (car.getRentPrice()>= gennemsnit){
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Car> getUdlejedeBiler(){
        ArrayList<Car> carList = (ArrayList<Car>) testRepository.getAlleBiler();
        ArrayList<Car> udlejedeBiler = new ArrayList<>();
        for(Car car : carList){
            if (car.getRentPrice() > 0 ){
                udlejedeBiler.add(car);
            }
        }
        return udlejedeBiler;
    }
    public ArrayList opretValidReservationList(){
        ArrayList<Reservation> alleReservationer = (ArrayList<Reservation>) testRepository.reservationsArrayList();
        ArrayList<Reservation> reservationer = new ArrayList();
        for (Reservation reservation: alleReservationer) {
            if(reservation.isValid()){
                reservationer.add(reservation);
            }
        }
        return reservationer;
    }
    public ArrayList<Car> getBilerMedFejlOgMangler(){
        ArrayList<Car> carList = (ArrayList<Car>) testRepository.getAlleBiler();
        ArrayList<Car> bilMedFejl = new ArrayList<>();
        for (Car car : carList){
            if (car.getDamagePrice() > 0){
                bilMedFejl.add(car);
            }
        }
        return bilMedFejl;

    }

}
