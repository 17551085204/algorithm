//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2928 👎 0

package com.leetcode.tempfilepath.leetcode.editor.cn;

import java.util.ArrayList;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();

        System.out.println(solution.longestPalindrome("123214"));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        // leetcode答案，动态规划算法
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }



    // 提交不通过
    public String longestPalindrome2(String str) {

        String result="";
        // 获取str所有的子串，同时筛选出回文串
        ArrayList<String> substrings = new ArrayList<>(); // 保存str所有的子串
        int index=0;
        while (index<=str.length()){
            for (int i = index+1; i <=str.length() ; i++) {
                if(huiwen(str.substring(index,i))){
                    substrings.add(str.substring(index,i));
                }
            }
            index++;
        }
        result=substrings.get(0);
        for (String substring : substrings) {
            if(substring.length()>result.length()){
                result=substring;
            }
        }

        return result;
    }
    // 判断一个字符串是否是回文串
    private boolean huiwen(String substring) {
        StringBuilder stringBuilder = new StringBuilder(substring);
        String reverse = stringBuilder.reverse().toString();
        return reverse.equals(substring);

    }



}
//leetcode submit region end(Prohibit modification and deletion)

}