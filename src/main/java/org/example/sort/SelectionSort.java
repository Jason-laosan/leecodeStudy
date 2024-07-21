package org.example.sort;

import org.example.lineSearch.ArrayGenerator;
import org.example.lineSearch.SortHelper;

public class SelectionSort {
    public static void main(String[] args) {
//        Integer[] arr = {1, 4, 2, 3, 6, 5};
//        SelectionSort.sort(arr);
//        for (int i : arr) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
        int[] dataSize = {10000, 100000};
        for (int i : dataSize) {
            Integer[] a = ArrayGenerator.generatorRandomArray(i, i);
            SortHelper.sortedTest(a, "SelectionSort");
        }
    }

    /**
     * @param arr
     * @param <E> [0,i)有序 [i,n)无序
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int midIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j].compareTo(arr[midIndex]) > 0) {
                    midIndex = j;
                }
            }
            if (midIndex != i) {
                swap(arr, i, midIndex);
            }
        }

    }


    private static <E extends Comparable<E>> void swap(E[] arr, int i, int minIndex) {
        E t = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = t;
    }
}
