package org.example.linked;

public class LinkedListRTest {
    public static void main(String[] args) {
//        LinkedListR2<Integer> list = new LinkedListR2();
        LinkedListR<Integer> list = new LinkedListR();
        for (int i = 0; i < 5; i++) {
            list.addFirst(i);
        }
        System.out.println(list);
        list.removeElement(1);
        System.out.println(list);
    }
}
