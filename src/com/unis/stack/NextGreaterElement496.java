package com.unis.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author luochao
 * @desc (下一个更大元素 I)
 * @date 2023/2/9
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出：[-1,3,-1]
 * 4，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * 1，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
 * 2，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 */
public class NextGreaterElement496 {

    /**
     * 单调用栈+哈希表
     * 需要将num2的结构转变为哈希表，支持根据元素快速查找出下一个更大的元素[{1,3},{3,4},{4,-1},{2,-1}]
     * 如何高效的计算num2中的元素的第一个更大的值？
     * 可以单调栈中维护当前位置右边的更大的元素列表，栈顶到栈底的元素是单调递增的
     * 从后向前依次遍历数组
     * 如果栈为空，说明没有更大的元素
     * 不为空，我们将栈中小于该元素的数据出栈，当前位置右边的第一个更大的元素即为栈顶元素。
     * 然后将该元素压入栈中。
     *
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> valueNextGreaterElementMapping = new HashMap<>();
        int num2Length = nums2.length;
        for (int i= num2Length-1;  i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] >= stack.peek()) {
                stack.pop();
            }
            valueNextGreaterElementMapping.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        int length = nums1.length;
        int [] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = valueNextGreaterElementMapping.get(nums1[i]);
        }
        return result;
    }
}
