//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表 
// 👍 413 👎 0

package leetcode.editor.cn;
//Java：删除排序链表中的重复元素
public class P83RemoveDuplicatesFromSortedList{
    public static void main(String[] args) {
        Solution solution = new P83RemoveDuplicatesFromSortedList().new Solution();
        ListNode head = new ListNode(1, null);
        ListNode cur  = head;
        ListNode node = new ListNode(1, null);
        cur.next = node;
        cur = node;
        node = new ListNode(2, null);
        cur.next = node;
        cur = node;
        node = new ListNode(3, null);
        cur.next = node;
        cur = node;
        node = new ListNode(3, null);
        cur.next = node;
        cur = node;
        ListNode result = solution.deleteDuplicates(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 */
public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    ListNode(int x, ListNode next) { val = x; this.next = next; }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        if (head.val == head.next.val) {
            head = deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}