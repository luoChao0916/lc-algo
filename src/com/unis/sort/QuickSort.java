package com.unis.sort;

/**
 * @author luochao
 * @desc (快速排序)
 * @date 2023/2/9
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{6,5,3,7,8,2,1,4,9,5};
        quickSort(arr, 0 , arr.length-1);
        for (int value : arr) {
            System.out.println(value);
        }
    }

    /**
     * 快速排序利用的是分治的思想。它将一个数组切分为两部分，再将两部分独立的进行排序。
     * 快递排序的关键在于切分，这个过程使得数组满足下面三个条件：
     * 1、前面 lo 到 p-1 之间的元素都是小于等于 pivot 的；
     * 2、中间是 切分元素pivot 位置(p)是确定的；
     * 3、后面的 p+1 到 r 之间的元素都是大于等于 pivot 的。
     * 每次的切分过程总能排定一个元素，用归纳法不难证明递归能够将数组正确的排序。
     * 根据分治、递归的处理思想，我们可以用递归排序下标从 lo到 p-1 之间的数据和下标从 p+1 到 hi 之间的数据，直到区间缩小为 1，就说明所有的数据都有序了。
     * 由此可以推出递归公式：f(lo,hi) =partition() +  f(lo,p-1) + f(p+1,hi)；
     * 终止条件：lo >= hi；
     * 递归公式：f(lo,hi) =partition() +  f(lo,p-1) + f(p+1,hi)；
     * 终止条件：lo >= hi；
     */
    public static void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        // 切分、排定一个元素的位置
        int p = partition(arr, lo, hi);
        quickSort(arr, lo, p-1);
        quickSort(arr, p+1, hi);
    }

    /**
     * 切分方法的实现：
     * 一般是选取arr[lo]作为切分元素，也就是那个会被排定顺序的元素。
     * 从数组的左端开始向右扫描，找到第一个大于等于它的元素，从数组的右端开始向左扫描，找到第一个小于等于它的元素；
     * 这两个元素显然是没有排定顺序的，交换他们的位置。
     * 如此继续比较，当左右扫描指针相遇到时退出比较，这样就可以保证，左指针i左侧的元素都小于等于切分元素，右指针j右侧的元素都大于等于切分元素。
     * 再将切分元素和左子数组的最右侧元素arr[j]交换位置来确定切分元素的位置。
     */
    private static int partition(int[] arr, int lo, int hi) {
        // 定义切分元素和左右扫描指针
        int pivot = arr[lo];
        int i = lo + 1;
        int j = hi;
        while (true) {
            // 小心扫描指针跑出数组的边界
            while (arr[i] <= pivot && i < hi) {
                i++;
            }
            while (arr[j] >= pivot && j > lo) {
                j--;
            }
            if (i >= j) {
                break;
            }
            // 位置交换
            swap(arr, i, j);
        }
        swap(arr, lo, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;

    }
}
