package com.vilderlee.dataStructure.listnode;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2018/12/6      Create this file
 * </pre>
 */
public class IsPalindrome {
    /**
     * 两个链表是否相交
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {

        if (null == head) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //翻转
        slow = reverseList(slow);
        while (slow != null) {

            if (slow.val != head.val) {
                return false;
            }
            slow = slow.next;
            head = head.next;
        }

        return true;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode tmp = cur;
            ListNode next = cur.next;
            cur.next = pre;
            cur = next;
            pre = tmp;

        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        AddNode.addNode(head, 2);
        AddNode.addNode(head, 3);
        AddNode.addNode(head, 2);
        AddNode.addNode(head, 1);

        System.out.println(isPalindrome(head));
    }
}
