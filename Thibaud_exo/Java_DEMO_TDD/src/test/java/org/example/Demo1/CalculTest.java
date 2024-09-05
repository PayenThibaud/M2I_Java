package org.example.Demo1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculTest {

    private Calcul calcul;


    @Test
    public void TestCalculWhenAddition_1_2_Resultat_3(){
        //Arrange
        calcul = new Calcul();
        double a = 1;
        double b = 2;
        double resultAwait = 3;

        //Act
        double result = calcul.addition(a,b);

        //Assert
        Assertions.assertEquals(resultAwait,result);

    }

    @Test
    public void TestCalculWhenDivision_30_10_Resultat_3(){
        //Arrange
        calcul = new Calcul();
        double a = 30;
        double b = 10;
        double resultAwait = 3;

        //Act
        double result = calcul.division(a,b);

        //Assert
        Assertions.assertEquals(resultAwait,result);
    }

    @Test
    public void TestCalculWhenDivision_10_0_Throws_DivideByZeroException(){
        //Arrange
        calcul = new Calcul();
        double a = 10;
        double b = 0;

        //Act Assert
        Assertions.assertThrows(DivideByZeroException.class, ()->{calcul.division(a,b);});
    }
}
