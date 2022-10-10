package pl.test.zadanie1;

/*
dana jest metoda int countStepsInBinarySearch(int[] array, int element)
ktora policzy w ilu porownaniach zostanei znaleziony element w array,
array przyjmij ze jest zawsze posortowany nie malejąco.
 */

public class BinarySearch {
    public int countStepsInBinarySearch(int[] array, int element) {
        int first = 0;
        int last = array.length - 1;
        int mid = (first + last) / 2;
        int steps = 0;

        while (first <= last) {
            steps++;
            if (array[mid] < element) {
                first = mid + 1;
            } else if (array[mid] == element) {
                break;
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        if (last < first) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return steps;
    }

}
