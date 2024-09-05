package org.example.Demo2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class JeuTest {

    private Jeu jeu;
    private Ide de = Mockito.mock(Ide.class);

    @Test
    public void testJeuWhenJouer_IfDeLancerReturn_6_Result_True() {
        // Arrange
        jeu = new Jeu(de);
        Mockito.when(de.lancer()).thenReturn(202);


        // Act
        boolean result = jeu.jouer();


        // Assert
        Assertions.assertTrue(result);



    }

}
