//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 296 👎 0

package com.leetcode.tempfilepath.leetcode.editor.cn;
public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));


    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // 输入: "A man, a plan, a canal: Panama"
//输出: true
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        if(s.equals("")){
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(char ch:s.toCharArray()){
            if((ch<='9'&&ch>='0')||(ch<='z'&&ch>='a')){
                stringBuilder.append(ch);
            }
        }
        String s1=stringBuilder.toString();
        String s2=stringBuilder.reverse().toString();
        return s1.equals(s2);


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}