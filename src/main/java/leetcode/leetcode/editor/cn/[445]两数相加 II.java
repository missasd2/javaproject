//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 进阶： 
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 8 -> 0 -> 7
// 
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)
package leetcode.leetcode.editor.cn;


import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
       int sum = 0;
       int carry = 0;
       ListNode head = null;

       while ( !stack1.empty() || !stack2.empty() || carry>0){
           int n = stack1.empty()? 0 : stack1.pop();
           int m = stack2.empty()? 0 : stack2.pop();
           sum = m + n + carry;
           carry = sum / 10;
           sum = sum % 10;

           // 链表头插法，构建链表
           ListNode node = new ListNode(sum);
           node.next = head;
           head = node;
       }
    return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
