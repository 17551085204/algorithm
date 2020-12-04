//给定一个整数数组，判断是否存在重复元素。 
//
// 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3,1]
//输出: true 
//
// 示例 2: 
//
// 输入: [1,2,3,4]
//输出: false 
//
// 示例 3: 
//
// 输入: [1,1,1,3,3,4,3,2,4,2]
//输出: true 
// Related Topics 数组 哈希表 
// 👍 313 👎 0

package com.leetcode.tempfilepath.leetcode.editor.cn;

import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicate().new Solution();
        int[]nums={1,2,3,11};
        System.out.println(solution.containsDuplicate(nums));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // 有重复元素就返回true
    public boolean containsDuplicate(int[] nums) {
        boolean flag=false;
        HashSet<Object> objects = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!objects.contains(nums[i])){
                objects.add(nums[i]);
            }else{
                flag=true;
                break;
            }
        }

        return flag;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}