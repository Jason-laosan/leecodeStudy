package org.example.queue;

public class LoopQueueWithoutSizeMain {
    public static void main(String[] args) {
        LoopQueueWithoutSize<Object> queue = new LoopQueueWithoutSize<>(5);
        for (int i = 0; i < 6; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }
        queue.dequeue();
        queue.dequeue();
        for (int i = 0; i < 6; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }
    }
}
