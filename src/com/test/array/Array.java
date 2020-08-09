package com.test.array;

import java.util.Arrays;

public class Array<E> {
    private E[] data;
    private int size;

    /**
     * 初始化数组容量
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.data.length;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    /***
     * 向数组末尾添加元素
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }
    //0 111 1 2 3 4 5 6 7 8

    /***
     * 向指定位置添加元素
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("add faild ,index<0 || index>size.");

        if (this.data.length == size) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("add faild ,index<0 || index>size.");
        return this.data[index];
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("add faild ,index<0 || index>size.");
        data[index] = e;
    }

    /**
     * 查找数组中是否存在某个元素
     *
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 移除索引位置的元素
     *
     * @param index
     */
    //0 1 2 3 4 5 6 7 8
    //0 1 3 4 5 6 7 8
    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("remove faild ,index<0 || index>size.");
        E result = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return result;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append(']');
        res.append(String.format("Array: size = %d , capacity = %d ", size, data.length));
        return res.toString();
    }
}
