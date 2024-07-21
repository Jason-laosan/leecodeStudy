package org.example.array;

public class Array<E> {
    private E[] data;
    private int size;

    /**
     * new instance array
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
    }

    /**
     * new instance array , default capacity 10
     */
    public Array() {
        this(10);
    }

    /**
     * get Array's data size
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * get array capacity
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * check if the array is empty
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * add data to end of the array
     *
     * @param value
     */
    public void addLast(E value) {
        add(size, value);
    }

    /**
     * add data to beginning of the array
     *
     * @param value
     */
    public void addFirst(E value) {
        add(0, value);
    }

    /**
     * add data to the position of the array index
     *
     * @param index
     * @param value
     */
    public void add(int index, E value) {
//        checkEmpty();
        checkIndexLegal(index, "Add");
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = value;
        size++;
    }

    private void resize(int dataLength) {
        E[] newData = (E[]) new Object[dataLength];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * delete the given index data
     *
     * @param index
     */
    public E remove(int index) {
        checkIndexLegal(index, "Remove");
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    /**
     * remove first index data , return remove data
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * remove last index data , return remove data
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * remove the given element from the array
     *
     * @param element
     */
    public void removeElement(E element) {
        int index = find(element);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * array to string
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array size = %d,capacity = %d,", this.size, this.data.length));
        sb.append(" data is : [");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * get data of the array index
     *
     * @param index
     * @return
     */
    public E get(int index) {
        checkIndexLegal(index, "Get");
        return data[index];
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    /**
     * set data of the array index
     *
     * @param index
     * @param value
     */
    public void set(int index, E value) {
        checkIndexLegal(index, "Set");
        data[index] = value;
    }

    /**
     * check to see if the given value is included
     *
     * @param value
     * @return
     */
    public boolean contains(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * find the index of the given data
     * if not contains the given data, return -1
     *
     * @param value
     * @return
     */
    public int find(E value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * check array is empty
     *
     * @throws IllegalArgumentException
     */
    private void checkEmpty() throws IllegalArgumentException {
        if (size == data.length) {
            throw new IllegalArgumentException("Add failed, Array is full");
        }
    }

    /**
     * check  the index out of array size ,throw the  {@link IllegalArgumentException}
     *
     * @param index
     * @param cause
     * @throws IllegalArgumentException
     */

    private void checkIndexLegal(int index, String cause) throws IllegalArgumentException {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException(cause + " failed, Required index < 0 or index > " + data.length);
        }
    }
}
