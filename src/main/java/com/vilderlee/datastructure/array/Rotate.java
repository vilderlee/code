package com.vilderlee.datastructure.array;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/4/4      Create this file
 * </pre>
 */
public class Rotate {

    /***
     *  Input: [1,2,3,4,5,6,7] and k = 3
     *  Output: [5,6,7,1,2,3,4]
     * @param nums
     * @param k
     */
        public static int[] rotate(int[] nums, int k) {
            if (k<0||nums.length==1||k>nums.length){
              return nums;
            }

            int[] newNums = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (i + k > nums.length - 1) {
                    newNums[i + k - nums.length] = nums[i];
                } else {
                    newNums[i + k] = nums[i];
                }
            }
            return newNums;
        }

    public static void main(String[] args) {
        Rotate.rotate(new int[]{1,2,3,4,5,6,7}, 3);
    }
}
