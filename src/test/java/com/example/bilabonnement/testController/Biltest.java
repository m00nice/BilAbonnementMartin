package com.example.bilabonnement.testController;

import com.example.bilabonnement.delete.controller.models.Bil;
import com.example.bilabonnement.testService.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
// Forfatter @Cemakay Türker @August Høg Dedenroth @Tobias Winkel
@SpringBootTest
public class Biltest {


    @Test
    void erPrisOverGennemsnit() {

        //Arrange
        TestService testService = new TestService();

        //Act
        Bil bil = new Bil(2011, "Skoda", "Citigo", "Hvid", 1, 1, 21000, "null", 0);
        boolean forventet = true;

        //Assert
        boolean resultat = testService.erPrisOverGennemsnit(bil);
        assertEquals(forventet, resultat);

    }

    @Test
    void getTotalPrisPåUdlejedeBiler() { //  til forretningudviklere

        //Arrange
        TestService testService = new TestService();

        //Act
        testService.getTotalPrisPåUdlejedeBiler();
        double forventet = 4;


        //Assert
        double resultat = testService.getTotalPrisPåUdlejedeBiler();
        assertEquals(forventet, resultat);

    }

    @Test
    void getUdlejedeBiler() { //  til forretningudviklere

        //Arrange
        TestService testService = new TestService();

        //Act
        testService.getUdlejedeBiler();
        int forventet = 3; // size på ArrayList i BilTestRepository

        //Assert
        int resultat = testService.getUdlejedeBiler().size();
        assertEquals(forventet,resultat);

    }

    @Test
    void getValidReservationer(){ // til dataregistrering

        //Arrange
        TestService testService = new TestService();

        //Act
        testService.opretValidReservationList();
        int forventet = 1;

        //Assert
        int resultat = testService.opretValidReservationList().size();
        assertEquals(forventet,resultat);

    }
    @Test
    void getBilerMedFejlOgMangler(){ // til fejl og mangler

        //Arrange
        TestService testService = new TestService();

        //Act
        testService.getBilerMedFejlOgMangler();
        int forventet = 1;

        //Assert
        int resultat = testService.getBilerMedFejlOgMangler().size();
        assertEquals(forventet,resultat);

    }
}



