package org.example.sort;

import org.example.lineSearch.ArrayGenerator;

import java.util.Arrays;

public class MergeSortTest {
    public static void main(String[] args) {

        Integer[] a = ArrayGenerator.generatorRandomArray(11, 100);
        Arrays.stream(a).forEach(v -> {
            System.out.print(v + ",");
        });
        System.out.println("\r\n==============");
        MergeSort.mergeSort2(a);
        Arrays.stream(a).forEach(v -> {
            System.out.print(v + ",");
        });
    }
}
