package pl.test.zadanie1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {
    private BinarySearch bs;
    private final int[] testOddArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private final int[] testEvenArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private final int[] testEmptyArray = {};

    @Before
    public void init() {
        bs = new BinarySearch();
    }

    @Test
    public void shouldReturn4WhenSearchingLastElementInOddArray() {
        assertEquals(4, bs.countStepsInBinarySearch(testOddArray, 9));

    }
    @Test
    public void shouldReturn3WhenSearchingFirstElementInOddArray() {
        assertEquals(3, bs.countStepsInBinarySearch(testOddArray, 1));
    }

    @Test
    public void shouldReturn4WhenSearchingLastElementInEvenArray() {
        assertEquals(4, bs.countStepsInBinarySearch(testEvenArray, 10));
    }
    @Test
    public void shouldReturn3WhenSearchingFirstElementInEvenArray() {
        assertEquals(3, bs.countStepsInBinarySearch(testEvenArray, 1));
    }


    @Test
    public void shouldReturn1WhenSearchingMiddleElementInOddArray() {
        assertEquals(1, bs.countStepsInBinarySearch(testOddArray, 5));
    }

    @Test
    public void shouldReturn1WhenSearchingFirstMiddleElementInEvenArray() {
        assertEquals(1, bs.countStepsInBinarySearch(testEvenArray, 5));
    }

    @Test
    public void shouldReturn3WhenSearchingSecondMiddleElementInEvenArray() {
        assertEquals(3, bs.countStepsInBinarySearch(testEvenArray, 6));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void shouldThrowArrayIndexOutOfBoundsExceptionWhenArrayIsEmpty() {
        assertEquals(1, bs.countStepsInBinarySearch(testEmptyArray, 0));
    }
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void shouldThrowArrayIndexOutOfBoundsExceptionWhenElementIsOutOfBoundsMaxInterval() {
        assertEquals(1, bs.countStepsInBinarySearch(testOddArray, 1000));
    }
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void shouldThrowArrayIndexOutOfBoundsExceptionWhenElementIsOutOfBoundsMinInterval() {
        assertEquals(1, bs.countStepsInBinarySearch(testOddArray, 0));
    }


}