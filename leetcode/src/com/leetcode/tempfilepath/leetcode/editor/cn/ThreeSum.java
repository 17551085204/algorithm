//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2811 👎 0

package com.leetcode.tempfilepath.leetcode.editor.cn;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        int[]nums={-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum2(nums));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // leetcode提供的答案
        // 在一个外层循环内部设置双指针，注意，去重的条件设置很重要
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;// 简单情况，直接处理
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            // 设置双指针
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }


        //  可以run,但无法通过提交
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>>result=new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer>temp=new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        Collections.sort(temp);
                        result.add(temp);
                    }
                }
            }
        }
        result=distinct(result);

        return result;

    }

    //去除重复元素
    private List<List<Integer>> distinct(List<List<Integer>> result) {
        List<List<Integer>>list=new ArrayList<>();
        Set<List<Integer>> set=new HashSet<>();
        for (List<Integer> integers : result) {
            set.add(integers);
        }
        for (List<Integer> integers : set) {
            list.add(integers);
        }
        return list;

    }


    }
//leetcode submit region end(Prohibit modification and deletion)

}