package com.example.bilabonnement.controller;

import com.example.bilabonnement.model.Reservation;
import com.example.bilabonnement.service.CarService;
import com.example.bilabonnement.service.CustomerService;
import com.example.bilabonnement.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;

@Controller
public class ReservationController {

    @GetMapping("/Dataregistrering/Valid")
    public String ValidReservationer(Model model){
        ArrayList liste = ReservationService.getValidReservationList();
        model.addAttribute("validliste",liste);
        return "Dataregistrering";
    }
    @PostMapping("/Dataregistrering/Valid")
    public String changeValidation(WebRequest bilData){
        int reservationID = Integer.parseInt(bilData.getParameter("reservationID"));
        ReservationService.changeValidationReservation(ReservationService.getReservation(reservationID));
        return "redirect:http://localhost:8080/Dataregistrering/Valid";
    }

    @GetMapping("/Dataregistrering/Invalid")
    public String InvalidReservationer(Model model){
        ArrayList liste = ReservationService.getInvalidReservationList();
        model.addAttribute("invalidliste",liste);
        return "!Dataregistrering";
    }

    @PostMapping("/Dataregistrering/Invalid")
    public String changeInvalidation(WebRequest bilData){
        int reservationID = Integer.parseInt(bilData.getParameter("reservationID"));
        ReservationService.changeValidationReservation(ReservationService.getReservation(reservationID));
        return "redirect:http://localhost:8080/Dataregistrering/Invalid";
    }
    @PostMapping("/Dataregistrering/Invalid/DELETE")
    public String deleteReservation(WebRequest bilData){
        int reservationID = Integer.parseInt(bilData.getParameter("reservationID"));
        ReservationService.deleteReservation(reservationID);
        return "redirect:http://localhost:8080/Dataregistrering/Invalid";
    }

    @GetMapping("/Dataregistrering/info")
    public String ReservationInfo(Reservation reservation, Model model1, Model model2){

        model1.addAttribute("bilTilInfo", CarService.getCar(reservation.getCar().getCarID()));
        model2.addAttribute("kundeInfo", CustomerService.getCustomer(reservation.getCustomer().getCustomerId()));

        return "Dataregistrering";

    }

}
