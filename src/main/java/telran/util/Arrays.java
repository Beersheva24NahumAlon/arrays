package telran.util;

import java.util.Comparator;

public class Arrays {
    public static int search(int[] ar, int key) {
        int index = 0;
        while (index < ar.length && key != ar[index]) {
            index++;
        }
        return index == ar.length ? -1 : index;
    }

    public static int[] add(int[] ar, int number) {
        int[] res = java.util.Arrays.copyOf(ar, ar.length + 1);
        res[ar.length] = number;
        return res;
    }

    /**
     * 
     * @param ar
     * @param index
     * @param number
     * @return reference to a new array containing @param number at @param index
     */
    public static int[] insert(int[] ar, int index, int number) {
        int[] arrayResult = new int[ar.length + 1];
        System.arraycopy(ar, 0, arrayResult, 0, index);
        arrayResult[index] = number;
        System.arraycopy(ar, index, arrayResult, index + 1, ar.length - index);
        return arrayResult;
    }

    /**
     * 
     * @param numbers
     * @param index
     * @return new array with no removed from @param numbers number at @param index
     */
    public static int[] remove(int[] numbers, int index) {
        int[] arrayResult = new int[numbers.length - 1];
        System.arraycopy(numbers, 0, arrayResult, 0, index);
        System.arraycopy(numbers, index + 1, arrayResult, index, numbers.length - index - 1);
        return arrayResult;
    }

    public static boolean pushMaxAtEnd(int[] ar, int len) {
        boolean res = false;
        for (int i = 0; i < len; i++) {
            if (ar[i] > ar[i + 1]) {
                swap(ar, i, i + 1);
                res = true;
            }
        }
        return res;
    }

    public static void swap(int[] ar, int firstIndex, int secondIndex) {
        int tmp = ar[firstIndex];
        ar[firstIndex] = ar[secondIndex];
        ar[secondIndex] = tmp;
    }

    public static void sort(int[] ar) {
        boolean flSorted = false;
        int len = ar.length;
        while (!flSorted) {
            len--;
            flSorted = !pushMaxAtEnd(ar, len);
        }
    }

    public static int binarySearch(int[] ar, int key) {
        int start = 0;
        int finish = ar.length - 1;
        int middle = (start + finish) / 2;
        while (start <= finish && ar[middle] != key) {
            if (key > ar[middle]) {
                start = middle + 1;
            } else {
                finish = middle - 1;
            }
            middle = (start + finish) / 2;
        }
        return start <= finish ? middle : -start - 1;
    }

    public static int[] insertSorted(int[] arSorted, int number) {
        int insertionIndex = binarySearch(arSorted, number);
        if (insertionIndex < 0) {
            insertionIndex = -insertionIndex - 1;
        }
        return insert(arSorted, insertionIndex, number);
    }

    public static boolean isOneSwap(int[] array) {
        int firstElenemt = getFirstElement(array);
        int secondElement = getSecondElement(array);
        return checkOneSwap(array, firstElenemt, secondElement);
    }

    private static int getSecondElement(int[] array) {
        int i = array.length - 1;
        while (i > 1 && array[i] > array[i - 1]) {
            i--;
        }
        return i;
    }

    private static int getFirstElement(int[] array) {
        int i = 0;
        while (i < array.length - 1 && array[i] <= array[i + 1]) {
            i++;
        }
        return i;
    }

    private static boolean checkOneSwap(int[] array, int i, int j) {
        boolean res;
        if (i > array.length || j < 0) {
            res = false;
        } else {
            swap(array, i, j);
            res = isSorted(array);
            swap(array, i, j);
        }
        return res;
    }

    private static boolean isSorted(int[] ar) {
        int i = 0;
        while (i < ar.length - 1 && ar[i] <= ar[i + 1]) {
            i++;
        }
        return i == ar.length - 1;
    }

    public static <T> void sort(T[] array, Comparator<T> comparator) {
        int length = array.length;
        boolean flSort = false;
        do {
            length--;
            flSort = true;
            for (int i = 0; i < length; i++) {
                if (comparator.compare(array[i], array[i + 1]) > 0) {
                    swap(array, i, i + 1);
                    flSort = false;
                }
            }
        } while (!flSort);
    }

    private static <T> void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static <T> int binarySearch(T[] array, T key, Comparator<T> comparator) {
        int start = 0;
        int finish = array.length - 1;
        int middle = (start + finish) / 2;
        while (start <= finish && comparator.compare(array[middle], key) != 0) {
            if (comparator.compare(array[middle], key) < 0) {
                start = middle + 1;
            } else {
                finish = middle - 1;
            }
            middle = (start + finish) / 2;
        }
        return start <= finish ? middle : -start - 1;
    }
}