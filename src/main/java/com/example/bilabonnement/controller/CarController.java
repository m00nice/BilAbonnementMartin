package com.example.bilabonnement.controller;

import com.example.bilabonnement.model.Car;
import com.example.bilabonnement.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;

@Controller
public class CarController {


    @GetMapping("/SkadeOgUdbedring/Biler-med-skader")
    public String allDamagedCars(Model model){
        ArrayList<Car> damagedList = CarService.getDamagedCarList();
        model.addAttribute("damagedList", damagedList);
        return "SkadeListe";
    }
    @GetMapping("/SkadeOgUdbedring/Biler-uden-skader")
    public String allUndamagedCars(Model model){
        ArrayList<Car> undamagedList = CarService.getUndamagedCarList();
        model.addAttribute("undamagedList", undamagedList);
        return "!Skadeliste";
    }
    @PostMapping("/SkadeOgUdbedring/Biler-med-skader")
    public String removeDamage(WebRequest fejlData){
        int carID = Integer.parseInt(fejlData.getParameter("carID"));
        CarService.removeDamage(carID);

        return "redirect:http://localhost:8080/SkadeOgUdbedring/Biler-med-skader";
    }
    @PostMapping("/SkadeOgUdbedring/Biler-uden-skader")
    public String addDamage(WebRequest damageData){
        int carID = Integer.parseInt(damageData.getParameter("carID"));

        if(damageData.getParameter("price").equals("")){

            return "redirect:http://localhost:8080/SkadeOgUdbedring/Biler-uden-skader";
        }
        if (damageData.getParameter("damage").equals("")){

            return "redirect:http://localhost:8080/SkadeOgUdbedring/Biler-uden-skader";
        }
        if(!damageData.getParameter("price").equals("") && !damageData.getParameter("damage").equals("")){
            double price = Double.parseDouble(damageData.getParameter("price"));
            String damage = damageData.getParameter("damage");
            CarService.addDamage(carID,damage,price);
            return "redirect:http://localhost:8080/SkadeOgUdbedring/Biler-uden-skader";
        }
        return "redirect:http://localhost:8080/SkadeOgUdbedring/Biler-uden-skader";
    }



    @GetMapping("/Forretningsudvikling")
    public String rentedCarsList(Model model){
        ArrayList<Car> carList = CarService.getRentedCarList();
        double totalPrice = CarService.getTotalPriceOfRentedCars();
        model.addAttribute("carList",carList);
        model.addAttribute("totalPrice",totalPrice);
        return "Forretningsudviklere";
    }



}
