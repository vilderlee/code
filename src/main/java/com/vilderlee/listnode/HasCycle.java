package com.vilderlee.listnode;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2018/12/6      Create this file
 * </pre>
 */
public class HasCycle {
    /**
     *
     * 是否有环
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        if (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow==fast){
                return true;
            }
        }

        return false;
    }
}
