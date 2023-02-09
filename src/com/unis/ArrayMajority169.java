package com.unis;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luochao
 * @desc (
 * 给定一个大小为 n 的数组 nums ， 返回其中的多数元素 。
 *多数元素是指在数组中出现次数 大于 ⌊ n / 2 ⌋ 的元素 。)
 * @date 2023/2/6
 */
public class ArrayMajority169 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2,2};
        System.out.println(hash(nums));
        System.out.println(boyerMoore(nums));
    }


    /**
     * 利用哈希表记录元素出现的次数
     * 时间复杂度：O(N) 空间复杂度：O(N)
     */
    private static int hash(int[] nums) {
        Map<Integer, Integer> countMapping = new HashMap<>();
        int length = nums.length;
        for (int num : nums) {
            countMapping.put(num, countMapping.getOrDefault(num, 0) + 1);
            if (countMapping.get(num) > length / 2) {
                return num;
            }
        }
        return -1;
    }

    /**
     * 摩尔投票法：
     * 核心就是对拼消耗。
     * 玩一个诸侯争霸的游戏，假设你方人口超过总人口一半以上，并且能保证每个人口出去干仗都能一对一同归于尽。最后还有人活下来的国家就是胜利。
     * 时间复杂度：O(N) 空间复杂度：O(1)
     */
    private static int boyerMoore(int[] nums) {
        int result = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (result == nums[i]) {
                count++;
            } else count--;
            if (count == 0) {
                result = nums[i+1];
            }
        }
        return result;
    }
}
