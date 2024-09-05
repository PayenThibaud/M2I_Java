package org.example.exo1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GradingParamterizedTest {

    private GradingCalculator gradingCalculator;

    @ParameterizedTest
    @CsvSource({
            "95, 90, 'A'",
            "85, 90, 'B'",
            "65, 90, 'C'",
            "50, 90, 'F'",
            "95, 55, 'F'",
            "65, 55, 'F'"
    })
    public void TestGradingCalculatorWhen_Score_Presence_Resultat_In_CsvSource(int score, int presence, char resultAwait) {
        // Arrange
        gradingCalculator = new GradingCalculator(score, presence);

        // Act
        char result = gradingCalculator.getGrade();

        // Assert
        Assertions.assertEquals(resultAwait, result);
    }
}