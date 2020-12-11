//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 5296 👎 0

package com.leetcode.tempfilepath.leetcode.editor.cn;

import java.util.ArrayList;

/**
 *
 * 链表有关，暂时不熟悉
 *
 */

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    // 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807

    // 有问题，提交不通过
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        while (l1!=null){
            list1.add(l1.val);
            l1=l1.next;
        }
        while (l2!=null){
            list2.add(l2.val);
            l2=l2.next;
        }
        int num1=0;
        for (int i = list1.size()-1; i >=0 ; i--) {
            num1=num1*10+list1.get(i);
        }
        int num2=0;
        for (int i = list2.size()-1; i >=0 ; i--) {
            num2=num2*10+list2.get(i);
        }
        int result=num1+num2;
        ArrayList<Integer> list3 = new ArrayList<>();
        while (result!=0){
            list3.add(result%10);
            result/=10;
        }
        ListNode temp=l1;
        for (int i = 0; i < list3.size(); i++) {
            temp.next=new ListNode(list3.get(0));
            temp=temp.next;
        }

        return l1;

    }

    // leetcode提供的答案
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }




}
//leetcode submit region end(Prohibit modification and deletion)
public class ListNode {
    int val;
   ListNode next;
   ListNode() {}
   ListNode(int val) { this.val = val; }
   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
}