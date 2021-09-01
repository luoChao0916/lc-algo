package com.zkwq.queue;

import java.util.LinkedList;

/**
 * @author lc
 * @desc (用两个栈实现队列)
 * @date 2021/9/1
 * 栈：先进后出
 * 队列：先进先出
 * 两个栈实现队列  一个输入栈一个输出栈
 * push：inputStack
 * pop、peek：outputStack  将所有输入栈的内容放到输出栈
 *
 * 将一个栈当作输入栈，用于压入 push 传入的数据；另一个栈当作输出栈，用于 pop 和 peek 操作。
 * 每次pop 或 peek 时，若输出栈为空则将输入栈的全部数据依次弹出并压入输出栈，这样输出栈从栈顶往栈底的顺序就是队列从队首往队尾的顺序。
 */
public class MyQueue {
    private LinkedList<Integer> inputStack;
    private LinkedList<Integer> outputStack;

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());

    }

    /** Initialize your data structure here. */
    private MyQueue() {
        inputStack = new LinkedList<>();
        outputStack = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    private void push(int x) {
        inputStack.add(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    private int pop() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.add(inputStack.removeLast());
            }
        }
        return outputStack.removeLast();
    }

    /** Get the front element. */
    private int peek() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.add(inputStack.removeLast());
            }
        }
        return outputStack.getLast();
    }

    /** Returns whether the queue is empty. */
    private boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
}

