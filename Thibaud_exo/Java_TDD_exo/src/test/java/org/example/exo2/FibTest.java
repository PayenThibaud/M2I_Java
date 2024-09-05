package org.example.exo2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class FibTest {

    private Fib fib;

    @Test
    public void testFibWhen_Range_1_Result_NotVoid() {
        // Arrange
        int range = 1;
        fib = new Fib(range);

        // Act
        List<Integer> result = fib.getFibSeries();

        // Assert
        Assertions.assertTrue(result.size() != 0);
    }

    @Test
    public void testFibWhen_Range_1_Result_0() {
        // Arrange
        int range = 1;
        fib = new Fib(range);
        int resultAwait = 0;

        // Act
        List<Integer> result = fib.getFibSeries();

        // Assert

        Assertions.assertEquals(resultAwait, result.get(0));
    }

    @Test
    public void testFibWhen_Range_6_Result_Size_6() {
        // Arrange
        int range = 6;
        Fib fib = new Fib(range);

        // Act
        List<Integer> result = fib.getFibSeries();

        // Assert
        Assertions.assertEquals(range, result.size());
    }

    @Test
    public void testFibWhen_Range_6_Result_Have_3() {
        // Arrange
        int range = 6;
        Fib fib = new Fib(range);
        int have3 = 3;

        // Act
        List<Integer> result = fib.getFibSeries();

        // Assert
        Assertions.assertTrue(result.contains(have3));
    }

    @Test
    public void testFibWhen_Range_6_Result_Donthave_4() {
        // Arrange
        int range = 6;
        Fib fib = new Fib(range);
        int no4 = 4;

        // Act
        List<Integer> result = fib.getFibSeries();

        // Assert
        Assertions.assertFalse(result.contains(no4));
    }

    @Test
    public void testFibWhen_Range_6_Result_Sorted() {
        // Arrange
        int range = 6;
        Fib fib = new Fib(range);
        List<Integer> resultTrierAwait = fib.getFibSeries().stream().sorted().collect(Collectors.toList());

        // Act
        List<Integer> result = fib.getFibSeries();

        // Assert
        Assertions.assertEquals(resultTrierAwait, result);
    }

    @Test
    public void testFibWhen_Range_6_Result_HaveList_0_1_1_2_3_5() {
        // Arrange
        int range = 6;
        Fib fib = new Fib(range);
        List<Integer> resultAwait = Arrays.asList(0, 1, 1, 2, 3, 5);

        // Act
        List<Integer> result = fib.getFibSeries();

        // Assert
        Assertions.assertEquals(resultAwait, result);
    }
}
