package com.example.bilabonnement.service;

import com.example.bilabonnement.model.Car;
import com.example.bilabonnement.model.Reservation;
import com.example.bilabonnement.repository.CarRepository;
import com.example.bilabonnement.repository.ReservationRepository;

import java.util.ArrayList;

public class CarService {

    static CarService carService = new CarService();
    private CarService(){}


    public static ArrayList getCarList(){return (ArrayList) CarRepository.getAllCars();}

    public static ArrayList getRentedCarList(){
        ArrayList<Car> rentedCarList = new ArrayList<>();

        for (Reservation reservation: ReservationRepository.getAllReservation()) {
                rentedCarList.add(reservation.getCar());
        }
        return rentedCarList;
    }

    public static ArrayList getDamagedCarList(){
        ArrayList<Car> damagedCarList = new ArrayList<>();

        for (Car car: CarRepository.getAllCars()) {
            if (car.getDamagePrice() > 0){
                damagedCarList.add(car);
            }
        }
        return damagedCarList;
    }

    public static ArrayList getUndamagedCarList(){
        ArrayList<Car> undamagedCarList = new ArrayList<>();

        for (Car car: CarRepository.getAllCars()) {
            if (car.getDamagePrice() == 0){
                undamagedCarList.add(car);
            }
        }
        return undamagedCarList;

    }

    public static void removeDamage(int damageID){
        CarRepository.executeSQLsyntax("UPDATE `bilabonnementre`.`car` SET `damageID` = NULL WHERE (`carID` = '"+damageID+"');");
        CarRepository.executeSQLsyntax("DELETE FROM `bilabonnementre`.`damage` WHERE (`damageID` = '"+damageID+"');");
    }

    public static void addDamage(int carID, String damage, double price){
        int damageID = CarRepository.executeSQLsyntaxWithReturnID("INSERT INTO `bilabonnementre`.`damage` (`damage`, `damagePrice`) VALUES ('"+damage+"', '"+price+"');");
        CarRepository.executeSQLsyntax("UPDATE `bilabonnementre`.`car` SET `damageID` = '"+damageID+"' WHERE (`carID` = '"+carID+"');");
    }

    public static Car getCar(int carID){
        CarRepository.getAllCars();
        for (Car car:
                CarRepository.getAllCars()) {
            if (car.getCarID() == carID)
                return car;
        }
        return null;
    }

    public static double getTotalPriceOfRentedCars(){
        ArrayList<Car> rentedCarList = getRentedCarList();
        double price = 0;
        for (Car car: rentedCarList) {
            price += car.getDamagePrice();
        }
        return price;
    }


}
