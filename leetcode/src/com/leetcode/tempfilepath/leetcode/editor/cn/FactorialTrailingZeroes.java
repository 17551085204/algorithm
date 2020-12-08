//给定一个整数 n，返回 n! 结果尾数中零的数量。 
//
// 示例 1: 
//
// 输入: 3
//输出: 0
//解释: 3! = 6, 尾数中没有零。 
//
// 示例 2: 
//
// 输入: 5
//输出: 1
//解释: 5! = 120, 尾数中有 1 个零. 
//
// 说明: 你算法的时间复杂度应为 O(log n) 。 
// Related Topics 数学 
// 👍 386 👎 0

package com.leetcode.tempfilepath.leetcode.editor.cn;

import java.math.BigInteger;

public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        Solution solution = new FactorialTrailingZeroes().new Solution();
        System.out.println(solution.trailingZeroes(5));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //leetcode提供的答案
        public int trailingZeroes(int n) {
            int zeroCount = 0;
            for (int i = 5; i <= n; i += 5) {
                int currentFactor = i;
                while (currentFactor % 5 == 0) {
                    zeroCount++;
                    currentFactor /= 5;
                }
            }
            return zeroCount;
        }


        // 容易想到的思路，先计算阶乘，然后求解尾部0的个数，但是不仅
        // 复杂，而且提交不通过。。。
//    public int trailingZeroes2(int n) {
//        // Calculate n!
//        BigInteger nFactorial = BigInteger.ONE;
//        for (int i = 2; i <= n; i++) {
//            nFactorial = nFactorial.multiply(BigInteger.valueOf(i));
//        }
//
//        // Count how many 0's are on the end.
//        int zeroCount = 0;
//        while (nFactorial.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
//            nFactorial = nFactorial.divide(BigInteger.TEN);
//            zeroCount++;
//        }
//        return zeroCount;
//
//
//
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}