package org.example.lineSearch;

public class LinearSearch {
    private LinearSearch() {
    }

    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        Student[] students = {
//                new Student(1, "1", 1),
//                new Student(2, "2", 2),
//                new Student(3, "3", 3),
//        };
//        Student s = new Student(1, "1", 1);
//        System.out.println(search(students, s));
        int n = 10000_000;
        Integer[] integers = ArrayGenerator.generatorOrderedArray(n);
        long start = System.nanoTime();
        LinearSearch.search(integers, n);
        long end = System.nanoTime();
        System.out.println((end - start) / 1000_000_000.0 + "s");
    }

}
