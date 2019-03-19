package com.vilderlee.datastructure.listnode;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2018/12/4      Create this file
 * </pre>
 */
public class DeleteNode {

    /**
     *  已知某个单链表，删除值为x的节点
     *
     *  思路：当删除的节点的值等于当前节点的值时，把当前节点的指针指向当前节点的下一个节点。
     *
     * @param node
     * @param val
     * @return
     */
    public static ListNode deleteNode(ListNode node, int val) {
        ListNode curr = node;
        ListNode pre = null;
        while (curr.val != val) {
            pre = curr;
            curr = curr.next;
        }

        pre.next = curr.next;

        return pre;
    }

    /**
     *  使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
     *
     *  这里只有被删除的节点，所以可以把下一个节点的值直接赋给当前要删除的节点（1->2->3->4->5 == >1->2->4->4->5）,接下来只需要把当前指针直接
     *  指向下下一个节点即可。其实这里是把下个节点进行了复制并覆盖了当前的值，这样直接去指向下下个节点即可。
     *
     * @param node
     */
    public void deleteNode2(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        AddNode.addNode(head, 2);
        AddNode.addNode(head, 3);
        AddNode.addNode(head, 4);
        AddNode.addNode(head, 5);

        PrintNode.print(head);

        DeleteNode.deleteNode(head, 2);
        PrintNode.print(head);
    }
}
