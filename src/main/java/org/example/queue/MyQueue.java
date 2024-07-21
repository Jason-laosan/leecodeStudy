package org.example.queue;


import java.util.Stack;

public class MyQueue<E> implements Queue<E> {
    private Stack<E> stack1;
    private Stack<E> stack2;
    private int size;
    private E front;

    public MyQueue() {
        this(10);
    }

    public MyQueue(int capacity) {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        size = capacity;
    }

    @Override
    public void enqueue(E o) {
        stack1.push(o);
        size++;
    }

    /**
     * remove the element from in front of queue and returns that element
     *
     * @return
     */
    @Override
    public E dequeue() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }

        while (stack1.size() > 1) {
            stack2.push(stack1.pop());
        }
        size--;
        return stack1.pop();
    }

    @Override
    public E getFront() {
        return !stack2.isEmpty() ? stack2.peek() : front;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
