package com.zkwq.recursion.divideandconquer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luochao
 * @desc (假设你正在爬楼梯 。 需要 n 阶你才能到达楼顶 。
 *  每次你可以爬 1 或 2 个台阶 。 你有多少种不同的方法可以爬到楼顶呢 ？)
 * @date 2023/2/7
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    /**
     * 想要爬到第五个台阶有两种方法
     * 1、从第3个台阶直接爬 2个台阶
     * 2、从第4个台阶爬 1个台阶
     * 爬 5 级楼梯的方式数 = 爬 4 级楼梯的方式数 + 爬 3 级楼梯的方式数
     * 递归公式：f(n) = f(n) +f(n-1)
     * 终止条件：f(1) = 1 f(2) = 2
     *
     *
     * f(5) = f(4) + f(3)
     * f(4) = f(3) + f(2)
     * f(3)被计算了多次
     * 为了避免重复计算，我们可以通过一个数据结构（比如散列表）来保存已经求解过的 f(n)。来降低时间复杂度
     * 时间复杂度：O(N) 空间复杂度：O(n)
     */
    private static Map<Integer, Integer> resultMapping = new HashMap<>();

    private static int climbStairs(int n) {
        if (n == 1){
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        Integer cacheResult = resultMapping.get(n);
        if (cacheResult != null) {
            return cacheResult;
        }
        int result = climbStairs(n-1) + climbStairs(n-2);
        resultMapping.put(n, result);
        return result;
    }

}
