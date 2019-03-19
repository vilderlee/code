package com.vilderlee.datastructure.listnode;

import java.util.HashSet;
import java.util.Set;

/**
 * 功能描述:
 *
 * @package com.vilderlee.listnode
 * @auther vilderlee
 * @date 2018-12-06 20:56
 */
public class GetIntersectionNode {
    /**
     * 例如，下面的两个链表：
     * <p>
     * A:          a1 → a2
     * ↘
     * c1 → c2 → c3
     * ↗
     * B:     b1 → b2 → b3
     * 在节点 c1 开始相交。
     * <p>
     * 思路：因为可能长短不一，不如让长的链表的指针与短的堆起。
     * 那么通过遍历两个链表，得知两个链表的长度，长的链表向前走长度差即可满足两个链表对齐。
     * 接下来只需要遍历两个链表，并且比较即可。
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode curA = headA;
        int a = 0;
        ListNode curB = headB;
        int b = 0;
        while (null != curA) {
            curA = curA.next;
            a++;
        }

        while (null != curB) {
            curB = curB.next;
            b++;
        }

        int x = Math.abs(a - b);
        curA = headA;
        curB = headB;
        if (a >= b) {
            while (x > 0) {
                curA = curA.next;
                x--;
            }
        } else {
            while (x > 0) {
                curB = curB.next;
                x--;
            }
        }

        while (curA != null && curB != null) {
            if (curA == curB) {
                return curA;
            }

            curA = curA.next;
            curB = curB.next;
        }

        return null;
    }


    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        Set set = new HashSet();
        ListNode tem = headA;
        while (tem != null) {
            set.add(tem);
            tem = tem.next;
        }

        ListNode tem1 = headB;
        while (tem1!=null) {
            if (!set.contains(tem1)) {
                tem1 = tem1.next;
            }else {
                return tem1;
            }
        }

        return null;
    }
}
