//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 
// 👍 871 👎 0

package com.leetcode.tempfilepath.leetcode.editor.cn;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
        int[]nums={1,2,3};
        solution.nextPermutation2(nums);
        System.out.println(Arrays.toString(nums));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public void nextPermutation2(int[] nums) {



    }





        // leetcode提供的答案
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int length = nums.length;
        int index1 = length - 2;

    /*
        从 倒数第2个元素 开始，向前遍历：
            1、若 当前元素 < 后面的元素(存在下一个更大的排列)：
                1）找到大于当前元素的最后一个元素，记录其下标
                2）交换 选中的两个数组元素
                3）转置后续的元素(保证 后续元素“升序排列”，即 当前排列表示的数“最小”)
            2、反之(不存在下一个更大的排列):
                则 继续循环
        若 未找到，则 当前排列为 最大排列，转置后返回即可
     */
        while (index1 >= 0) {
            if (nums[index1] < nums[index1 + 1]) {
                int index2 = length - 1;
            /*
                找到 大于当前元素 的 最后一个元素
             */
                while (index2 > index1 && nums[index2] <= nums[index1]) {
                    index2--;
                }
                exchange(nums, index1, index2);
                reverse(nums, index1 + 1, length - 1);
                return;
            }
            index1--;
        }
        reverse(nums, 0, length - 1);
    }

    /**
     * 将 指定数组，从 指定开始位置，到 指定结束位置，进行 原地转置
     * @param nums 指定数组
     * @param startIndex 指定开始位置
     * @param endIndex 指定结束位置
     */
    private void reverse(int[] nums, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            exchange(nums, startIndex++, endIndex--);
        }
    }

    /**
     * 将 指定数组 的 指定下标的两个元素，进行 原地交换
     * @param nums 指定数组
     * @param index1 指定元素下标
     * @param index2 指定元素下标
     */
    private void exchange(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}