package org.example.lineSearch;

import org.example.sort.InsertionSort;
import org.example.sort.SelectionSort;

public class SortHelper {
    private SortHelper() {
    }

    public static <E extends Comparable<E>> boolean isSorted(E[] es) {
        for (int i = 1; i < es.length; i++) {
            if (es[i - 1].compareTo(es[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortedTest(E[] e, String sortName) {
        long start = System.nanoTime();
        if (sortName.equals("SelectionSort")) {
            SelectionSort.sort(e);
        } else if (sortName.equals("InsertionSort")) {
            InsertionSort.sort2(e);
        }
        long end = System.nanoTime();
        double time = (end - start) / 1_000_000_000.0;
        if (!isSorted(e)) {
            throw new RuntimeException(sortName + "failed");
        }
        System.out.println(String.format("%s, n = %d, %f s", sortName, e.length, time));

    }
}
