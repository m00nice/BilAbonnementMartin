package com.example.bilabonnement.service;

import com.example.bilabonnement.model.Reservation;
import com.example.bilabonnement.repository.ReservationRepository;


import java.util.ArrayList;

public class ReservationService {

    static ReservationService reservationService = new ReservationService();
    private ReservationService(){}


    public static Reservation getReservation(int reservationID){
        ArrayList<Reservation> allReservations = (ArrayList<Reservation>) ReservationRepository.getAllReservation();
        for (Reservation reservation: allReservations) {
            if (reservation.getReservationID() == reservationID){
                return reservation;
            }
        }
        return null;
    }

    public static ArrayList getReservationList(){return (ArrayList) ReservationRepository.getAllReservation();}

    public static ArrayList getValidReservationList(){
        ArrayList<Reservation> allReservations = (ArrayList<Reservation>) ReservationRepository.getAllReservation();
        ArrayList<Reservation> validReservations = new ArrayList<>();
        for (Reservation reservation: allReservations) {
            if(reservation.isValid()){
                validReservations.add(reservation);
            }
        }
        return validReservations;
    }

    public static ArrayList getInvalidReservationList(){
        ArrayList<Reservation> allReservations = (ArrayList<Reservation>) ReservationRepository.getAllReservation();
        ArrayList<Reservation> invalidReservations = new ArrayList<>();
        for (Reservation reservation: allReservations) {
            if(!reservation.isValid()){
                invalidReservations.add(reservation);
            }
        }
        return invalidReservations;
    }

    public static void changeValidationReservation(Reservation reservation){
        if(reservation.isValid()){reservation.setValid(false); ReservationRepository.executeSQLsyntax("UPDATE `bilabonnement`.`reservation` SET `valid` = '-2' WHERE (`reservationID` = '"+reservation.getReservationID()+"')");}
        else{reservation.setValid(true); ReservationRepository.executeSQLsyntax("UPDATE `bilabonnement`.`reservation` SET `valid` = '2' WHERE (`reservationID` = '"+reservation.getReservationID()+"')");}
    }
    public static void deleteReservation(int reservationID){
        ReservationRepository.executeSQLsyntax("DELETE FROM `bilabonnement`.`reservation` WHERE (`reservationID` = '"+reservationID+"');");
    }

}
