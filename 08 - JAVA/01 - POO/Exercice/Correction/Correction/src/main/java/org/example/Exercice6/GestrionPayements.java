package org.example.Exercice6;

import org.example.Exercice6.interfaces.Paiment;
import org.example.Exercice6.models.CarteDeCredit;
import org.example.Exercice6.models.Paypal;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class GestrionPayements {

    public static void main(String[] args) {
        Paiment[] paiments = new Paiment[]{
                new CarteDeCredit("0000-0000-0000-0000","titualire", LocalDate.of(2026,12,12),"333"),
                new CarteDeCredit("1111-1111-1111-0000","titualire",LocalDate.of(2026,12,12),"777"),
                new Paypal("titulaire@email.com","Pa$$word"),

        };

        for (Paiment paiment : paiments){

            System.out.println(paiment.effectuerPayement(25));
            System.out.println(paiment.effectuerPayement(0));
        }
    }
}
