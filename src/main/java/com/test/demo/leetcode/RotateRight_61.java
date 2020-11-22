package com.test.demo.leetcode;

/**
 * @Author :zjk
 * @Date :Create in 13:57 2020-11-19
 * @Description 给定一个单链表和一个非负整数K，将链表中的节点向后移动k个单位
 * 移动链表中的节点可以看成将链表从某一节点切割再拼接起来。
 * 先考虑k的值，当k等于链表的长度时，链表不会发生改变，因此当k大于链表的长度时只需要移动k%length个位置
 * 先循环一遍链表，计算链表的长度以及找到链表的最后一个节点。
 * 接下来要找到切割节点的位置，向后移动k个单位相当于将倒数第k个节点切断再接到头节点上
 * 因此在第二遍循环链表时，设置一个index(初始值为0)，当index==count-k时，需要进行切断以及拼接工作
 **/
public class RotateRight_61 {
    public static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        ListNode curr = head, q = head, end = null;
        int count = 0, index = 0;
        while (q != null) {
            count++;
            if (q.next == null) {
                end = q;
            }
            q = q.next;
        }
        k = k % count;
        if (k == 0) {
            return head;
        }
        while (curr != null) {
            index++;
            if (index == count - k) {
                end.next = head;
                head = curr.next;
                curr.next = null;
                break;
            }
            curr = curr.next;
        }
        return head;
    }
}
