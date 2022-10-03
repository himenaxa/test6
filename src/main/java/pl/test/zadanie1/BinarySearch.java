package pl.test.zadanie1;


/*
dana jest metoda int countStepsInBinarySearch(int[] array, int element)
ktora policzy w ilu porownaniach zostanei znaleziony element w array,
array przyjmij ze jest zawsze posortowany nie malejąco.
 */

import java.util.Arrays;

public class BinarySearch {
    private int steps = 1;
    public int countStepsInBinarySearch(int[] array, int element) {
        int middle = (array.length / 2);
        if (array[middle] == element) {
            int temp = steps;
            steps = 1;
            return temp;
        } else if (element > array[middle]) {
            steps++;
            return countStepsInBinarySearch(Arrays.copyOfRange(array, middle, array.length), element);
        } else {
            steps++;
            return countStepsInBinarySearch(Arrays.copyOfRange(array, 0, middle), element);
        }
    }
}
