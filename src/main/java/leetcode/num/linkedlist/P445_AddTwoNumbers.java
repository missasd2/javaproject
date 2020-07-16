package leetcode.num.linkedlist;

import java.util.Stack;

public class P445_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        while (l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        int sum = 0;
        ListNode head = null;

        while ( !stack1.empty() || !stack2.empty() || carry > 0){
            int n = stack1.empty()? 0 : stack1.pop();
            int m = stack2.empty()? 0 : stack2.pop();
            sum = n + m + carry;

            carry = sum / 10;
            sum = sum % 10;

            // 头插法
            ListNode node = new ListNode(sum);
            node.next = head;
            head = node;
        }
        return head;
    }
}
