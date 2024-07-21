package org.example.stack;

/**
 * FILO
 * @param <E>
 */
public interface Stack<E> {
    void push(E e);

    E pop();

    E peek();

    int getSize();

    boolean isEmpty();
}
