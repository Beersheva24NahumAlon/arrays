package telran.util.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.Test;
import static telran.util.Arrays.*;

public class ArraysTest {
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
        int[] expected3 = { 10, 7, 12, -4, 13, 3};
        assertArrayEquals(expected3, remove(numbers, 6));
        assertThrowsExactly(ArrayIndexOutOfBoundsException.class, () -> remove(numbers, -3));
        assertThrowsExactly(ArrayIndexOutOfBoundsException.class, () -> remove(numbers, 10));
    }
}