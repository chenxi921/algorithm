package com.test.queue;

import com.test.linked.LinkedList;

public class LinkedListQueue<E> implements Queue<E> {

    private class Node {
        /**
         * 节点数据
         */
        public E e;
        /**
         * 下一个节点
         */
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

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    /**
     * 出队
     *
     * @return
     */
    @Override
    public E dequeue() {
        if (size == 0) {
            throw new IllegalArgumentException("queue is empty");
        }
        Node deleteNode = head;
        head = head.next;
        deleteNode.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return deleteNode.e;
    }

    @Override
    public E getFront() {
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = head;
        while (cur != null) {
            sb.append(cur.e + "-->");
            cur = cur.next;
        }
        sb.append("NULL");
        sb.append(" head:" + head.e);
        sb.append(" tail:" + tail.e);
        return sb.toString();
    }
}
