package org.example.Demo2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class JeuTest {

    private Jeu jeu;
   // private Ide de = Mockito.mock(Ide.class);
    private De de = Mockito.mock(De.class);

    @Test
    public void testJeuWhenJouer_IfDeLancerReturn6_ThenResult_True(){
        // Arrange
        jeu = new Jeu(de);
        Mockito.when(de.lancer()).thenReturn(6);

        // Act
        boolean result = jeu.jouer();

        // Assert
        Assertions.assertTrue(result);

    }

    @Test
    public void testJeuWhenJouer_IfDeLancerReturn19_ThenResult_False(){
        // Arrange
        jeu = new Jeu(de);
        Mockito.when(de.lancer()).thenReturn(19);

        // Act
        boolean result = jeu.jouer();

        // Assert
        Assertions.assertFalse(result);
    }


}
