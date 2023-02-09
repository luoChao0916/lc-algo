package com.unis.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author luochao
 * @desc (定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。)
 * @date 2023/2/8
 */
public class ValidBrackets20 {

    public static void main(String[] args) {
        System.out.println(isValid("{{"));
    }

    /**
     *  输入：s = "()[]{}"
     * 输出：true
     * 遍历字符串，当遇到左括号时压入符号栈，当遇到右括号时，从运算符栈顶弹出进行匹配。
     * 如果能够匹配，则继续扫描剩下的字符串。如果扫描的过程中，遇到不能配对的右括号，或者栈中没有数据，则说明为非法格式。
     * 扫描结束，栈为空则说明完全匹配。
     */
    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> bracketsMapping = new HashMap<>();
        bracketsMapping.put('(',')');
        bracketsMapping.put('{','}');
        bracketsMapping.put('[',']');
        char[] chars = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (char ch : chars) {
            // 遇到左括号，压入符号栈
            if (bracketsMapping.containsKey(ch)) {
                stack.push(ch);
                continue;
            }
            // 遇到右括号，取出栈顶的括号进行匹配
            if (stack.isEmpty() || !bracketsMapping.get(stack.pop()).equals(ch)) {
                return false;
            }
        }
        // 栈为空，都完全匹配
        return stack.isEmpty();
    }
}
