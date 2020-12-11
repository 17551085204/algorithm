//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 9646 👎 0

package com.leetcode.tempfilepath.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 用暴力法，双重循环，很容易解决问题，但是效率低
 *
 * 考虑使用双指针法解决，需要首先深拷贝原数组，然后对数组进行排序
 * 使用循环找到符合的2个数字，然后找到这2个数字在原数组中的位置，并将其返回
 *
 *
 * 利用HashMap，不是很懂
 *
 */

public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        int[]nums={1,2,3,3};
        int target=6;
        System.out.println(Arrays.toString(solution.twoSum(nums,target)));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // 采用最简单的双重循环的方法实现
    public int[] twoSum2(int[] nums, int target) {
        int[]result=new int[2];
        result[0]=-1;result[1]=-1;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j]==target){
                    result[0]=i;result[1]=j;
                    return result;
                }
            }
        }
        return result;
    }

    // leetcode 提供的答案，不清晰。。。
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    // leetcode 提供的答案，双指针法
    // 需要复制一份原数组，应该是深拷贝，然后需要数组排序
    public int[] twoSum(int[] nums, int target) {
        int m = 0, n = 0, k, board = 0;
        int[] res = new int[2];
        int[] tmp1 = new int[nums.length];// 保存初始数组
        System.arraycopy(nums, 0, tmp1, 0, nums.length);
        Arrays.sort(nums);// 对数组进行排序，然后利用双指针进行不断累加2个数字，并与target比较
        for (int i = 0, j = nums.length - 1; i < j; ) {
            if (nums[i] + nums[j] < target)
                i++;
            else if (nums[i] + nums[j] > target)
                j--;
            else if (nums[i] + nums[j] == target) {
                m = i; // nums[m]就是结果数组的第一个元素
                n = j; // nums[n]就是结果数组的第二个元素
                break;
            }
        }

        // 找到nums[m]这个数字在原数组中的索引
        for (k = 0; k < nums.length; k++) {
            if (tmp1[k] == nums[m]) {
                res[0] = k;
                break;
            }
        }
        // 找到nums[n]这个数字在原数组中的索引
        for (int i = 0; i < nums.length; i++) {
            if (tmp1[i] == nums[n] && i != k)// 注意这里的条件
                res[1] = i;
        }
        return res;

    }

}
//leetcode submit region end(Prohibit modification and deletion)

}

