package com.test.linked;


public class LinkedList<E> {
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

    /**
     * 虚拟头节点
     */
    private Node dummyHead;
    /**
     * 节点数
     */
    private int size;

    public LinkedList() {
        this.dummyHead = new Node(null, null);
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }


    public void add(int index, E e) {
        if (index < 0 && index > size) {
            throw new IllegalArgumentException("add faild ,index<0 || index>size.");
        }
        Node prev = this.dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//        Node node = new Node(e);
//        node.next = prev.next;
//        prev.next = node;
        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 && index > size) {
            throw new IllegalArgumentException("get faild ,index<0 || index>size.");
        }
        Node cur = this.dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 && index > size) {
            throw new IllegalArgumentException("get faild ,index<0 || index>size.");
        }
        Node cur = this.dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e) {
        Node cur = this.dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            } else {
                cur = cur.next;
            }
        }
        return false;
    }

    public Node remove(int index) {
        if (index < 0 && index > size) {
            throw new IllegalArgumentException("remove faild ,index<0 || index>size.");
        }
        Node prev = this.dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node deleteNode = prev.next;
        prev.next = deleteNode.next;
        deleteNode.next = null;
        size--;
        return deleteNode;
    }

    public Node removeFirst() {
        return remove(0);
    }

    public Node removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            sb.append(cur.e + "-->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
