//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
// 
//
// 示例 2： 
//
// 
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
// 
//
// 示例 3： 
//
// 
//输入：digits = [0]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// 
// Related Topics 数组 
// 👍 581 👎 0

package com.leetcode.tempfilepath.leetcode.editor.cn;

public class PlusOne {
    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();
//        int[] digits={9,8,7,6,5,4,3,2,1,0};
//        int[] ints = solution.plusOne(digits);
//        System.out.println(Arrays.toString(ints));


    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        //输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。

      // 采用转为数字的方式
//    public int[] plusOne2(int[] digits) {
//        double res=0;
//        for (int i = 0; i < digits.length; i++) {
//            res=res*10+digits[i];
//        }
//        String str=new BigDecimal(res+1+"").toString();
//        if(str.contains(".")){
//            str=str.substring(0,str.length()-2);
//        }
//        System.out.println(str);
//        int[]arr=new int[str.length()];
//        char[] chars = str.toCharArray();
//        for (int i = 0; i < arr.length; i++) {
//            arr[i]=chars[i]-48;
//        }
//
//        return  arr;
//
//    }

        // 直接利用数组解决
    public int[] plusOne(int[] digits) {
        // 这个循环用来判断从最低位到最高位，是否是9，存在有一位不是9，就可以返回
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;// 如果最后一位不是9，直接将最后一位数+1，然后返回
        }
        // 如果所有位数都是9
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;

    }





}
//leetcode submit region end(Prohibit modification and deletion)

}