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

    public static ListNode reverseListNode(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static ListNode reverseListNode2(ListNode head) {
        if (head.next == null) return head;
        ListNode last = reverseListNode2(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }


    /**
     * 反转前N个节点
     *
     * @return
     */
    public static ListNode end;

    public static ListNode reverseListForN(ListNode head, int x) {
        if (x == 1) {
            end = head.next;
            return head;
        }
        ListNode last = reverseListForN(head.next, x - 1);
        head.next.next = head;
        head.next = end;
        return last;
    }


    public static ListNode reverseListForM2N(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseListForN(head, n);
        }

        head.next = reverseListForM2N(head.next, m - 1, n - 1);
        return head;
    }


    public static ListNode reverseListTest(ListNode head) {
        ListNode pre = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
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

        PrintNode.print(reverseListTest(cur));
    }

    public static ListNode reverseListNodex(ListNode listNode) {
        if (listNode.next == null) return listNode;
        ListNode newHead = reverseListNodex(listNode.next);

        listNode.next.next = listNode;
        listNode.next = null;

        return newHead;
    }

    public static ListNode reverseListNodex1(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static ListNode end1;

    public static ListNode reverseListNodeNxNode(ListNode head, int x) {
        if (x == 1) {
            end1 = head.next;
            return head;
        }

        ListNode newHead = reverseListNodeNxNode(head.next, x - 1);
        head.next.next = head;
        head.next = end1;
        return newHead;
    }


    public static ListNode reverseListNodeNxNodeForMxNode(ListNode head, int m, int n) {
        if (1 == m) return reverseListNodeNxNode(head, n);
        head.next = reverseListNodeNxNodeForMxNode(head, m - 1, n - 1);
        return head;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) return head;
            b = b.next;
        }
        //反转前k个元素
        ListNode newHead = reverseKGroupHelper(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    public static ListNode reverseKGroupHelper(ListNode a, ListNode b) {
        ListNode cur = a;
        ListNode pre = null, next;
        while (cur != b) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
