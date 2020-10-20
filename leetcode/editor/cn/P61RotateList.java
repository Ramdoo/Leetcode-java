//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
// 
//
// 示例 2: 
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL 
// Related Topics 链表 双指针 
// 👍 355 👎 0

package leetcode.editor.cn;
//Java：旋转链表
public class P61RotateList {
    public static void main(String[] args) {
        Solution solution = new P61RotateList().new Solution();
        ListNode dummyHead = new ListNode(0, null);
        ListNode cur = dummyHead;
        for (int i = 1; i <= 5; ++i) {
            ListNode node = new ListNode(i,null);
            cur.next = node;
            cur = node;
        }
        ListNode result = solution.rotateRight(dummyHead.next, 200000003);
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
static public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    ListNode(int x, ListNode next) { val = x; this.next = next; }
}
/**
 *  本质上是将尾部向前数第K个元素作为头，原来的头接到原来的尾上
 *  若 k > length， 则 k = k % length
 */
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next ==null || k == 0)
                return head;
            int len = 0;
            ListNode dummyHead = new ListNode(-1, head);
            ListNode tail = dummyHead;
            while (tail.next != null) {
                tail = tail.next;
                ++len;
            }
            k = k % len;
            if (k == 0)
                return head;
            ListNode left = dummyHead;
            ListNode right = dummyHead;
            for (int i = 0; i < k; ++i) {
                right = right.next;
            }
            while (right != tail) {
                left = left.next;
                right = right.next;
            }
            dummyHead.next = left.next;
            left.next = null;
            right.next = head;
            return dummyHead.next;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}