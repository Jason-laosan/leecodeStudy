package org.example.linked;

public class LinkedListR<E> {
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

    public LinkedListR() {
        this.head = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 在链表的index(0-based)位置添加新的元素e
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        head = add(head, index, e);
        size++;
    }

    // 在以node为头结点的链表的index位置插入元素e，递归算法
    private Node add(Node node, int index, E e) {

        if (index == 0) {
            return new Node(e, node);
        }

        node.next = add(node.next, index - 1, e);
        return node;
    }

    // 在链表头添加新的元素e
    public void addFirst(E e) {
        add(0, e);
    }

    // 在链表末尾添加新的元素e
    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed, Illegal index");
        }
        return get(head, index);
    }

    private E get(Node node, int index) {
        if (index == 0) {
            return node.e;
        }
        return get(node.next, index - 1);
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed, Illegal index");
        }
        set(head, e, index);
    }

    private void set(Node node, E e, int index) {
        if (index == 0) {
            node.e = e;
            return;
        }
        set(node.next, e, index - 1);
    }

    public boolean contains(E e) {
        return contains(head, e);
    }

    public boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (node.e == e) {
            return true;
        }
        return contains(node.next, e);
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed, Illegal index");
        }
        if (index == 0) {
            return removeFirst();
        }
        return remove(head, index).e;
    }

    public E removeFirst() {
        if (head == null) {
            return null;
        }
        head = head.next;
        size--;
        return head.e;
    }

    public E removeLast() {
        return remove(head, size - 1).e;
    }

    private Node remove(Node node, int index) {
        if (node == null) {
            return null;
        }
        if (index == 1 && node.next != null) {
            node.next = node.next.next;
            size--;
            return node;
        }
        return remove(node.next, index - 1);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("LinedListR head ");
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
            sb.append(cur).append("=>");
        }
        sb.append(" NULL ");
        return sb.toString();
    }

    public void removeElement(E e) {
        head = removeElement(head, e);
    }

    private Node removeElement(Node node, E e) {
        if (node == null) {
            return null;
        }
        node.next = removeElement(node.next, e);
        if (node.e.equals(e)) {
            size--;
            return node.next;
        }
        return node;
    }
}
