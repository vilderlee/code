package com.vilderlee.datastructure.listnode;

import com.vilderlee.datastructure.binarysearchtree.TreeNode;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2018/12/10      Create this file
 * </pre>
 */
public class SortedListToBST {

    /**
     * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     * 给定的有序链表： [-10, -3, 0, 5, 9],
     * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
     * <p>
     * 0
     * /   \
     * -3    9
     * /    /
     * -10   5
     * 我的思路：这里的高度平衡二叉树左右子树高度差不超过1.那么直接把单链表的中值找到作为根节点。然后左边的是左子树，右边的是右子树
     * 二分法  时间复杂度nlogn
     *
     * @param head
     * @return
     */
    public static TreeNode sortedListToBST(ListNode head) {

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return new TreeNode(head.val);
        }

        //1.寻找中值 快慢指针
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;

        while (fast.next != null && fast != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;

            if (fast == null) {
                break;
            }
        }

        //2.找到中值，新建二叉树
        TreeNode binaryTree = new TreeNode(slow.val);

        //3.将前指针的下一个节点指向空那么就是中值左边的,遍历slow之前的值，建立左子树
        pre.next = null;
        binaryTree.left = sortedListToBST(head);

        //4.遍历slow后面的值，即为建立右子树
        binaryTree.right = sortedListToBST(slow.next);

        return binaryTree;
    }



    public static void main(String[] args) {
        int[] val = { -10, -3, 0, 5, 9 };
        ListNode listNode = new ListNode(val[0]);
        ListNode cur = listNode;

        for (int i = 1; i < val.length; i++) {
            cur.next = new ListNode(val[i]);
            cur = cur.next;
        }

    }
}
