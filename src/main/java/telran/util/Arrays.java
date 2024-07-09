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
}