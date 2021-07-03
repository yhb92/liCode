//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 
// 👍 739 👎 0

package leetcode.editor.cn;

import java.util.*;

public class _47_全排列II{
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 存值
    private List<Integer> set = new ArrayList<>();
    // 保存值
    private List<List<Integer>> values = new ArrayList<>();
    // 防止索引位置相同的重复取值
    private Set<Integer> indexCache = new HashSet<>();

    /**
     * 思路：
     *    1.使用一个MAP对象来存储相同数据的坐标
     *    2.保存取过的数据数据
     *    3.递归获取遍历数据"同一级"有相同的数据被执行过就跳过(这样可以排除多余数据 如下图)
     *             start
     *         /     \     \
     *        1      1       2
     *      /   \   /  \    /  \
     *     1    2  1   2   1    1
     *     |    |  |   |   |    |
     *     2    1  2   1   1    1
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {

        // 递归调用
        recursion(nums);

        return values;
    }


    private void recursion(int[] nums){
        // 1.结束条件
        if (set.size() == nums.length){
            values.add(new ArrayList<>(set));
            return;
        }

        // 2.保存同一级数据(有相同的值就跳过)
        Set<Integer> cache = new HashSet<>();
        // 3.遍历数据
        for (int i = 0;i < nums.length;i++){
            if (indexCache.contains(i)) continue;
            if (cache.contains(nums[i])) continue;
            cache.add(nums[i]);

            // 4.递归到下一层(一个存值，一个存索引)
            set.add(nums[i]);
            indexCache.add(i);
            recursion(nums);
            // 5.还原现场
            set.remove(set.size() - 1);
            indexCache.remove(i);

        }


    }

}
//leetcode submit region end(Prohibit modification and deletion)

    
    
}
  