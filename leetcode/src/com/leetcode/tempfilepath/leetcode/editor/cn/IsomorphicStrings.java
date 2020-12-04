//给定两个字符串 s 和 t，判断它们是否是同构的。 
//
// 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。 
//
// 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。 
//
// 示例 1: 
//
// 输入: s = "egg", t = "add"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "foo", t = "bar"
//输出: false 
//
// 示例 3: 
//
// 输入: s = "paper", t = "title"
//输出: true 
//
// 说明: 
//你可以假设 s 和 t 具有相同的长度。 
// Related Topics 哈希表 
// 👍 270 👎 0

package com.leetcode.tempfilepath.leetcode.editor.cn;


import java.util.HashMap;

public class IsomorphicStrings {
    public static void main(String[] args) {
        Solution solution = new IsomorphicStrings().new Solution();
        System.out.println(solution.isIsomorphic("ab","aa"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        // leetcode 提供的答案
        public boolean isIsomorphic(String s, String t) {
            int n = s.length();
            int[] mapS = new int[128];
            int[] mapT = new int[128];
            for (int i = 0; i < n; i++) {
                char c1 = s.charAt(i);
                char c2 = t.charAt(i);
                //当前的映射值是否相同
                if (mapS[c1] != mapT[c2]) {
                    return false;
                } else {
                    //是否已经修改过，修改过就不需要再处理
                    if (mapS[c1] == 0) {
                        mapS[c1] = i + 1;
                        mapT[c2] = i + 1;
                    }
                }
            }
            return true;
        }



        // 有漏洞，无法提交通过
    public boolean isIsomorphic2(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            t=replace(t,t.charAt(i),s.charAt(i),i);
        }
//        System.out.println(s+" "+t);

        return s.equals(t);
    }

        /**
         *
         * @param t  原始字符串
         * @param c1 原始字符串中需要被替换的字符
         * @param c2  替换的新字符
         * @param index 从原始字符串的哪一个位置开始
         * @return
         */
    public String replace(String t,char c1,char c2,int index){
        String res=t.substring(0,index);
        for (int i = index; i < t.length(); i++) {
            if(t.charAt(i)==c1){
                res+=c2;
            }else{
                res+=t.charAt(i);
            }
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}