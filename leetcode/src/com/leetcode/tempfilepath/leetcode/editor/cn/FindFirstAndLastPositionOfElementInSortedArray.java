//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 775 👎 0

package com.leetcode.tempfilepath.leetcode.editor.cn;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[]nums = {7,7};
        int target = 7;
        System.out.println(Arrays.toString(solution.searchRange(nums,target)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4]

        // 采用最容易想到的方式，先正序遍历，找到目标值第一次出现的位置
        // 然后反向遍历，找到目标值最后一次出现的位置，如果找不到目标值，直接返回{-1，-1}
    public int[] searchRange(int[] nums, int target) {
        int[]res={-1,-1};
        int first=-1;
        int last=-1;
        // 得到第一个
        for (int i = 0; i < nums.length;i++ ) {
            if(nums[i]==target){
                first=i;
                break;
            }
        }
        if(first!=-1){
            for (int i = nums.length-1; i >=0 ; i--) {
                if(nums[i]==target){
                    last=i;
                    break;
                }
            }
            res[0]=first;res[1]=last;
            return res;

        }else{
            return res;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}