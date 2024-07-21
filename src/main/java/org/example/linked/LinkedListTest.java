package org.example.linked;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<Integer>();

        for (int i = 0; i < 5; i++) {
            l.addFirst(i);
            System.out.println(l);
        }
        l.add(2, 333);
        System.out.println(l);
    }
}
