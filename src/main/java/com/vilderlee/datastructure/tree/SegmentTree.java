package com.vilderlee.datastructure.tree;

/**
 * SegmentTree
 *
 * @ClassName SegmentTree
 * @Description
 * @Author VilderLee
 * @Date 2021/3/5 11:23 上午
 */

public class SegmentTree {

    public SegmentTree(int start, int end) {
        this.start = start;
        this.end = end;
        this.val = 0;
    }

    public int start;

    public int end;

    public int val;

    public SegmentTree left;

    public SegmentTree right;

    public static SegmentTree build(int[] nums, int start, int end) {
        if (start > end) return null;
        SegmentTree segmentTree = new SegmentTree(start, end);
        if (start == end) {
            segmentTree.val = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            segmentTree.left = build(nums, start, mid);
            segmentTree.right = build(nums, mid + 1, end);
            segmentTree.val = segmentTree.left.val + segmentTree.right.val;
        }
        return segmentTree;
    }

    public static int rangeSumQuery(int[] nums, int start, int end) {
        SegmentTree segmentTree = build(nums, 0, nums.length - 1);
        return rangeSumQuery(segmentTree, start, end);
    }

    public static int rangeSumQuery2(int[] nums, int start, int end) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        return sum[end] - sum[start - 1];
    }

    public static int rangeSumQuery(SegmentTree segmentTree, int start, int end) {
        if (segmentTree.start == start && segmentTree.end == end) return segmentTree.val;
        int mid = segmentTree.start + (segmentTree.end - segmentTree.start) / 2;
        if (end < mid) {
            return rangeSumQuery(segmentTree.left, start, end);
        } else if (start >= mid + 1) {
            return rangeSumQuery(segmentTree.right, start, end);
        } else {
            return rangeSumQuery(segmentTree.left, start, mid) + rangeSumQuery(segmentTree.right, mid + 1, end);
        }
    }

    public static void update(SegmentTree segmentTree, int index, int val) {
        if (segmentTree.start == segmentTree.end) {
            segmentTree.val = val;
            return;
        }

        int mid = segmentTree.start + (segmentTree.end - segmentTree.start) / 2;
        if (index < mid) {
            update(segmentTree.left, index, val);
        } else {
            update(segmentTree.right, index, val);
        }

        segmentTree.val = segmentTree.left.val + segmentTree.right.val;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 7, 9, 11};
        System.out.println(rangeSumQuery2(nums, 2, 5));
    }
}
