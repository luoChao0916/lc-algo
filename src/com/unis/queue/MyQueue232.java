package com.unis.queue;

import java.util.Deque;
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
 * 每次pop 或 peek 时，若输出栈不为空，直接返回输出栈顶数据
 * 否则将输入栈的全部数据依次弹出并压入输出栈，这样输出栈从栈顶往栈底的顺序就是队列从队首往队尾的顺序。
 */
public class MyQueue232 {

    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public MyQueue232() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (!outStack.isEmpty()) {
            return outStack.pop();
        }
        if (inStack.isEmpty()) {
            return -1;
        }
        this.in2Out();
        return outStack.pop();
    }

    public int peek() {
        if (!outStack.isEmpty()) {
            return outStack.peek();
        }
        if (inStack.isEmpty()) {
            return -1;
        }
        this.in2Out();
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2Out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}

