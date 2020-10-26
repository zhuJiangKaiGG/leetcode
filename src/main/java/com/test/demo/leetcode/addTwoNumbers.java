package com.test.demo.leetcode;

/**
 * @Author :zjk
 * @Date :Create in 16:06 2020-09-13
 * @Description 两数之和
 **/
public class addTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //自己编写的函数不能实现
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumNode = new ListNode(0);
        //修改
//        ListNode curr = sumNode;
        int count = 0;
        while(l1 != null||l2!=null){
            if(l1 != null&&l2 != null){
                int sum = (l1.val+l2.val+count)%10;
                count = (l1.val+l2.val+count)/10;
                //修改
//                curr.next = new ListNode(sum);
//                curr = curr.next;

                sumNode.val = sum;
                System.out.println(sumNode.val);
                sumNode.next=new ListNode(0);
                sumNode=sumNode.next;
                l1 = l1.next;
                l2 = l2.next;

            }
            //下面的这些都可以用三元表达式来处理：int x = l1 != null ? l1.val : 0
            else if(l1 == null&& l2 != null){
                int sum = (l2.val+count)%10;
                count = (l2.val+count)/10;
                sumNode.val = sum;
                sumNode = sumNode.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            else if(l2 == null&& l1 != null){
                int sum = (l1.val+count)%10;
                count = (l1.val+count)/10;
                sumNode.val = sum;
                sumNode = sumNode.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            else{
                System.out.print("计算完毕");
            }
        }
        if(count == 1){
            sumNode.val = count;
        }
        return sumNode;
    }
    //答案
    public ListNode addTwoNumbers_Answer(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        //定义curr指向dummyHead,代替头节点dummyHead进行赋值操作，关键一步
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            //三元运算符进行判断
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    //递归
    public ListNode addTwoNumbers_Iteration(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        int carry = 0;
        Iteration(head, l1, l2, 0);
        return head.next;
    }

    public void Iteration(ListNode head, ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0)
            return;
        int x = l1 != null ? l1.val : 0;
        int y = l2 != null ? l2.val : 0;
        int sum = (x + y + carry) % 10;
        carry = (x + y + carry) / 10;
        head.next = new ListNode(0);
        head.next.val = sum;
        Iteration(head.next, l1.next, l2.next, carry);
    }

    //    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/add-two-numbers/solution/liang-shu-xiang-jia-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int research(int[] nums,int target) {
        int left = 0, right = nums.length ;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left == nums.length || nums[left] != target) {
            return -1;
        } else if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}
