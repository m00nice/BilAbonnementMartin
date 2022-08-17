package com.example.bilabonnement.controller;

import com.example.bilabonnement.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @GetMapping("/")
    public String index(){return "index";}

    @PostMapping("/")
    public String logIn(WebRequest personaleData, HttpSession session) {
        String username = personaleData.getParameter("username");
        String password = personaleData.getParameter("password");
        boolean token = UserService.checkBruger(username, password);
        if (token) {
            String rolle = UserService.getRolle(username, password);
            session.setAttribute("isloggedin", true);

            if (rolle.equals("DR")) {
                return "redirect:http://localhost:8080/Dataregistrering/Invalid";
            }
            if (rolle.equals("FU")) {
                return "redirect:http://localhost:8080/Forretningsudvikling";
            }
            if (rolle.equals("SU")) {
                return "redirect:http://localhost:8080/SkadeOgUdbedring/Biler-med-skader";
            }
        }
        return "redirect:http://localhost:8080/";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("isloggedin");
        session.invalidate();
        return "redirect:/";
    }

}
