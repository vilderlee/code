package com.vilderlee.datastructure.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the following operations of a stack using queues.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/11      Create this file
 * </pre>
 */
public class MyStack {

    private Queue queue1 = new LinkedList<Integer>();
    private Queue queue2 = new LinkedList<Integer>();

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (queue1.isEmpty()) {
            queue1.add(x);
            for (int i = 0; i < queue2.size(); i++) {
                queue1.add(queue2.poll());
            }
        }else{
            queue2.add(x);
            for (int i = 0; i < queue1.size(); i++) {
                queue2.add(queue1.poll());
            }
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return (int) (queue1.isEmpty() ? queue2.poll() : queue1.poll());
    }

    /**
     * Get the top element.
     */
    public int top() {

        return (int) (queue1.isEmpty() ? queue2.peek() : queue1.peek());
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty()&& queue2.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        System.out.println(myStack.empty());
    }
}
