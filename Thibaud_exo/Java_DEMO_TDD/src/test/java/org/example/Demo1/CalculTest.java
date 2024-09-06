package org.example.Demo1;

import org.junit.jupiter.api.*;

public class CalculTest {

    private Calcul calcul;

    @BeforeAll
    public static void setUpAll() {
        System.out.println("une fois avt tout les test");
    }

    @AfterAll
    public static void aferAll(){
        System.out.println("une fois apres tout les test");
    }


    @BeforeEach
    public void setUp() {
        System.out.println("Avt chaque test");
        calcul = new Calcul();
    }

    @AfterEach
    public void AfterUp(){
        System.out.println("Apres chaque test");
    }

    @Test
    public void TestCalculWhenAddition_1_2_Resultat_3() {
        //Arrange
        // calcul = new Calcul();
        double a = 1;
        double b = 2;
        double resultAwait = 3;

        //Act
        double result = calcul.addition(a, b);

        //Assert
        Assertions.assertEquals(resultAwait, result);

    }

    @Test
    public void TestCalculWhenDivision_30_10_Resultat_3() {
        //Arrange
        //  calcul = new Calcul();
        double a = 30;
        double b = 10;
        double resultAwait = 3;

        //Act
        double result = calcul.division(a, b);

        //Assert
        Assertions.assertEquals(resultAwait, result);
    }

    @Test
    public void TestCalculWhenDivision_10_0_Throws_DivideByZeroException() {
        //Arrange
        //   calcul = new Calcul();
        double a = 10;
        double b = 0;

        //Act Assert
        Assertions.assertThrows(DivideByZeroException.class, () -> {
            calcul.division(a, b);
        });
    }
}
