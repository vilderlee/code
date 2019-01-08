package com.vilderlee.listnode;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2018/12/4      Create this file
 * </pre>
 */
public class PrintNode {
    public static void print(ListNode listNode){
        StringBuilder stringBuilder = new StringBuilder();
        ListNode curr = listNode;
        while (null!=curr){
            stringBuilder.append(curr.val+",");
            curr = curr.next;
        }
        System.out.println(stringBuilder.substring(0, stringBuilder.lastIndexOf(",")));
    }
}
