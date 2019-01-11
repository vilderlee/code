package com.vilderlee.dataStructure.listnode;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2018/12/4      Create this file
 * </pre>
 */
public class MidNode {

    /**
     * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
     * <p>
     * 如果有两个中间结点，则返回第二个中间结点。
     * <p>
     * 思路：找中间节点，放入一个数组中,根据下标直接找出 时间复杂度O(n)
     *
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {
        ListNode[] listNodes = new ListNode[100];
        int n = 0;
        while (null != head) {
            listNodes[n] = head;
            head = head.next;
            n++;
        }

        return listNodes[n / 2];

    }

    /**
     * 思路：快慢指针,快指针是慢指针速度的两倍,快指针到了链表尾部,那慢指针指向的一定是中间值.
     *        这里一定要注意的是当快指针已经到达链表尾部的时候，他的下一个指针已经为空，此时应该中断循环
     *
     * @param head
     * @return
     */
    public static ListNode middleNode2(ListNode head) {
        ListNode low = head;
        ListNode fast = head;
        while (null != fast.next && null != fast) {
            low = low.next;
            fast = fast.next.next;
            if (null == fast) {
                break;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        AddNode.addNode(head, 2);
        AddNode.addNode(head, 3);
        AddNode.addNode(head, 4);
        AddNode.addNode(head, 5);

        PrintNode.print(head);

        PrintNode.print(middleNode2(head));
    }
}
