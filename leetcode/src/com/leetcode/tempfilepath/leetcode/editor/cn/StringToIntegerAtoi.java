//请你来实现一个 atoi 函数，使其能将字符串转换成整数。 
//
// 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下： 
//
// 
// 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。 
// 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。 
// 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。 
// 
//
// 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。 
//
// 在任何情况下，若函数不能进行有效的转换时，请返回 0 。 
//
// 提示： 
//
// 
// 本题中的空白字符只包括空格字符 ' ' 。 
// 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231, 231 − 1]。如果数值超过这个范围，请返回 INT_MAX (231
// − 1) 或 INT_MIN (−231) 。 
// 
//
// 
//
// 示例 1: 
//
// 输入: "42"
//输出: 42
// 
//
// 示例 2: 
//
// 输入: "   -42"
//输出: -42
//解释: 第一个非空白字符为 '-', 它是一个负号。
//     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
// 
//
// 示例 3: 
//
// 输入: "4193 with words"
//输出: 4193
//解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
// 
//
// 示例 4: 
//
// 输入: "words and 987"
//输出: 0
//解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
//     因此无法执行有效的转换。 
//
// 示例 5: 
//
// 输入: "-91283472332"
//输出: -2147483648
//解释: 数字 "-91283472332" 超过 32 位有符号整数范围。 
//     因此返回 INT_MIN (−231) 。
// 
// Related Topics 数学 字符串 
// 👍 904 👎 0

package com.leetcode.tempfilepath.leetcode.editor.cn;
public class StringToIntegerAtoi {
    public static void main(String[] args) {
        Solution solution = new StringToIntegerAtoi().new Solution();
        System.out.println(solution.myAtoi(" A -13"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        // leetcode提供的答案
        public int myAtoi(String str) {
            char[] chars = str.toCharArray();
            int n = chars.length;
            int idx = 0;
            while (idx < n && chars[idx] == ' ') {
                // 去掉前导空格
                idx++;
            }
            if (idx == n) {
                //去掉前导空格以后到了末尾了
                return 0;
            }
            boolean negative = false;
            if (chars[idx] == '-') {
                //遇到负号
                negative = true;
                idx++;
            } else if (chars[idx] == '+') {
                // 遇到正号
                idx++;
            } else if (!Character.isDigit(chars[idx])) {
                // 其他符号
                return 0;
            }
            int ans = 0;
            while (idx < n && Character.isDigit(chars[idx])) {
                int digit = chars[idx] - '0';
                if (ans > (Integer.MAX_VALUE - digit) / 10) {
                    // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
                    // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
                    return negative? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                ans = ans * 10 + digit;
                idx++;
            }
            return negative? -ans : ans;
        }



        // 无法提交通过。。。
    public int myAtoi2(String s) {
        String temp="";
        s=s.trim();
        char[]chars=s.toCharArray();
        if(!(chars[0]<='9'&&chars[0]>='0' || chars[0]=='-')){
            return 0;
//            throw new RuntimeException("无法转换");
        }else{
            if(s.charAt(0)=='-'){
                int i=chars.length;
                for (int j =1 ; j < chars.length; j++) {
                    if (!(chars[j]<='9' && chars[j]>='0')){
                        i=j;
                        break;
                    }
                }

                temp="-"+s.substring(1,i);
                if(temp.length()==1){
                    return 0;
//                    throw new RuntimeException("无法转换");
                }else{
                    double tem=Integer.parseInt(temp);
                    if(tem<Integer.MIN_VALUE){
                        return Integer.MIN_VALUE;
                    }else {
                        return Integer.parseInt(temp);
                    }
                }

            }else{
                int i=chars.length;
                for (int j =0 ; j < chars.length; j++) {
                    if (!(chars[j]<='9' && chars[j]>='0')){
                        i=j;
                        break;
                    }
                }

                temp=s.substring(0,i);
                double tem=Integer.parseInt(temp);
                if(tem>Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }else {
                    return Integer.parseInt(temp);
                }



            }
        }




    }
}
//leetcode submit region end(Prohibit modification and deletion)

}