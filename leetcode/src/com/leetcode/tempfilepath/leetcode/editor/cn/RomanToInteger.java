//罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。 
//
// 字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + I
//I 。 
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况： 
//
// 
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 
// 
//
// 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。 
//
// 
//
// 示例 1: 
//
// 输入: "III"
//输出: 3 
//
// 示例 2: 
//
// 输入: "IV"
//输出: 4 
//
// 示例 3: 
//
// 输入: "IX"
//输出: 9 
//
// 示例 4: 
//
// 输入: "LVIII"
//输出: 58
//解释: L = 50, V= 5, III = 3.
// 
//
// 示例 5: 
//
// 输入: "MCMXCIV"
//输出: 1994
//解释: M = 1000, CM = 900, XC = 90, IV = 4. 
//
// 
//
// 提示： 
//
// 
// 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。 
// IC 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。 
// 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。 
// 
// Related Topics 数学 字符串 
// 👍 1121 👎 0

package com.leetcode.tempfilepath.leetcode.editor.cn;
public class RomanToInteger {
    public static void main(String[] args) {
        Solution solution = new RomanToInteger().new Solution();
        int res=solution.romanToInt("MCMXCIV");
        System.out.println(res);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 不能处理复杂的字符串，比如包含XC这样的子串
    public int romanToInt(String s) {
        if(s.equals("IV")){
           return 4;
        }else if(s.equals("IX")){
            return 9;
        }else if(s.equals("XL")){
            return 40;
        }else if(s.equals("XC")){
            return 90;
        }else if(s.equals("CD")){
            return 400;
        }else if(s.equals("CM")){
            return 900;
        }

        // 下面的for循环只能到chars.length-1，所以最后一位的判断
        // 会有问题，这里提前在s最后添加一个字符，可以除去最后一位
        // 字符的影响
        s=s+"I";
        int res=0;
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length-1;i++) {
            if(chars[i]=='I'){
                if(chars[i+1]=='V'){
                    res+=4;
                    i++;
                }else if(chars[i+1]=='X'){
                    res+=9;
                    i++;
                }else{
                    res+=1;
                }

            }else if(chars[i]=='V'){
                res+=5;
            }else if(chars[i]=='X'){
                if(chars[i+1]=='L'){
                    res+=40;
                    i++;
                }else if(chars[i+1]=='C'){
                    res+=90;
                    i++;
                }else{
                    res+=10;
                }

            }else if(chars[i]=='L'){
                res+=50;
            }else if(chars[i]=='C'){
                if(chars[i+1]=='D'){
                    res+=400;
                    i++;
                }else if(chars[i+1]=='M'){
                    res+=900;
                    i++;
                }else{
                    res+=100;
                }

            }else if(chars[i]=='D'){
                res+=500;
            }else if(chars[i]=='M'){
                res+=1000;
            }
        }

        return res;

    }



}
//leetcode submit region end(Prohibit modification and deletion)

}