package com.vilderlee.datastructure.tree;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/3/14      Create this file
 * </pre>
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {

        if (null == root) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 0;
    }
}
