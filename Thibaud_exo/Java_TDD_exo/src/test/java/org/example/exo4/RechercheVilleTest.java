package org.example.exo4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RechercheVilleTest {

    private RechercheVille rechercheVille;

    @BeforeEach
    public void setUp() {
        rechercheVille = new RechercheVille();
    }

    @Test
    public void TestRechercheVilleWhenMot_Size_less_2_ThenThrow_NotFoundException(){
        // Arrange
        String mot = "e";

        // Act Assert
        Assertions.assertThrows(NotFoundException.class,()->{rechercheVille.rechercher(mot);});
    }

    @Test
    public void TestRechercheVilleWhenMot_start_CityName_ThenResult_CityWithSameStart(){
        // Arrange
        String mot = "Li";
        String ville = "Lille";

        // Act
        List<String> resultat = rechercheVille.rechercher(mot);

        // Assert
        Assertions.assertTrue(resultat.contains(ville));
    }

    @Test
    public void TestRechercheVilleWhenMot_Case_UpperCase_Or_LowerCase_ThenResult_SameCity(){
        // Arrange
        String mot = "lIlLe";
        String ville = "Lille";

        // Act
        List<String> resultat = rechercheVille.rechercher(mot);

        // Assert
        Assertions.assertTrue(resultat.contains(ville));
    }

    @Test
    public void TestRechercheVilleWhen_Mot_Stat_Anywhere_ThenResult_City(){
        String mot = "ll";
        String ville = "Lille";

        // Act
        List<String> resultat = rechercheVille.rechercher(mot);

        // Assert
        Assertions.assertTrue(resultat.contains(ville));

    }

    @Test
    public void TestRechercheVilleWhen_Mot_is_Asterique_ThenResult_AllCity(){
        String mot = "*";
        String ville = "Lille";
        String ville2 = "Paris";
        String ville3 = "Lyon";

        // Act
        List<String> resultat = rechercheVille.rechercher(mot);

        // Assert
        Assertions.assertTrue(resultat.contains(ville) && resultat.contains(ville2) && resultat.contains(ville3));

    }


}
