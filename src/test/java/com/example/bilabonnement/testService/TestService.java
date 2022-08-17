package com.example.bilabonnement.testService;

import com.example.bilabonnement.delete.controller.models.Bil;
import com.example.bilabonnement.delete.controller.models.Reservation;
import com.example.bilabonnement.testRepository.TestRepository;

import java.util.ArrayList;
import java.util.List;
// Forfatter @Cemakay Türker @August Høg Dedenroth @Tobias Winkel
public class TestService {

    TestRepository testRepository = new TestRepository();

    public double getTotalPrisPåUdlejedeBiler(){

        List<Bil> bilArrayList = testRepository.getAlleBiler();
        double pris = 0;
        for (Bil bil : bilArrayList){
            if (bil.getKundeID() > 0) {
                pris += bil.getPris();
            }
        }
        return (Math.round(pris*100.0)/100.0);
    }

    public boolean erPrisOverGennemsnit(Bil bil){
        List<Bil> bilListe = testRepository.getAlleBiler();
        int gennemsnit = 0;

        for (int i = 0; i < bilListe.size(); i++) {
            gennemsnit += bilListe.get(i).getPris();
        }
        gennemsnit = gennemsnit / bilListe.size();


        if (bil.getPris()>= gennemsnit){
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Bil> getUdlejedeBiler(){
        ArrayList<Bil> biler = (ArrayList<Bil>) testRepository.getAlleBiler();
        ArrayList<Bil> udlejedeBiler = new ArrayList<>();
        for(Bil bil : biler){
            if (bil.getKundeID() > 0 ){
                udlejedeBiler.add(bil);
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
    public ArrayList<Bil> getBilerMedFejlOgMangler(){
        ArrayList<Bil> biler = (ArrayList<Bil>) testRepository.getAlleBiler();
        ArrayList<Bil> bilMedFejl = new ArrayList<>();
        for (Bil bil : biler){
            if (bil.getKundeID() == 0 && bil.getFejl_pris() > 0){
                bilMedFejl.add(bil);
            }
        }
        return bilMedFejl;

    }

}
