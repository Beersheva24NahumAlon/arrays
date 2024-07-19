package telran.util.test;

import java.util.Comparator;

public class EvenOddComporator implements Comparator<Integer> {

    @Override
    public int compare(Integer arg0, Integer arg1) {
        int res = 1;
        boolean isEvenArg0 = arg0 % 2 == 0;
        boolean isEvenArg1 = arg1 % 2 == 0;
        if (isEvenArg0 && isEvenArg1) {
            res = arg0 - arg1;
        } else if (!isEvenArg0 && !isEvenArg1) {
            res = arg1 - arg0;
        } else if (isEvenArg0 && !isEvenArg1) {
            res = -1;
        }
        return res;
    }
}
