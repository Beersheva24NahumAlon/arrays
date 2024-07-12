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
        int res = -1;
        int start = -1;
        int finish = ar.length;
        int middle;
        //{ -4, 3, 7, 10, 13, 14, 15 }
        while (start < finish -1) {
            middle = (start + finish) / 2;
            if (ar[middle] < key) {
                start = middle;
            } else {
                finish = middle;
            }
        }
        return ar[finish] == key ? finish : -1;
    }

    public static int[] insertSorted(int[] arSorted, int number) {
        // TODO
        return null;
    }

    public static boolean isOneSwap(int[] array) {
        // TODO
        return false;
    }
}