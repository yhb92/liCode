//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 进阶： 
//
// 
// 你可以设计一个只使用常数额外空间的算法来解决此问题吗？ 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2,3,4,5], k = 1
//输出：[1,2,3,4,5]
// 
//
// 示例 4： 
//
// 
//输入：head = [1], k = 1
//输出：[1]
// 
//
// 
// 
//
// 提示： 
//
// 
// 列表中节点的数量在范围 sz 内 
// 1 <= sz <= 5000 
// 0 <= Node.val <= 1000 
// 1 <= k <= sz 
// 
// Related Topics 链表 
// 👍 1140 👎 0

package leetcode.editor.cn;

public class _25_K个一组翻转链表{

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = new ListNode(1);
        ListNode prv = head;
        for (int i = 2;i < 6;i++){
            ListNode node = new ListNode(i);
            prv.next = node;
            prv = node;
        }

        new Solution().reverseKGroup(head,3);
    }


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
    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            // 上一组尾节点
            ListNode prvGroupTailNode = null;
            // 下一组头部节点
            ListNode groupHead = head;
            // 第一组反转后头节点
            ListNode firstNode = head;
            // 是否是第一组（==0）
            int groupSize = 0;
            // 分组记录
            int size = 1;
            while (head != null){
                // 取K个链表数据组成一组
                if (size == k){
                    // 取出下一组的头节点
                    ListNode nextGroupHead = head.next;
                    // 反转链表
                    ListNode reverseGroup = reverse(groupHead,k);
                    if (groupSize++ == 0){
                        firstNode = reverseGroup;
                    }
                    // 将上一组的尾节点指向当前反转组的头节点 并返回当前组的尾节点
                    prvGroupTailNode = group(prvGroupTailNode,reverseGroup,k);
                    // 记录下一组的头节点
                    groupHead = nextGroupHead;
                    head = nextGroupHead;
                    size = 1;
                }else {
                    head = head.next;
                    size++;
                }

            }
            // 2.将未反转的节点链接上
            if (prvGroupTailNode != null){
                prvGroupTailNode.next = groupHead;
            }

            return firstNode;
        }

        /**
         * 1.将上一组的尾巴节点指向当前组的头节点
         * @param prvTailNode
         * @param headNode
         * @param k
         * @return
         */
        private ListNode group(ListNode prvTailNode, ListNode headNode,int k){
            if (prvTailNode != null){
                prvTailNode.next = headNode;
            }
            ListNode tailNode = headNode;
            while (k > 1){
                tailNode = tailNode.next;
                k--;
            }
            return tailNode;
        }

        /**
         * 反转链表
         * @param head
         * @return
         */
        private ListNode reverse(ListNode head,int k){
            ListNode node = null;
            while (k  > 0){
                ListNode next = head.next;
                head.next = node;
                node = head;
                head = next;
                k--;
            }
            return node;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static class ListNode {
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
  