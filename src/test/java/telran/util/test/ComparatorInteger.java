package telran.util.test;

import java.util.Comparator;

public class ComparatorInteger implements Comparator<Integer> {
    @Override
    public int compare(Integer arg0, Integer arg1) {
        return arg0 - arg1;
    }
}
