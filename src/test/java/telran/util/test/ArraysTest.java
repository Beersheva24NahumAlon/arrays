package telran.util.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import static telran.util.Arrays.*;

import java.util.Random;

public class ArraysTest {
    private static final int N_ELEMENTS = 1_000;
    int[] numbers = { 10, 7, 12, -4, 13, 3, 14 };

    @Test
    void searchTest() {
        assertEquals(0, search(numbers, 10));
        assertEquals(3, search(numbers, -4));
        assertEquals(6, search(numbers, 14));
        assertEquals(-1, search(numbers, 100));
    }

    @Test
    void addTest() {
        int[] expected = { 10, 7, 12, -4, 13, 3, 14, 100 };
        assertArrayEquals(expected, add(numbers, 100));
    }

    @Test
    void insertTest() {
        int[] expected1 = { 10, 7, 12, 4, -4, 13, 3, 14 };
        assertArrayEquals(expected1, insert(numbers, 3, 4));
        int[] expected2 = { 4, 10, 7, 12, -4, 13, 3, 14 };
        assertArrayEquals(expected2, insert(numbers, 0, 4));
        int[] expected3 = { 10, 7, 12, -4, 13, 3, 14, 4 };
        assertArrayEquals(expected3, insert(numbers, 7, 4));
        assertThrowsExactly(ArrayIndexOutOfBoundsException.class, () -> insert(numbers, -3, 4));
        assertThrowsExactly(ArrayIndexOutOfBoundsException.class, () -> insert(numbers, 10, 4));
    }

    @Test
    void removeTest() {
        int[] expected1 = { 10, 7, 12, 13, 3, 14 };
        assertArrayEquals(expected1, remove(numbers, 3));
        int[] expected2 = { 7, 12, -4, 13, 3, 14 };
        assertArrayEquals(expected2, remove(numbers, 0));
        int[] expected3 = { 10, 7, 12, -4, 13, 3 };
        assertArrayEquals(expected3, remove(numbers, 6));
        assertThrowsExactly(ArrayIndexOutOfBoundsException.class, () -> remove(numbers, -3));
        assertThrowsExactly(ArrayIndexOutOfBoundsException.class, () -> remove(numbers, 10));
    }

    @Test
    void swapTest() {
        int[] expected = { 10, 7, 12, 13, -4, 3, 14 };
        swap(numbers, 3, 4);
        assertArrayEquals(expected, numbers);
    }

    @Test
    void pushMaxAtEndTest() {
        int[] numbers1 = { 10, 7, 15, -4, 13, 3, 14 };
        pushMaxAtEnd(numbers1, 7);
        assertEquals(15, numbers1[numbers1.length - 1]);
        numbers1 = new int[] { 20, -10, 10, -17 };
        pushMaxAtEnd(numbers1, 4);
        assertEquals(20, numbers1[numbers1.length - 1]);
    }

    @Test
    void sortTest() {
        int[] numbers1 = { 10, 7, 15, -4, 13, 3, 14 };
        int[] expected = { -4, 3, 7, 10, 13, 14, 15 };
        sort(numbers1);
        assertArrayEquals(expected, numbers1);
    }

    @Test
    void sortTestRandomArray() {
        int[] array = getRandomArray(N_ELEMENTS);
        int limit = array.length - 1;
        sort(array);
        for (int i = 0; i < limit; i++) {
            assertTrue(array[i] <= array[i + 1]);
        }
    }

    private int[] getRandomArray(int nElements) {
        int[] res = new int[nElements];
        Random random = new Random();
        for (int i = 0; i < nElements; i++) {
            res[i] = random.nextInt();
        }
        return res;
    }
    @Test
    void binarySearchTest() {
        int[] sortedArray = { -4, 3, 7, 10, 13, 14, 15 };
        assertEquals(2, binarySearch(sortedArray, 7));
        assertEquals(5, binarySearch(sortedArray, 14));
        assertEquals(3, binarySearch(sortedArray, 10));
        assertEquals(0, binarySearch(sortedArray, -4));
        assertEquals(6, binarySearch(sortedArray, 15));
        assertEquals(-1, binarySearch(sortedArray, 12));
    }    
}