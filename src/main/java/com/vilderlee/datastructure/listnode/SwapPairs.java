package com.vilderlee.datastructure.listnode;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2018/12/10      Create this file
 * </pre>
 */
public class SwapPairs {

    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * <p>
     * <p>
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = pre;
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;

            first.next = second.next;
            cur.next = second;
            cur.next.next = first;
            cur = cur.next.next;
        }

        return pre.next;
    }

    public static void main(String[] args) {
        SwapPairs swapPairs = new SwapPairs();
        int[] val = new int[] { 1, 2, 3, 4 };
        ListNode listNode = new ListNode(val[0]);
        ListNode cur = listNode;
        for (int i = 1; i < val.length; i++) {
            cur.next = new ListNode(val[i]);
            cur = cur.next;
        }

        swapPairs.swapPairs(listNode);
    }
}
