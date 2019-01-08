package com.vilderlee.listnode;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2018/12/4      Create this file
 * </pre>
 */
public class MergeTwoLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode newList = new ListNode(0);
        ListNode cur = newList;
        while (null != l1 && null != l2) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }

        if (null != l1) {
            cur.next = l1;
        }

        if (null != l2) {
            cur.next = l2;
        }

        return newList;

        // 类似归并排序中的合并过程
//        ListNode dummyHead = new ListNode(0);
//        ListNode cur = dummyHead;
//        while (l1 != null && l2 != null) {
//            if (l1.val < l2.val) {
//                cur.next = l1;
//                cur = cur.next;
//                l1 = l1.next;
//            } else {
//                cur.next = l2;
//                cur = cur.next;
//                l2 = l2.next;
//            }
//        }
//        // 任一为空，直接连接另一条链表
//        if (l1 == null) {
//            cur.next = l2;
//        } else {
//            cur.next = l1;
//        }
//        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        AddNode.addNode(head, 2);
        AddNode.addNode(head, 3);

        PrintNode.print(head);

        ListNode head2 = new ListNode(1);
        AddNode.addNode(head2, 4);
        AddNode.addNode(head2, 5);

        PrintNode.print(head2);

        PrintNode.print(mergeTwoLists(head, head2));
    }
}
