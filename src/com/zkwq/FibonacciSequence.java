package com.zkwq;

/**
 * @author luoChao
 * @create_date 2020-04-06 20:11
 */
public class FibonacciSequence {
    public static void main(String[] args) {
        System.out.println(fibonacciSequenceRecursion(50));
    }

    // F(1)=1，F(2)=1, F(n)=F(n - 1)+F(n - 2)
    // 1 1 2 3 5 8 13 21 34
    public static long fibonacciSequenceRecursion(int number) {
        if (number <= 2) {
            return 1;
        }
        return fibonacciSequenceRecursion(number-1) + fibonacciSequenceRecursion(number-2);
    }
    // 求第n个数，只需要加n-2次
    public static long fibonacciSequenceLoop(int number) {
        if (number <= 2) {
            return 1;
        }
        long first = 1;
        long second = 1;
        for (int i = 0;i < number-2; i++) {
            long sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }
}
