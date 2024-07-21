package org.example.sort;

import org.example.lineSearch.ArrayGenerator;
import org.example.lineSearch.SortHelper;

public class InsertionSort {
    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for (int i : dataSize) {
            Integer[] a = ArrayGenerator.generatorRandomArray(i, i);
            SortHelper.sortedTest(a, "InsertionSort");
        }
    }

    private InsertionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //arr[i] 插入至合适位置
            for (int j = i; j >= 1 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] arr, int l, int r) {
        for (int i = l; i < l; i++) {
            //arr[i] 插入至合适位置
            for (int j = i; j >= 1 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            E t = arr[i];
            int j;
            for (j = i; j >= 1 && t.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }

    public static <E extends Comparable<E>> void sort3(E[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            E t = arr[i];
            int j;
            for (j = i; j < arr.length - 1 && t.compareTo(arr[j + 1]) > 0; j++) {
                arr[j] = arr[j + 1];
            }
            arr[j] = t;
        }
    }

    public static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E e = arr[i];
        arr[i] = arr[j];
        arr[j] = e;
    }
}
