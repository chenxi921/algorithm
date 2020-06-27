package com.test;

import com.test.array.Array;
import com.test.linked.LinkedList;
import com.test.linked.LinkedListStack;
import com.test.queue.ArrayQueue;
import com.test.queue.LinkedListQueue;
import com.test.queue.LoopQueue;
import com.test.queue.Queue;
import com.test.stack.ArrayStack;
import com.test.stack.Solution;
import com.test.stack.Stack;
import org.junit.Test;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int item : arr) {
            System.out.println(item);
        }
    }

    /**
     * 数组测试
     */
    @Test
    public void TestArray() {
        Array<Integer> arr = new Array<>();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);
        arr.add(2, 100);
        System.out.println(arr);
        //arr.addFirst(45);
        //System.out.println(arr);
        arr.remove(5);
        System.out.println(arr);
        arr.removeLast();
        System.out.println(arr);
    }

    /**
     * 栈测试
     */
    @Test
    public void StackTest() {
        Stack<Integer> arrayStack = new ArrayStack<>();
        for (int i = 0; i < 10; i++) {
            arrayStack.push(i);
        }
        System.out.println(arrayStack);
    }

    /**
     * 括号匹配
     */
    @Test
    public void SolutionTest() {
        Solution s = new Solution();
        System.out.println(s.isValid("()"));
        System.out.println(s.isValid("()[]{}"));
        System.out.println(s.isValid("(]"));
        System.out.println(s.isValid("([)]"));
        System.out.println(s.isValid("{[]}"));
        System.out.println(s.isValid("(])"));
    }

    /**
     * 队列测试
     */
    @Test
    public void QueueTest() {
        //ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        Queue<Integer> arrayQueue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);
            if (i % 3 == 2) {
                arrayQueue.dequeue();
                System.out.println(arrayQueue);
            }
        }
    }

    @Test
    public void PerformanceTest() {
        int opCount = 100000;
        ArrayQueue<Integer> aq = new ArrayQueue<>();
        System.out.println(testQueue(aq, opCount));
        LoopQueue<Integer> lq = new LoopQueue<>();
        System.out.println(testQueue(lq, opCount));
        return;
    }

    private double testQueue(Queue<Integer> q, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();

        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000d;
    }

    @Test
    public void LinkedTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2, 666);
        System.out.println(linkedList);
        linkedList.remove(3);
        System.out.println(linkedList);
    }

    @Test
    public void LinkedStackTest() {
        Stack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        stack.push(666);
        System.out.println(stack);
    }

    /**
     * 队列测试
     */
    @Test
    public void LinkedListQueueTest() {
        //ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        Queue<Integer> listQueue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            listQueue.enqueue(i);
            System.out.println(listQueue);
            if (i % 3 == 2) {
                listQueue.dequeue();
                System.out.println(listQueue);
            }
        }
    }
}
