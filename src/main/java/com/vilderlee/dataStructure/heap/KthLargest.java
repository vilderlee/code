package com.vilderlee.dataStructure.heap;

import java.util.PriorityQueue;

/**
 * Design a class to find the kth largest element in a stream.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums,
 * which contains initial elements from the stream.
 * For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/11      Create this file
 * </pre>
 */
public class KthLargest {
    private int k;
    private int[] nums;
    private PriorityQueue<Integer> priorityQueue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;

        for (int n : nums) {
            add(n);
        }
    }

    public int add(int val) {
        priorityQueue = new PriorityQueue<>(k);
        priorityQueue.add(val);
        if (priorityQueue.size() > k) {
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = { 4, 5, 8, 2 };
        KthLargest kthLargest = new KthLargest(3, arr);
        System.out.println(kthLargest.add(3));

        kthLargest.add(3);   // returns 4
        kthLargest.add(5);   // returns 5
        kthLargest.add(10);  // returns 5
        kthLargest.add(9);   // returns 8
        kthLargest.add(4);   // returns 8
    }
}
