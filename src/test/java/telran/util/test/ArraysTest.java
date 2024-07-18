package telran.util.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;

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
        int[] sortedArray = { -4, 3, 7, 10, 13, 14, 16 };
        assertEquals(2, binarySearch(sortedArray, 7));
        assertEquals(6, binarySearch(sortedArray, 16));
        assertEquals(3, binarySearch(sortedArray, 10));
        assertEquals(0, binarySearch(sortedArray, -4));
        assertEquals(-7, binarySearch(sortedArray, 15));
        assertEquals(-5, binarySearch(sortedArray, 12));
        assertEquals(-4, binarySearch(sortedArray, 8));
        assertEquals(-1, binarySearch(sortedArray, -8));
        assertEquals(-8, binarySearch(sortedArray, 20));
    }

    @Test
    void insertSortedTest() {
        int[] sortedArray = { -4, 3, 7, 10, 13, 14, 16 };
        int[] resArray1 = { -8, -4, 3, 7, 10, 13, 14, 16 };
        int[] resArray2 = { -4, 3, 7, 10, 12, 13, 14, 16 };
        int[] resArray3 = { -4, 3, 7, 10, 13, 14, 16, 19 };
        int[] resArray4 = { -4, 3, 7, 10, 13, 14, 16, 16 };
        int[] resArray5 = { -4, -4, 3, 7, 10, 13, 14, 16 };
        int[] resArray6 = { -4, 3, 7, 10, 10, 13, 14, 16 };
        assertArrayEquals(resArray1, insertSorted(sortedArray, -8));
        assertArrayEquals(resArray2, insertSorted(sortedArray, 12));
        assertArrayEquals(resArray3, insertSorted(sortedArray, 19));
        assertArrayEquals(resArray4, insertSorted(sortedArray, 16));
        assertArrayEquals(resArray5, insertSorted(sortedArray, -4));
        assertArrayEquals(resArray6, insertSorted(sortedArray, 10));
    }

    @Test
    void isOneSwapTest() {
        int[] testArrayTrue1 = { 16, -4, 3, 7, 10, 13, 14, -8 };
        int[] testArrayTrue2 = { 12, 3, 7, 10, -4, 13, 14, 16 };
        int[] testArrayTrue3 = { -4, 3, 7, 10, 19, 14, 16, 13 };
        int[] testArrayFalse1 = { 16, -4, 3, 10, 7, 13, 14, -8 };
        int[] testArrayFalse2 = { 10, 7, 15, -4, 13, 3, 14 };
        int[] testArrayFalse3 = { -4, 3, 7, 10, 13, 14, 16 };
        assertEquals(true, isOneSwap(testArrayTrue1));
        assertEquals(true, isOneSwap(testArrayTrue2));
        assertEquals(true, isOneSwap(testArrayTrue3));
        assertEquals(false, isOneSwap(testArrayFalse1));
        assertEquals(false, isOneSwap(testArrayFalse2));
        assertEquals(false, isOneSwap(testArrayFalse3));
    }

    @Test
    void sortAnyTypeTest() {
        String[] strings = { "lmn", "cfta", "w", "aa" };
        String[] expectedASCII = { "aa", "cfta", "lmn", "w" };
        String[] expectedLengths = { "w", "aa", "lmn", "cfta" };
        sort(strings, new ComparatorASCII());
        assertArrayEquals(expectedASCII, strings);
        sort(strings, new ComparatorLengths());
        assertArrayEquals(expectedLengths, strings);
    }

    @Test
    void binarySearchAnyTypeTest() {
        String[] stringsASCII = { "aa", "cfta", "lmn", "w" };
        String[] stringsLengths = { "w", "aa", "lmn", "cftaa" };
        Integer[] integers = { 10, 20, 30, 40, 50 };
        assertEquals(0, binarySearch(stringsASCII, "aa", new ComparatorASCII()));
        assertEquals(1, binarySearch(stringsASCII, "cfta", new ComparatorASCII()));
        assertEquals(3, binarySearch(stringsASCII, "w", new ComparatorASCII()));
        assertEquals(-4, binarySearch(stringsASCII, "opt", new ComparatorASCII()));
        assertEquals(-5, binarySearch(stringsASCII, "www", new ComparatorASCII()));
        assertEquals(0, binarySearch(stringsLengths, "w", new ComparatorLengths()));
        assertEquals(1, binarySearch(stringsLengths, "aa", new ComparatorLengths()));
        assertEquals(2, binarySearch(stringsLengths, "www", new ComparatorLengths()));
        assertEquals(3, binarySearch(stringsLengths, "cftaa", new ComparatorLengths()));
        assertEquals(-4, binarySearch(stringsLengths, "opti", new ComparatorLengths()));
        assertEquals(-5, binarySearch(stringsLengths, "wwwwww", new ComparatorLengths()));
        assertEquals(0, binarySearch(integers, 10, new ComparatorInteger()));
        assertEquals(2, binarySearch(integers, 30, new ComparatorInteger()));
        assertEquals(4, binarySearch(integers, 50, new ComparatorInteger()));
        assertEquals(-6, binarySearch(integers, 55, new ComparatorInteger()));
        assertEquals(-2, binarySearch(integers, 15, new ComparatorInteger()));
    }

    @Test
    void binarySearchNoComparator() {
        String[] strings = { "aa", "cfta", "lmn", "w" };
        Person prs1 = new Person(10, "Vasya");
        Person prs2 = new Person(20, "Itay");
        Person prs3 = new Person(30, "Sara");
        Person[] persons = { prs1, prs2, prs3 };
        assertEquals(1, binarySearch(strings, "cfta"));
        assertEquals(0, binarySearch(persons, prs1));
        assertEquals(2, binarySearch(persons, new Person(30, "null")));
        assertEquals(-3, binarySearch(persons, new Person(25, "null")));
    }

    @Test
    void evenOddSortingTest() {
        Integer[] array = { 7, -8, 10, -100, 13, -10, 99 };
        Integer[] expected = { -100, -10, -8, 10, 99, 13, 7 };
        sort(array, new EvenOddComporator());
        assertArrayEquals(expected, array);
    }

    @Test
    void findTest() {
        Integer[] array = { 7, -8, 10, -100, 13, -10, 99 };
        Integer[] expected = { 7, 13, 99 };
        assertArrayEquals(expected, find(array, new OddNumbersPredicate()));
    }    
}