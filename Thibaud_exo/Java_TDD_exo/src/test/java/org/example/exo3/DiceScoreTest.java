package org.example.exo3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class DiceScoreTest {

    private DiceScore diceScore;
    private Ide de = Mockito.mock(Ide.class);


    @BeforeEach
    public void setUp() {
        diceScore = new DiceScore(de);
    }

    @Test
    public void testDiceScoreWhenDiceRollsAreSame() {
        // Arrange
        int scoreFirst = 4;
        int scoreSecond = scoreFirst;
        Mockito.when(de.getRoll()).thenReturn(scoreFirst, scoreSecond);
        int expectedScore = scoreFirst * 2 + 10;

        // Act
        int actualScore = diceScore.getScore();

        // Assert
        Assertions.assertEquals(expectedScore, actualScore);
    }


    @Test
    public void TestDiceScoreWhen_DiceScore_is_Same_6(){
        // Arrange
        int scoreFirst = 6;
        int scoreSecond = scoreFirst;
        Mockito.when(de.getRoll()).thenReturn(scoreFirst, scoreSecond);

        int expectedScore = 30;

        // Act
        int actualScore = diceScore.getScore();

        // Assert
        Assertions.assertEquals(expectedScore, actualScore);
    }

    @Test
    public void TestDiceScoreWhen_DiceScore_is_any_roll(){
        // Arrange
        int scoreFirst = 6;
        int scoreSecond = 4;
        Mockito.when(de.getRoll()).thenReturn(scoreFirst, scoreSecond);

        int expectedScore = (scoreSecond > scoreFirst) ? scoreSecond : scoreFirst;

        // Act
        int actualScore = diceScore.getScore();

        // Assert
        Assertions.assertEquals(expectedScore, actualScore);

    }


}
