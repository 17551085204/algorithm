//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。 
//
// 返回被除数 dividend 除以除数 divisor 得到的商。 
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2 
//
// 
//
// 示例 1: 
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3 
//
// 示例 2: 
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2 
//
// 
//
// 提示： 
//
// 
// 被除数和除数均为 32 位有符号整数。 
// 除数不为 0。 
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。 
// 
// Related Topics 数学 二分查找 
// 👍 460 👎 0

package com.leetcode.tempfilepath.leetcode.editor.cn;
public class DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new DivideTwoIntegers().new Solution();
        System.out.println(solution.divide(-22,3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // leetcode提供的答案
    public int divide(int dividend, int divisor) {
            boolean sign = (dividend > 0) ^ (divisor > 0);
            int result = 0;
            if(dividend>0) {
                dividend = -dividend;
            }
            if(divisor>0) divisor = -divisor;
            while(dividend <= divisor) {
                int temp_result = -1;
                int temp_divisor = divisor;
                while(dividend <= (temp_divisor << 1)) {
                    if(temp_divisor <= (Integer.MIN_VALUE >> 1))break;
                    temp_result = temp_result << 1;
                    temp_divisor = temp_divisor << 1;
                }
                dividend = dividend - temp_divisor;
                result += temp_result;
            }
            if(!sign) {
                if(result <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
                result = - result;
            }
            return result;
        }


    // 无法提交通过
    public int divide2(int dividend, int divisor) {
        if(dividend==0){
            return 0;
        }

       if((dividend>0&&divisor>0)||(dividend<0&&divisor<0)){
           dividend=Math.abs(dividend);
           divisor=Math.abs(divisor);
           int count=-1;
           for (int i = 0; i <=dividend; ) {
               count++;
               i+=divisor;
           }
           return count;
       }else if((dividend>0&&divisor<0)||(dividend<0&&divisor>0)){
           dividend=Math.abs(dividend);
           divisor=Math.abs(divisor);
           int count=-1;
           for (int i = 0; i <=dividend; ) {
               count++;
               i+=divisor;
           }
           return -count;
       }

       return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}