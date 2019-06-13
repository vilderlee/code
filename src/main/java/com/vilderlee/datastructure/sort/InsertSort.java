package com.vilderlee.datastructure.sort;

import java.util.Arrays;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/3/25      Create this file
 * </pre>
 */
public class InsertSort {

    /**
     * 插入排序就是从未排序序列中，取出元素，在已排序序列中一次比较。插入到相应的位置。
     * <p>
     * 在上面的五个数字中 12 8 17 31 22
     * <p>
     * 我们假设有一个长度为一的有序系列为12。
     * <p>
     * 而8、17、31、22为无序序列。
     * <p>
     * 从无序序列中取出一个元素8，与有序序列中的12进行比较。比12小，则将其移动到12前面，反之放在后面
     *
     * @param nums
     * @throws Exception
     */
    public static int[] insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            //前面排序好的数组；然后一个个再比较
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                } else {
                    break;
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        Arrays.stream(insertSort(new int[] { 12, 8, 17, 31, 22 })).forEach((i) -> System.out.print(i + ","));
    }
}
