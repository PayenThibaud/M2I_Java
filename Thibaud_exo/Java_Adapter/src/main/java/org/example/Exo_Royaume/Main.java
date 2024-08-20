package org.example.Exo_Royaume;

import org.example.Exo_Royaume.Hero.competences.Magie;
import org.example.Exo_Royaume.Hero.enums.PouvoirMagique;
import org.example.Exo_Royaume.Hero.personnages.Mage;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Magie> competencesMagiques = Arrays.asList(
                new Magie(PouvoirMagique.BouleDeFeu, 2),
                new Magie(PouvoirMagique.BouleDeFeu, 3)
        );


        Mage mage = new Mage.MageBuilder()
                .name("Merlin")
                .level(10)
                .magie(competencesMagiques)
                .pv(100)
                .pa(20)
                .build();


        System.out.println(mage);
    }
}