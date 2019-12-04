package com.vilderlee.datastructure.listnode;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2018/12/4      Create this file
 * </pre>
 */
public class ReverseListNode {
    /**
     * 反转一个单链表
     * <p>
     * <p>
     * 思路：当前节点指针指向前一个，循环。
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (null != head) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        AddNode.addNode(head, 2);
        AddNode.addNode(head, 3);
        AddNode.addNode(head, 4);
        AddNode.addNode(head, 5);

        PrintNode.print(head);

        PrintNode.print(reverseList(head));
    }
}
