package org.example.queue;

public class LinkedListQueueTest {
    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }
        Integer dequeue = queue.dequeue();
        System.out.println(dequeue);
        System.out.println(queue);

    }
}
