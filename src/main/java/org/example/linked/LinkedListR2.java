package org.example.linked;

public class LinkedListR2<E> {

    //linked list using recursion
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedListR2() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed.Index illegal.");
        }
        head = add(head, e, index);
        size++;
    }

    private Node add(Node node, E e, int index) {
        if (index == 0) {
            return new Node(e, node);
        }
        node.next = add(node.next, e, index - 1);
        return node;
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed.Index illegal.");
        }
        return get(head, index);
    }

    private E get(Node node, int index) {
        if (index == 0) {
            return node.e;
        }
        return get(node.next, index - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed.Index illegal.");
        }
        set(head, index, e);
    }

    private void set(Node node, int index, E e) {
        if (index == 0) {
            node.e = e;
            return;
        }
        set(node.next, index - 1, e);
    }

    public boolean contains(E e) {
        return contains(head, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (node.e.equals(e)) {
            return true;
        }
        return contains(node.next, e);
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed.Index illegal.");
        }
        return remove(head, index);
    }

    private E remove(Node node, int index) {
        if (node == null) {
            return null;
        }
        if (index == 1 && node.next != null) {
            node.next = node.next.next;
            return node.next.e;
        }
        return remove(node.next, index - 1);
    }

    public E remove(E e) {
        return remove(head, e).e;
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        node.next = remove(node.next, e);
        if (node.e.equals(e)) {
            size--;
            return node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Node curr = head; curr != null; curr = curr.next) {
            res.append(curr + "->");
        }
        res.append("NULL");
        return res.toString();
    }
}
