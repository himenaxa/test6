package pl.test.zadanie1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {
    private BinarySearch bs;
    private final int[] testArray = {1,2,3,4,5,6,7,8,9};

    @Before
    public void init(){
        bs = new BinarySearch();
    }

    @Test
    public void shouldReturn4WhenSearchingLastElement(){
        assertEquals(4, bs.countStepsInBinarySearch(testArray, 9));
    }

    @Test
    public void shouldReturn1WhenSearchingMiddleElement(){
        assertEquals(1, bs.countStepsInBinarySearch(testArray, 5));
    }
}