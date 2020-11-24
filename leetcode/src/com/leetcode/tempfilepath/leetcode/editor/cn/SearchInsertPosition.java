//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找 
// 👍 742 👎 0

package com.leetcode.tempfilepath.leetcode.editor.cn;


public class SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new SearchInsertPosition().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
// 输入: [1,3,5,6], 7
//输出: 4
    public int searchInsert(int[] nums, int target) {
        if(target<nums[0]){
            return 0;
        }
        if(target>nums[nums.length-1]){
            return nums.length;
        }

        int i = myBinarySearch(nums, target);
        if(i>=0){// 代表在数组中找到了该元素
            return i;
        }else{
            for (int j = 0; j < nums.length-1; j++) {
                if(nums[j]<target && nums[j+1]>target ){
                    return j+1;
                }
            }
        }
        return -1;

    }

    public int myBinarySearch(int[]nums,int target){
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }

        }


        return -1;
    }





}
//leetcode submit region end(Prohibit modification and deletion)

}