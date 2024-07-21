package org.example.linked;

public class LinkedList<E> {
    private Node<E> dummyHead;
    private int size;

    private class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public LinkedList() {
        this.dummyHead = new Node<>(null, null);
        this.size = 0;
    }

    public void addFirst(E e) {
//        Node<E> node = new Node<>(e);
//        node.next = head;
//        head = node;
//        head = new Node<>(e, head);
        add(0, e);
        size++;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, Illegal index");
        }
        Node<E> pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
//            Node<E> node = new Node<>(e);
//            node.next = pre.next;
//            pre.next = node;
        pre.next = new Node<>(e, pre.next);
        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed, Illegal index");
        }
        Node<E> cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.data;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size);
    }

    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed, Illegal index");
        }
        Node<E> cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.data = e;
    }

    public boolean contains(E e) {
//        Node<E> cur = dummyHead.next;
//        one method
//        while (cur != null) {
//            if (cur.data.equals(e)) {
//                return true;
//            }
//            cur = cur.next;
//        }
//        return false;

//        two method
//        for (int i = 0; i < size; i++) {
//            if (cur.next.data.equals(e)) {
//                return true;
//            }
//            cur = cur.next;
//        }

//        no size and loop
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            if (cur.data.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed, Illegal index");
        }
        Node<E> pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node<E> returnNode = pre.next;
        pre.next = returnNode.next;
        returnNode.next = null;
        size--;
        return returnNode.data;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node<E> cur = dummyHead.next;
        while (cur != null) {
            sb.append(cur.data + " -> ");
            cur = cur.next;
        }
        sb.append(" NULL");
        return sb.toString();
    }
}
