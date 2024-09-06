package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RechercheVilleTest {

    private RechercheVille rechercheVille;

    @BeforeEach
    public void setup(){
        rechercheVille = new RechercheVille();
    }

    @Test
    public void testRechercheVilleWhenRechercherWithLessThan_2Char_ThrowException_NotFoundException(){
        // Arrange
        String searchString = "a";

        // Act // Assert
        Assertions.assertThrows(NotFoundException.class,()->{
            rechercheVille.rechercher(searchString);
        });
    }

    @Test
    public void testRechercheVilleWhenRechercherStringGreater_2Char_ReturnCitiesStartedWithChar(){
        // Arrange
        String searchString = "Va";
        List<String> expected = List.of("Valence","Vancouver" );

        // Act
        List<String> result = rechercheVille.rechercher(searchString);

        // Assert
        Assertions.assertEquals(expected,result);
     }

    @Test
    public void testRechercheVilleWhenRechercherStringGreater_2Char_NotCaseSensitive_ReturnCitiesStartedWithChar(){
        // Arrange
        String searchString = "vA";
        List<String> expected = List.of("Valence","Vancouver" );

        // Act
        List<String> result = rechercheVille.rechercher(searchString);

        // Assert
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void testRechercheVilleWhenRechercherStringGreater_2Char_NotCaseSensitive_ReturnCitiesContainsWithChar(){
        // Arrange
        String searchString = "ape";
        List<String> expected = List.of("Budapest" );

        // Act
        List<String> result = rechercheVille.rechercher(searchString);

        // Assert
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void testRechercheVilleWhenRechercher_CharAsterisk_ReturnAllCities(){
        // Arrange
        String searchString = "*";
        List<String> expected = List.of("Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver", "Amsterdam", "Vienne", "Sydney", "New York", "Londres", "Bangkok", "Hong Kong", "Dubaï", "Rome", "Istanbul");

        // Act
        List<String> result = rechercheVille.rechercher(searchString);

        // Assert
        Assertions.assertEquals(expected,result);
    }



}
