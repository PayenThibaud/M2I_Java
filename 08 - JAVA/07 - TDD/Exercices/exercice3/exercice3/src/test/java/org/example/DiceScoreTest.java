package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

// import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiceScoreTest {
    private DiceScore diceScore;
    private Ide de;


    @BeforeEach
    public void setup(){
        de = Mockito.mock(Ide.class);
        diceScore = new DiceScore(de);
    }

   // - lorsque les 2 dés sont identiques on recupere bien valeur du dé * 2 + 10
    @Test
    public void testDiceScoreWhenGetScore_2DiceAreEquals_DeValues5_ThenScore_20(){
        // Arrange
        int expected = 20;
        Mockito.when(de.getRoll()).thenReturn(5);

        // Act
        int result = diceScore.getScore();

        // Assert
       // assertEquals(expected,result);
        Assertions.assertEquals(expected,result);

    }
   // - dans le cas ou les 2 dés sont identiques et egaux a 6 on recupere 30
    @Test
    public void testDiceScoreWhenGetScore_2DiceAreEquals_DeValues6_ThenScore_30(){
        // Arrange
        int expected = 30;
        Mockito.when(de.getRoll()).thenReturn(6);

        // Act
        int result = diceScore.getScore();

        // Assert
        // assertEquals(expected,result);
        Assertions.assertEquals(expected,result);
    }
   //  - dans le cas ou les dé sont quelconque on recupere la valeure du plus haut des 2
    @Test
    public void testDiceScoreWhenGetScore_2DiceAreDifferent_DeValue6_DeValue4_ThenScore_6(){
        int expected = 6;
        Mockito.when(de.getRoll()).thenReturn(6).thenReturn(4);

        // Act
        int result = diceScore.getScore();

        // Assert
        Assertions.assertEquals(expected,result);

    }
}
