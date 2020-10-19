//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表 
// 👍 769 👎 0

package leetcode.editor.cn;
//Java：K 个一组翻转链表
public class P25ReverseNodesInKGroup{
    public static void main(String[] args) {
        Solution solution = new P25ReverseNodesInKGroup().new Solution();
        ListNode head = new ListNode(1, null);
        ListNode cur = head;
        for (int i = 2; i < 6; ++i) {
            ListNode node = new ListNode();
            node.val = i;
            cur.next = node;
            cur = cur.next;
        }
        for (ListNode n = head; n != null; n = n.next) {
            System.out.println(n.val);
        }
        int k = 2;
        head = solution.reverseKGroup(head, k);
        if (head == null)
            System.out.println("111");
        for (ListNode n = head; n != null; n = n.next) {
            System.out.println(n.val);
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
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode[] reverseList(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode tailNext = tail.next;
        ListNode cur = head;
        while (cur != tailNext) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[] {tail, head};
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode pre = dummyHead;
        ListNode tail = dummyHead;
        while (tail != null) {
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null)
                    return dummyHead.next;
            }
            ListNode nex = tail.next;
            ListNode[] reverse = reverseList(head, tail);
            head = reverse[0];
            tail = reverse[1];
            pre.next = head;
            tail.next = nex;
            head = nex;
            pre = tail;
        }
        return dummyHead.next;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}