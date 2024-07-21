package org.example.queue;

/**
 * double end queue
 *
 * @param <E>
 */
public class Deque<E> {
    private E[] data;
    private int front, tail, size;

    public Deque(int capacity) {
        data = (E[]) new Object[capacity];
        this.front = 0;
        this.tail = 0;
        size = 0;
    }

    public Deque() {
        this(10);
    }

    public void addFront(E e) {
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }
        front = front == 0 ? data.length - 1 : front - 1;
        data[front] = e;
        size++;

    }

    public void addLast(E e) {
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }
        data[tail + 1] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can't get from the empty queue");
        }
        return data[front];
    }

    public E getLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can't get from the empty queue");
        }
        return data[tail];
    }

    public E removeFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can't remove from the empty queue");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % getCapacity();
        size--;
        if (getSize() == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can't remove from the empty queue");
        }
        // 计算删除掉队尾元素以后，新的 tail 位置
        tail = tail == 0 ? getCapacity() - 1 : tail - 1;
        E ret = data[tail];
        size--;
        if (getSize() == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getCapacity() {
        return data.length;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", getSize(), getCapacity()));
        res.append("front [");
        for (int i = 0; i < size; i++) {
            res.append(data[(i + front) % data.length]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}
