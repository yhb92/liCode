//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 
// 👍 1230 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _78_子集{
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private Set<Integer> set = new HashSet<>();
    List<List<Integer>> value = new ArrayList<>();


    /**
     * 思路：
     *   1.将数组枚举
     *   2.每一个数都有两种情况(选/不选)
     *   3.采用递归(没一层都选一个数在分两种情况递归(选/不选))
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        factorial(nums,0);
        return value;
    }

    private void factorial(int[] nums,int index){
        // 1.递归到最后一层后 添加结果
        if (index == nums.length) {
            value.add(new ArrayList<>(set));
            return;
        }
//        System.out.println("====== index :" + index);

        // 2. 选了数据添加到列表中保存
        set.add(nums[index]);
        factorial(nums,index + 1);
        // 由于选的数据在最内存已经被添加到结果中了所一需要取出 以免下边 不选的递归重复选择
        // 3 添加结果后list中还保留了已经被选的数据需要删除他
//        System.out.println("========" + index);
        set.remove(nums[index]);

        // 4.不选
        factorial(nums,index + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    
}
  