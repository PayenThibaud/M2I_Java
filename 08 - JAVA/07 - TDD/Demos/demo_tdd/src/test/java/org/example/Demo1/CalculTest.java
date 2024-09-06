package org.example.Demo1;

import org.junit.jupiter.api.*;

public class CalculTest {

    private Calcul calcul;

    @BeforeAll
    public static void setupAll(){
        System.out.println("Une fois avant tous les tests");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("Une fois apres tous les tests");
    }

    @BeforeEach
    public void setup(){
        System.out.println("Avant chaque test");
        calcul = new Calcul();
    }

    @AfterEach
    public void setupAfter(){
        System.out.println("Apres chaque test");
    }


    @Test
    public void TestCalculWhenAddition_1_2_ThenResult_3(){
        // Arrange
       // calcul = new Calcul();
        double x = 1;
        double y = 2;
        double resultAwait = 3;

        //Act
        double result = calcul.addition(x,y);

        //Assert
        Assertions.assertEquals(resultAwait,result);
    }

    @Test
    public void TestCalculWhenDivision_30_10_ThenResult_3(){
        // Arrange
      //  calcul = new Calcul();
        double x = 30;
        double y = 10;
        double resultAwait = 3;

        //Act
        double result = calcul.division(x,y);

        //Assert
        Assertions.assertEquals(resultAwait,result);

    }

    @Test
    public void TestCalculWhenDivision_10_0_ThenThrows_DividedByZeroException(){
        // Arrange
      //  calcul = new Calcul();
        double x = 10;
        double y = 0;

        // Act Assert
        Assertions.assertThrows(DividedbyZeroException.class,()->{calcul.division(x,y);});
    }
}
