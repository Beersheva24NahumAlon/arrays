package telran.util;

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
        int middle;
        boolean isFound = false;
        do {
            middle = start + (finish - start) / 2;
            if (ar[middle] == key) {
                isFound = true;
                break;
            } else if (ar[middle] < key) {
                start = middle + 1;
            } else {
                finish = middle - 1;
            }
        } while (start <= finish);
        return isFound ? middle : -start - 1;
    }

    public static int[] insertSorted(int[] arSorted, int number) {
        int[] arInserted = java.util.Arrays.copyOf(arSorted, arSorted.length);
        return insert(arInserted, -binarySearch(arInserted, number) - 1, number);
    }

    public static boolean isOneSwap(int[] array) {
        boolean res = false;
        for (int i = 0; i < array.length; i++) {
            if (res) {
                break;
            }
            for (int j = i + 1; j < array.length; j++) {
                swap(array, i, j);
                if (isSorted(array)) {
                    res = true;
                    swap(array, i, j);
                    break;
                }
                swap(array, i, j);
            }
        }
        return res;
    }

    public static boolean isSorted(int[] ar) {
        boolean res = true;
        for (int i = 0; i < ar.length - 1; i++) {
            if (ar[i] > ar[i + 1]) {
                res = false;
            }
        }
        return res;
    }
}