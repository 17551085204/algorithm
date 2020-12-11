//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：height = [4,3,2,1,4]
//输出：16
// 
//
// 示例 4： 
//
// 
//输入：height = [1,2,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// n = height.length 
// 2 <= n <= 3 * 104 
// 0 <= height[i] <= 3 * 104 
// 
// Related Topics 数组 双指针 
// 👍 2044 👎 0

package com.leetcode.tempfilepath.leetcode.editor.cn;
public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();
        int[]height={1,8,6,2,5,4,8,3,7};
        System.out.println(solution.maxArea(height));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int maxArea(int[] height) {
        int left=0;int right=height.length-1;
        int max=0;
        while(left<right){
            // 计算2个指针之间包围出的面积
            // 这一操作，等价于矮的柱子与剩余的柱子都匹配一下
            // 并且由于指针是位于边缘，所以这一次得到的结果一定是最大的
            // 所以要想得到更大的面积，不可能是高柱子对应的指针移动，只能
            // 去移动矮的柱子对应的指针
            int temp=Math.min(height[left],height[right])*(right-left);
            // 不断更新最大的面积
            max=Math.max(temp,max);
            // 双指针移动的规则
            if(height[left]<=height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }

    //leetcode提供答案，双指针
    public int maxArea2(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}