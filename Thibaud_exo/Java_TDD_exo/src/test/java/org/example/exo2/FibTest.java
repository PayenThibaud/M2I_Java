package org.example.exo2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class FibTest {

    private Fib fib;

    @Test
    public void testFibWhen_Range_1_Result_NotVoid_And_0() {
        // Arrange
        int range = 1;
        fib = new Fib(range);
        int resultAwait = 0;

        // Act
        List<Integer> result = fib.getFibSeries();

        // Assert
        Assertions.assertTrue(result.size() != 0);
        Assertions.assertEquals(resultAwait, result.get(0));
    }

    @Test
    public void testFibWhen_Range_6_Result_Have_3_Size_6_Donthave_4_Sorted() {
        // Arrange
        int range = 6;
        Fib fib = new Fib(range);
        int no4 = 4;
        List<Integer> resultAwait = Arrays.asList(0, 1, 1, 2, 3, 5);
        int have3 = 3;
        List<Integer> resultTrierAwait = fib.getFibSeries().stream().sorted().collect(Collectors.toList());

        // Act
        List<Integer> result = fib.getFibSeries();

        // Assert
        Assertions.assertEquals(range, result.size());
        Assertions.assertTrue(result.contains(have3));
        Assertions.assertFalse(result.contains(no4));
        Assertions.assertEquals(resultAwait, result);
        Assertions.assertEquals(resultTrierAwait, result);
    }
}
