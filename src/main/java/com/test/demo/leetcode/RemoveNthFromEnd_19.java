package com.test.demo.leetcode;

/**
 * @Author :zjk
 * @Date :Create in 15:28 2020-10-12
 * @Description 删除链表的倒数第N个节点
 **/
public class RemoveNthFromEnd_19 {
      class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head = null;
        }
        int count = 0,k=1;
        ListNode p=head, q = head,pre=head;
        while (head != null) {
            count++;
            head = head.next;
        }
        while (true) {

            if (k == count - n + 1) {
                if (k == 1) {
                    q = p.next;
                    p.next = null;
                    break;
                } else if (k == count) {
                    pre.next = null;
                    break;
                } else {
                    pre.next = p.next;
                    break;
                }
            }
            pre = p;
            p = p.next;
        }
          return q;
    }
}
