package com.unis;

/**
 * @author luochao
 * @desc (回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。)
 * @date 2023/2/8
 */
public class PalindromeNumber9 {
    public static void main(String[] args) {
        System.out.println(halfReversalIsPalindrome(10));
    }

    /**
     * 使用字符串,反转之后相等
     */
    public static boolean strIsPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        String xStr = x + "";
        char[] chars = xStr.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = chars.length-1; i >= 0; i--) {
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString().equals(xStr);
    }


    /**
     * 反转整个数字
     */
    public static boolean reversalIsPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int result = 0;
        int temp = x;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result == temp;
    }

    /**
     * 只反转一半
     * 整个过程我们不断将原始数字除以 10，然后给反转后的数字乘上 10，
     * 所以，当原始数字小于或等于反转后的数字时，就意味着我们已经处理了一半位数的数字了。
     */
    public static boolean halfReversalIsPalindrome(int x) {
        // 负数不为回文数，最后一次是0的数也不会是回文数
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int result = 0;
        while (result < x) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result == x || result / 10 == x;
    }

}
