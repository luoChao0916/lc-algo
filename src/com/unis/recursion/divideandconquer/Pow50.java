package com.unis.recursion.divideandconquer;

/**
 * @author luochao
 * @desc (实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。)
 * @date 2023/2/6
 */
public class Pow50 {
    public static void main(String[] args) {
        System.out.println(myPow(2,-3));
    }

    /**
     * 快速幂 + 递归
     * 时间复杂度：O(logn)，即为递归的层数。
     * 空间复杂度：O(logn)，即为递归的层数。这是由于递归的函数调用会使用栈空间。
     * 递归的边界为 n = 0，任意数的 0 次方均为 1
     * 本质还是分治算法2的10次方 = 2的5次方*2的5次方
     */
    private static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double tempResult = myPow(x, n / 2);
        if (n % 2 == 0) {
            return tempResult * tempResult;
        }
        if (n > 0) {
            return x * tempResult * tempResult;
        }
        return 1.0 / x * tempResult * tempResult;
    }
}
