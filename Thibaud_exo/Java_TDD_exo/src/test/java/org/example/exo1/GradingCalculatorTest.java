package org.example.exo1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GradingCalculatorTest {

    private GradingCalculator gradingCalculator;

    @Test
    public void TestGradingCalculatorWhenScore_50_Presence_90_Resultat_F() {
        // Arrange
        int score = 50;
        int presence = 90;
        gradingCalculator = new GradingCalculator(score, presence);
        char resultAwait = 'F';

        // Act
        char result = gradingCalculator.getGrade();

        //Assert
        Assertions.assertEquals(resultAwait, result);

    }

    @Test
    public void TestGradingCalculatorWhenScore_65_Presence_55_Resultat_F() {
        // Arrange
        int score = 65;
        int presence = 55;
        gradingCalculator = new GradingCalculator(score, presence);
        char resultAwait = 'F';

        // Act
        char result = gradingCalculator.getGrade();

        //Assert
        Assertions.assertEquals(resultAwait, result);

    }

    @Test
    public void TestGradingCalculatorWhenScore_95_Presence_55_Resultat_F() {
        // Arrange
        int score = 95;
        int presence = 55;
        gradingCalculator = new GradingCalculator(score, presence);
        char resultAwait = 'F';

        // Act
        char result = gradingCalculator.getGrade();

        //Assert
        Assertions.assertEquals(resultAwait, result);

    }

    @Test
    public void TestGradingCalculatorWhenScore_95_Presence_65_Resultat_B() {
        // Arrange
        int score = 95;
        int presence = 65;
        gradingCalculator = new GradingCalculator(score, presence);
        char resultAwait = 'B';

        // Act
        char result = gradingCalculator.getGrade();

        //Assert
        Assertions.assertEquals(resultAwait, result);

    }

    @Test
    public void TestGradingCalculatorWhenScore_65_Presence_90_Resultat_C() {
        // Arrange
        int score = 65;
        int presence = 90;
        gradingCalculator = new GradingCalculator(score, presence);
        char resultAwait = 'C';

        // Act
        char result = gradingCalculator.getGrade();

        //Assert
        Assertions.assertEquals(resultAwait, result);

    }

    @Test
    public void TestGradingCalculatorWhenScore_85_Presence_90_Resultat_B() {
        // Arrange
        int score = 85;
        int presence = 90;
        gradingCalculator = new GradingCalculator(score, presence);
        char resultAwait = 'B';

        // Act
        char result = gradingCalculator.getGrade();

        //Assert
        Assertions.assertEquals(resultAwait, result);

    }

    @Test
    public void TestGradingCalculatorWhenScore_95_Presence_90_Resultat_A() {
        // Arrange
        int score = 95;
        int presence = 90;
        gradingCalculator = new GradingCalculator(score, presence);
        char resultAwait = 'A';

        // Act
        char result = gradingCalculator.getGrade();

        //Assert
        Assertions.assertEquals(resultAwait, result);

    }
}
