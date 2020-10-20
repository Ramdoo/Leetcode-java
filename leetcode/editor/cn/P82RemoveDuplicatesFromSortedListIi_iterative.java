//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表 
// 👍 384 👎 0

package leetcode.editor.cn;

import java.util.List;

//Java：删除排序链表中的重复元素 II
public class P82RemoveDuplicatesFromSortedListIi_iterative{
    public static void main(String[] args) {
        Solution solution = new P82RemoveDuplicatesFromSortedListIi_iterative().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    ListNode(int x, ListNode next) { val = x; this.next = next; }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummyHead = new ListNode(-1, null);
        ListNode pre = dummyHead;
        ListNode cur = head.next;
        int val = head.val;
        while (cur != null) {
            if (val == cur.val) {
                while (cur != null && val == cur.val)
                    cur = cur.next;
                if (cur == null)
                    return dummyHead.next;
                val = cur.val;
                if (cur.next == null)
                    pre.next = cur;
                cur = cur.next;
            } else {
                ListNode node = new ListNode(val, null);
                pre.next = node;
                pre = node;
                val = cur.val;
                if (cur.next == null)
                    pre.next = cur;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}