package org.example.array;

public class ArrayMain {
    public static void main(String[] args) {
        Array<Integer> array = new Array(2);
        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        array.addLast(4);
        array.addFirst(0);
//        System.out.println(array);
//        System.out.println(array.contains(1));
//        System.out.println(array.remove(1));
//        System.out.println(array);
//        System.out.println(array.removeLast());
//        System.out.println(array);
        array.removeElement(5);
        System.out.println(array);

    }
}
