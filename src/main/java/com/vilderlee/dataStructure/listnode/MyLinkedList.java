package com.vilderlee.dataStructure.listnode;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2018/12/7      Create this file
 * </pre>
 */
public class MyLinkedList {

    private ListNode head;
    private int value;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        head = null;
        value = 0;
    }

    /**
     * Get the value of the index-th node in the linked list.
     * If the index is invalid, return -1.
     */
    public int get(int index) {

        ListNode cur = head;

        while (cur != null) {
            if (index < 0) {
                return -1;
            } else if (index == 0) {
                return cur.val;
            } else {

                cur = cur.next;
                index--;
            }
        }

        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list.
     * After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        if (head == null) {
            head = new ListNode(val);
        } else {
            ListNode cur = head;
            ListNode pre = new ListNode(val);
            pre.next = cur;
            head = pre;
        }
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (head == null) {
            head = new ListNode(val);
        } else {

            ListNode cur = head;
            ListNode pre = null;
            while (null != cur) {
                ListNode tmp = cur;
                cur = cur.next;
                pre = tmp;
            }
            pre.next = new ListNode(val);
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list,
     * the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == 0){
            addAtHead(val);
        }

        else if (index > 0) {
            ListNode cur = head;
            index = index - 1;
            while (cur != null) {
                if (index == 0) {
                    ListNode next = cur.next;
                    cur.next = new ListNode(val);
                    cur.next.next = next;
                    return;
                } else {
                    cur = cur.next;
                    index--;
                }

            }
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {

        if (index == 0) {
            head = head.next;
        } else {
            ListNode cur = head;
            ListNode pre = null;
            while (cur != null) {
                if (index == 0) {
                    pre.next = cur.next;
                }
                pre = cur;
                cur = cur.next;
                index--;

            }
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        System.out.println(myLinkedList.get(0));
        myLinkedList.addAtIndex(1, 2);
        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));
        myLinkedList.addAtIndex(0, 1);
        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));

    }
}
