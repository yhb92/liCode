//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 链表 
// 👍 1796 👎 0

package leetcode.editor.cn;

public class _206_反转链表 {


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {

        /**
         * 复杂度O(n)
         * 思路：
         *    1.使用指针指向上一个节点备用
         *    2.遍历链表临时保存当前节点备用
         *    3.将当前节点的下一个节点指向上一节点
         *    4.将当前下一节点作为当前节点（遍历）
         *    5.移动指针到当前节点作为下一节点的next节点
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {
            ListNode node = null;
            while (head != null){
                ListNode next = head.next;
                head.next = node;
                node = head;
                head = next;
            }
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public class ListNode {
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


}
  