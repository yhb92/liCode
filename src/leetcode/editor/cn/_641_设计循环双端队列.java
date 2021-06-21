//设计实现双端队列。 
//你的实现需要支持以下操作： 
//
// 
// MyCircularDeque(k)：构造函数,双端队列的大小为k。 
// insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。 
// insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。 
// deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。 
// deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。 
// getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。 
// getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。 
// isEmpty()：检查双端队列是否为空。 
// isFull()：检查双端队列是否满了。 
// 
//
// 示例： 
//
// MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
//circularDeque.insertLast(1);			        // 返回 true
//circularDeque.insertLast(2);			        // 返回 true
//circularDeque.insertFront(3);			        // 返回 true
//circularDeque.insertFront(4);			        // 已经满了，返回 false
//circularDeque.getRear();  				// 返回 2
//circularDeque.isFull();				        // 返回 true
//circularDeque.deleteLast();			        // 返回 true
//circularDeque.insertFront(4);			        // 返回 true
//circularDeque.getFront();				// 返回 4
//  
//
// 
//
// 提示： 
//
// 
// 所有值的范围为 [1, 1000] 
// 操作次数的范围为 [1, 1000] 
// 请不要使用内置的双端队列库。 
// 
// Related Topics 设计 队列 
// 👍 81 👎 0


package leetcode.editor.cn;

public class _641_设计循环双端队列{

//leetcode submit region begin(Prohibit modification and deletion)
class MyCircularDeque {
    // 数据存储
    private int[] arr;
    // 开始位置
    private int first = 0;
    // 数据存储量
    private int size = 0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        if (k < 0) throw new IllegalArgumentException();
        arr = new int[k];
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        return add(0,value);
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        return add(size,value);
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        delete(0);
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        delete(size - 1);
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()) return -1;
        return arr[first];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) return -1;
        return arr[conversionIndex(size - 1)];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == arr.length;
    }


    private void removeIndexOutOfBound(int index){
        if (index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * 转化索引位置
     * @param index
     * @return
     */
    private int conversionIndex(int index){
        int len = first + index;
        if (len >= arr.length){
            return len - arr.length;
        }
        return len;
    }

    /**
     * 删除指定位置
     * @param index
     * @return
     */
    private int delete(int index){
        removeIndexOutOfBound(index);

        int conversionIndex = conversionIndex(index);
        int value = arr[conversionIndex];
        if (first == conversionIndex) {
            // 删除的是第一个
            if (first == arr.length - 1) {
                first = 0;
            } else {
                first++;
            }
        }else {
            // 删除中间数据
            for (int i = index; i < size - 1;i++){
                int currentIndex = conversionIndex(i);
                int nextIndex = conversionIndex(i + 1);
                arr[currentIndex] = arr[nextIndex];
            }
        }
        size--;
        return value;
    }

    /**
     * 添加到指定位置
     * @param index
     * @param value
     * @return
     */
    private boolean add(int index,int value){
        if (isFull()){
            return false;
        }

        int conversionIndex = conversionIndex(index);
        if (first == conversionIndex){
            // 头部添加
            if (first != 0){
                arr[--first] = value;
            }else {
                first = arr.length - 1;
                arr[first] = value;
            }
        }else {
            // 其他位置 （0 < index < size）
            for (int i = size - 1; i >= index;i++){
                int oldIndex = conversionIndex(i);
                int newIndex = conversionIndex(i + 1);
                arr[newIndex] = arr[oldIndex];
            }
        }
        arr[conversionIndex] = value;
        size++;
        return true;
    }

}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)
public static void main(String[] args) {


    MyCircularDeque deque = new _641_设计循环双端队列().new MyCircularDeque(3);
    deque.insertFront(5);
    deque.insertLast(7);

    System.out.println(deque.getFront());;
    deque.insertLast(3);
    System.out.println(deque.getRear());
    System.out.println(deque.isFull());
    System.out.println(deque.deleteLast());
    System.out.println(deque.insertFront(4));
    System.out.println(deque.getFront());

}

}

