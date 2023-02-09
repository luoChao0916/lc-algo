package com.zkwq.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luochao
 * @desc (给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。)
 * @date 2023/2/8
 */
public class TwoNumber1 {
    public static void main(String[] args) {
        int[] nums = new int[]{11,15,2,7};
        int target = 9;
    }

    /**
     * 双重循环
     * 时间复杂度：O(N^2) N 是数组中的元素数量。最坏情况下数组中任意两个数都要被匹配一次。
     * 空间复杂度：O(1)
     */
    public static int[] forTwoSum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0};
    }

    /**
     * 借用哈希表快速查找的优势
     * 时间复杂度O(N)
     * 空间复杂度O(N)，主要是哈希表存储的空间开销
     */
    public static int[] hashTwoSum(int[] nums, int target) {
        Map<Integer, Integer> valueIndexMapping = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (valueIndexMapping.get(target-nums[i]) != null) {
                return new int[]{i, valueIndexMapping.get(target-nums[i])};
            }
            valueIndexMapping.put(nums[i], i);
        }
        return new int[]{0};
    }

}
