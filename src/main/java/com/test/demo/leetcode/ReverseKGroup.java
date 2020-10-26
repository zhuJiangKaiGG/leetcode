package com.test.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :zjk
 * @Date :Create in 15:36 2020-10-15
 * @Description 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 **/
public class ReverseKGroup {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int length=0;
        ListNode temp = new ListNode(0);
        ListNode newHead = head;
        ListNode ans = temp;

        if (k == 1 || head == null) {
            return head;
        }
        while (newHead != null) {
            length++;
            newHead=newHead.next;
        }
        while (head != null) {

            if (length / k > 0) {
                //用链表倒置
                /**
                 *                 ListNode pre = null;
                 *                  ListNode preTemp = head;
                 *                 for (int i = 0; i < k; i++) {
                 *
                 *                     ListNode nextTemp = head.next;
                 *
                 *                     head.next = pre;
                 *                     pre = head;
                 *                     head = nextTemp;
                 *                     System.out.println(pre.val);
                 *                     length--;
                 *                 }
                 *                 temp.next = pre;
                 *                  System.out.println(temp.next.next.val);
                 *                 temp = preTemp;
                 */
                List<ListNode> list = new ArrayList<>();
                for (int i = 0; i < k; i++) {
                    list.add(head);
                    head = head.next;
                    System.out.println(head);
                    length--;
                }

                for (int i = list.size() - 1; i >= 0; i--) {
                    //每次都把加进来的结点的指针清空，防止造成循环或双向链表
                    list.get(i).next=null;
                    temp.next = list.get(i);
                    System.out.println(temp.next.val);

                    temp = temp.next;
                }

            } else {
                System.out.println("sssssss");
                temp.next = head;
                head=null;
            }
        }
        return ans.next;
    }
}
