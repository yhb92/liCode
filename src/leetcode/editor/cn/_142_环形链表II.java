//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，po
//s 仅仅是用于标识环的情况，并不会作为参数传递到函数中。 
//
// 说明：不允许修改给定的链表。 
//
// 进阶： 
//
// 
// 你是否可以使用 O(1) 空间解决此题？ 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围在范围 [0, 104] 内 
// -105 <= Node.val <= 105 
// pos 的值为 -1 或者链表中的一个有效索引 
// 
// Related Topics 链表 双指针 
// 👍 1037 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _142_环形链表II {


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        /**
         * 思路：
         *   1.假设慢指针走的距离是 l + p 快指针走的距离是 l + P + r
         *     (其中l的尾部是闭环处 P尾部是快慢指针相遇点 注意：P和r都可能是跑了n圈的距离)
         *   2.那么有公式可的写成 2(l + p) = l + p + n(r + p)
         *      ==> 可推导处 (r + p)*(n - 1) + r = l
         *      (者l的距离等于n圈后 + r的距离，这就是为啥下边while循环要slow移动了)
         *
         * @param head
         * @return
         */
        public ListNode detectCycle(ListNode head) {

            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null){
                slow = slow.next;
                if (fast == slow){
                    // 从头部开始找
                    ListNode pre = head;
                    while (pre != slow){
                        pre = pre.next;
                        // 慢指针移动到和pre相遇的地方就是闭环节点
                        slow = slow.next;
                    }
                    return pre;
                }
                fast = fast.next.next;
            }

            return null;

        }

        /**
         * 数组判断
         * @param head
         * @return
         */
        private ListNode one(ListNode head){
            Map<ListNode,Integer> map = new HashMap<>();
            while (head != null){
                if(map.containsKey(head)){
                    return head;
                }
                map.put(head,0);
                head = head.next;
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
  