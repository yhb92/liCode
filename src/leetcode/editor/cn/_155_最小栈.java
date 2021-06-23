//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 
// 👍 934 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class _155_最小栈{
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

    private int [] arr;

    private int size;

    private Node node;

    /** initialize your data structure here. */
    public MinStack() {
        arr = new int[10];
    }

    /**
     * 思路：添加数据时取最小值入栈
     * （因为在栈时先进后出的只要最小值没有被弹出来就会一直是其时最小值）
     * @param val
     */
    public void push(int val) {
        capacity();
        arr[size++] = val;

        push2(val);

    }

    /**
     * 最小值保存方式
     * @param val
     */
    private void push2(int val){
        if (node == null){
            node = new Node(val,null);
        }else {
            int min = Math.min(node.val,val);
            node = new Node(min,node);
        }
    }

    /**
     * 链表排序方式 效率低
     * @param val
     */
    private void push1(int val){
        if (node == null){
            node = new Node(val,null);
        }else {
            Node head = node;
            Node prv = null;
            boolean mark = true;
            while (head != null){
                if (head.val >= val){
                    Node newNode = new Node(val,head);
                    if (prv == null){
                        node = newNode;
                    }else {
                        prv.next = newNode;
                    }
                    mark = false;
                    break;
                }
                prv = head;
                head = head.next;
            }

            if (mark){
                prv.next = new Node(val,null);
            }

        }
    }

    /**
     * 思路：由于栈中永远保存的是当前的最小值 因此字需要弹出即可
     */
    public void pop() {
        int val = arr[size - 1];
        pop2();
        size--;
    }

    private void pop2(){
        if (node != null){
            node = node.next;
        }
    }

    /**
     * 链表排序方式
     * @param val
     */
    private void pop1(int val){
        Node head = node;
        Node prv = null;
        while (head != null){
            if (head.val == val){
                if (prv == null){
                    node = head.next;
                }else {
                    prv.next = head.next;
                }
                break;
            }
            prv = head;
            head = head.next;
        }
    }
    
    public int top() {
        return arr[size - 1];
    }
    
    public int getMin() {
        if (node == null) return -9999;
        return node.val;
    }

    private void capacity(){
        if (size == arr.length){
            arr = Arrays.copyOf(arr,arr.length << 1);
        }
    }

    /**
     * 维护最小值了链表
     */
    class Node{
        int val;
        Node next;

        public Node(){

        }

        public Node(int val,Node next){
            this.val = val;
            this.next = next;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

    
    
}
  