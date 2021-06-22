//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2460 👎 0

package leetcode.editor.cn;

public class _20_有效的括号{

    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {

        char[] chars = s.toCharArray();
        Queue queue = new Queue();
        for (int i = chars.length - 1;i >= 0;i--){
            char c = chars[i];
            if (c == ')' || c == ']' || c == '}'){
                queue.push(c);
            }else {
                char old = queue.pop();
                if (old == ' '
                        || old == ')' && c != '('
                        || old == ']' && c != '['
                        || old == '}' && c != '{'){
                    return false;
                }
            }
        }

        return queue.isEmpty();

    }

    class Queue{
        private Node head;
        private int size = 0;

        public Queue(){
        }

        public void push(char val){
            head = new Node(val,head);
            size++;
        }

        public char pop(){
            if (head != null) {
                Node node = head;
                head = head.next;
                size--;
                return node.val;
            }
            return ' ';
        }

        public boolean isEmpty(){
            return size == 0;
        }

        class Node{

            char val;

            Node next;

            public Node(){

            }

            public Node(char val){
                this.val = val;
            }

            public Node(char val,Node next){
                this.val = val;
                this.next = next;
            }

        }

    }


}
//leetcode submit region end(Prohibit modification and deletion)




    
    
}
  