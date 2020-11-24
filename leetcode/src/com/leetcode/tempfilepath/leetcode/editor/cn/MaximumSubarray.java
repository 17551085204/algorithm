//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2641 👎 0

package com.leetcode.tempfilepath.leetcode.editor.cn;

import java.util.ArrayList;

public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
        int[]nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution.maxSubArray(nums));


    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        // leetcode提供的答案
        public int maxSubArray(int[] nums) {
            int pre = 0, maxAns = nums[0];
            for (int x : nums) {
                pre = Math.max(pre + x, x);
                maxAns = Math.max(maxAns, pre);
            }
            return maxAns;
        }






// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

        // 代码还是有些问题，提交失败
    public int maxSubArray2(int[] nums) {
         if(nums.length==1){
             return nums[0];
         }

         ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                integers.add(getSum(nums,i,j));
            }
        }
        int max=integers.get(0);
        for (int i = 1; i < integers.size(); i++) {
            if(max<integers.get(i)){
                max=integers.get(i);
            }
        }

        return max;
    }

        private int getSum(int[] nums, int i, int j) {
            int res=0;
            for (int k = i; k <= j; k++) {
                res+=nums[k];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}