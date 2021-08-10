package com.vilderlee.datastructure.listnode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        ListNode old = reverse(cur);
        while (head != null) {
            if (head.val != old.val) {
                return false;
            }
            head = head.next;
            old = old.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode cur = new ListNode(1);
        AddNode.addNode(cur, 2);
        AddNode.addNode(cur, 1);
        AddNode.addNode(cur, 1);

        PrintNode.print(cur);
        isPalindrome(cur);
    }
}