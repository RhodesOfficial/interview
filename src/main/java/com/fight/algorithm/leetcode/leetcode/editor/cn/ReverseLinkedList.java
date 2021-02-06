//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1486 👎 0

  
package com.fight.algorithm.leetcode.leetcode.editor.cn;

import com.fight.algorithm.leetcode.leetcode.editor.cn.common.ListNode;

public class ReverseLinkedList{
      public static void main(String[] args) {
           Solution solution = new ReverseLinkedList().new Solution();
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
//    public ListNode reverseList(ListNode head) {
//        ListNode pre = null;
//        ListNode cur = head;
//        while (cur != null) {
//            ListNode temp = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = temp;
//        }
//        return pre;
//    }

    public ListNode reverseList(ListNode head) {
        // 递归终止条件
        if (head == null || head.next == null) {
            return head;
        }
        // cur是最后一个节点
        ListNode cur = reverseList(head.next);
        // 1->2->3->4->5
        // cur = 5 head = 4
        // head.next.next = head
        // ==> 4.next.next = 4
        // ==> 5.next = 4
        head.next.next = head;
        // 断开指向
        head.next = null;
        // 返回的依然是5
        return cur;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}