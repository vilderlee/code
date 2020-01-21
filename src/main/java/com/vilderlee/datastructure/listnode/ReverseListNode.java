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
     * @param cur
     * @return
     */
    public static ListNode reverseList(ListNode cur) {
        ListNode pre = null;
        ListNode next = null;
        while (null != cur) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static ListNode reverseListNode(ListNode head){
        ListNode pre = null;
        while (head!=null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode cur = new ListNode(1);
        AddNode.addNode(cur, 2);
        AddNode.addNode(cur, 3);
        AddNode.addNode(cur, 4);
        AddNode.addNode(cur, 5);

        PrintNode.print(cur);

        PrintNode.print(reverseListNode(cur));
    }
}
