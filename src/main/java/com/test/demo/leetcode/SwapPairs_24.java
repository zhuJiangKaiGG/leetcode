package com.test.demo.leetcode;

/**
 * @Author :zjk
 * @Date :Create in 14:19 2020-10-15
 * @Description 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 **/
public class SwapPairs_24 {


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //从原链表中循环取出节点，交换加入新链表。
    public ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(0) , result  = temp,node;
        while (head != null){
            if (head.next == null){
                temp.next = head;
                break;
            }else{
                node = head;
                head = head.next.next;
                temp.next = node.next;
                temp.next.next = node;
                node.next = null;
                temp = temp.next.next;
            }
        }
        return result.next;
    }
}
