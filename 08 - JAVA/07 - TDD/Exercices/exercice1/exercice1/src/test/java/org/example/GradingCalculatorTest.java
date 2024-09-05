package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class GradingCalculatorTest {
    private GradingCalculator gradingCalculator;

    /*
//- Score : 95%, Présence : 90 => Note: A
    @Test
    public void whenScore_95_AndPresence_90_ThenResult_A(){
        // Arrange
        int score = 95;
        int presence = 90;
        char resultAwait = 'A';
        gradingCalculator = new GradingCalculator(score,presence);

        // Act
        char gradGet = gradingCalculator.getGrade();

        // Assert
        Assertions.assertEquals(resultAwait,gradGet);
    }

//- Score : 85%, Présence : 90 => Note: B
@Test
public void whenScore_85_AndPresence_90_ThenResult_B(){
    // Arrange
    int score = 85;
    int presence = 90;
    char resultAwait = 'B';
    gradingCalculator = new GradingCalculator(score,presence);

    // Act
    char gradGet = gradingCalculator.getGrade();

    // Assert
    Assertions.assertEquals(resultAwait,gradGet);
}
//- Score : 65%, Présence : 90 => Note: C
@Test
public void whenScore_65_AndPresence_90_ThenResult_C(){
    // Arrange
    int score = 65;
    int presence = 90;
    char resultAwait = 'C';
    gradingCalculator = new GradingCalculator(score,presence);

    // Act
    char gradGet = gradingCalculator.getGrade();

    // Assert
    Assertions.assertEquals(resultAwait,gradGet);
}
//- Score : 95%, Présence : 65 => Note: B
@Test
public void whenScore_95_AndPresence_65_ThenResult_B(){
    // Arrange
    int score = 95;
    int presence = 65;
    char resultAwait = 'B';
    gradingCalculator = new GradingCalculator(score,presence);

    // Act
    char gradGet = gradingCalculator.getGrade();

    // Assert
    Assertions.assertEquals(resultAwait,gradGet);
}
//- Score : 95%, Présence : 55 => Note: F
@Test
public void whenScore_95_AndPresence_55_ThenResult_F(){
    // Arrange
    int score = 95;
    int presence = 55;
    char resultAwait = 'F';
    gradingCalculator = new GradingCalculator(score,presence);

    // Act
    char gradGet = gradingCalculator.getGrade();

    // Assert
    Assertions.assertEquals(resultAwait,gradGet);
}
//- Score : 65%, Présence : 55 => Note: F
@Test
public void whenScore_65_AndPresence_55_ThenResult_F(){
    // Arrange
    int score = 65;
    int presence = 55;
    char resultAwait = 'F';
    gradingCalculator = new GradingCalculator(score,presence);

    // Act
    char gradGet = gradingCalculator.getGrade();

    // Assert
    Assertions.assertEquals(resultAwait,gradGet);
}
//- Score : 50%, Présence : 90 => Note: F
@Test
public void whenScore_50_AndPresence_90_ThenResult_F(){
    // Arrange
    int score = 50;
    int presence = 90;
    char resultAwait = 'F';
    gradingCalculator = new GradingCalculator(score,presence);

    // Act
    char gradGet = gradingCalculator.getGrade();

    // Assert
    Assertions.assertEquals(resultAwait,gradGet);
}

     */

    @ParameterizedTest
    /*
    @CsvSource({
            "95,90,A",
            "85,90,B",
            "65,90,C",
            "95,65,B",
            "95,55,F",
            "65,55,F",
            "50,90,F",
    })
     */
    @MethodSource("providerParameters")
    public void whenScoreAndPresenceThenResultAwaitedGrade(int score,int presence, char awaitedGrade){
        // Arrange
        gradingCalculator = new GradingCalculator(score,presence);

        // Act
        char gradGet = gradingCalculator.getGrade();

        // Assert
        Assertions.assertEquals(awaitedGrade,gradGet);
    }

    private static Stream<Arguments> providerParameters(){
        return Stream.of(
          Arguments.of(95,90,'A'),
          Arguments.of(85,90,'B'),
          Arguments.of(65,90,'C'),
          Arguments.of(95,65,'B'),
          Arguments.of(95,55,'F'),
          Arguments.of(65,55,'F'),
          Arguments.of(50,90,'F')
        );
    }
}
