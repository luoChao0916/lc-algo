package com.zkwq.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author luochao
 * @desc (给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。)
 * @date 2023/2/8
 */
public class Calculator227 {
    public static void main(String[] args) {
        System.out.println(calculate("11"));
    }

    /**
     * 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
     * 输入：s = "3+2*2"
     * 输出：7
     * 通过两个栈来实现，一个保存操作数，一个保存运算符。
     * 我们从左向右遍历表达式，当遇到数字，我们就直接压入操作数栈；
     * 当遇到运算符，就与运算符栈的栈顶元素进行比较。
     * 如果比运算符栈顶元素的优先级高，就将当前运算符压入栈；
     * 如果比运算符栈顶元素的优先级低或者相同，从运算符栈中取栈顶运算符，从操作数栈的栈顶取 2 个操作数，然后进行计算，再把计算完的结果压入操作数栈；
     * 继续和栈顶运算符比较。
     * 遍历完成之后清空栈获取结果。
     */
    public static int calculate(String s) {
        Deque<Integer> numberStack = new LinkedList<>();
        Deque<Character> symbolStack = new LinkedList<>();
        // 防止第一个数为负数
        numberStack.push(0);
        // 符号优先级映射表
        Map<Character, Integer> symbolMapping = new HashMap<>();
        symbolMapping.put('*', 2);
        symbolMapping.put('/', 2);
        symbolMapping.put('+', 1);
        symbolMapping.put('-', 1);
        char[] chars = s.toCharArray();
        // 上一个字符是否是数字
        boolean numberFlag = false;
        for (char ch : chars) {
            // 空格跳过
            if (ch == ' ') {
                numberFlag = false;
                continue;
            }
            // 遇到数字，压入操作数栈
            if (Character.isDigit(ch)) {
                if (numberFlag) {
                    // 连续两个字符是数字，需要计算再压入栈
                    numberStack.push(numberStack.pop() * 10 + Integer.parseInt("" + ch));
                } else {
                    numberStack.push(Integer.valueOf("" + ch));
                }
                numberFlag = true;
                continue;
            }
            numberFlag = false;
            while (!symbolStack.isEmpty()) {
                // 遇到运算符，和运算符栈顶元素进行比较，如果比栈顶运算符优先级高，就将当前运算符压入栈；
                if (symbolMapping.get(ch) > symbolMapping.get(symbolStack.peek())) {
                    break;
                }
                // 比运算符栈顶元素的优先级低或者相同，从运算符栈中取栈顶运算符，从操作数栈的栈顶取 2 个操作数，然后进行计算，再把计算完的结果压入操作数栈，继续比较
                int number1 = numberStack.pop();
                int number2 = numberStack.pop();
                int tempResult = calculation(number1, number2, symbolStack.pop());
                numberStack.push(tempResult);
            }
            symbolStack.push(ch);
        }
        // 如果表达式不包含运算符，直接返回结果
        if (symbolStack.isEmpty()) {
            return numberStack.pop();
        }
        int result = -1;
        // 清空栈获取结果
        while (!symbolStack.isEmpty()) {
            int number1 = numberStack.pop();
            int number2 = numberStack.pop();
            result = calculation(number1, number2, symbolStack.pop());
            numberStack.push(result);
        }
        return result;
    }

    private static int calculation(int number1, int number2, char symbol) {
        if (symbol == '*') {
            return number2 * number1;
        }
        if (symbol == '/') {
            return number2 / number1;
        }
        if (symbol == '+') {
            return number2 + number1;
        }
        return number2 - number1;
    }
}
