package com.unis.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author luochao
 * @desc (设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈)
 * @date 2023/2/8
 */
public class MinStack155 {

    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack155() {
        xStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        xStack.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
