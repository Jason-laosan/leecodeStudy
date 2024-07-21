package org.example.lineSearch;

import java.util.Random;

public class ArrayGenerator {
    private ArrayGenerator() {
    }

    public static Integer[] generatorOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static Integer[] generatorRandomArray(int n, int bound) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            Random r = new Random();
            arr[i] = r.nextInt(bound);
        }
        return arr;
    }
}
