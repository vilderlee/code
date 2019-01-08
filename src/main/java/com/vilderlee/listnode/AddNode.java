package com.vilderlee.listnode;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2018/12/4      Create this file
 * </pre>
 */
public class AddNode {

    /**
     * 向末尾添加一个节点
     * 添加思路：遍历单链表，如果当前节点为空的话，直接新建一个节点，把上一个节点指向当前节点。
     *
     * @param listNode
     * @param val
     */
    public static void addNode(ListNode listNode, int val) {
        ListNode curr = listNode;
        ListNode pre = null;
        while (null != curr) {
            pre = curr;
            curr = curr.next;
        }
        curr = new ListNode(val);
        pre.next = curr;
    }

    /**
     * 向末尾添加一个节点
     * 思路：当当前节点的下一个节点不为空时
     *
     * @param listNode
     * @param val
     */
    public static void addNode2(ListNode listNode, int val) {
        ListNode curr = listNode;
        while (null != curr.next) {
            curr = curr.next;
        }
        curr.next = new ListNode(val);
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        addNode2(listNode, 2);
        addNode2(listNode, 3);
    }
}
