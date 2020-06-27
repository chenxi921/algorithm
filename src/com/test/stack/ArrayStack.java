package com.test.stack;

import com.test.array.Array;

public class ArrayStack<E> implements Stack<E> {
    Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 插入一个元素
     *
     * @param e
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    /***
     * 取出最后一个元素
     * @return
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * 查看栈顶元素（最后一个元素）
     *
     * @return
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "array=" + array +
                "} top";
    }
}
