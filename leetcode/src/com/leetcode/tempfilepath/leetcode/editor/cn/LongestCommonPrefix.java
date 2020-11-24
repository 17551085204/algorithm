//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1351 👎 0

package com.leetcode.tempfilepath.leetcode.editor.cn;

import java.util.ArrayList;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        String[]str={"dog","doracecar","docar"};
        System.out.println(solution.longestCommonPrefix(str));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

//        输入: ["flower","flow","flight"]
        //输出: "fl"
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }

        // 获取字符串数组中最短字符串的长度
        int min=Integer.MAX_VALUE;
        for (String str : strs) {
            if(str.length()<min){
                min=str.length();
            }
        }
        // 不断存放相同的前缀字符
        ArrayList<Character>list=new ArrayList<>();
        for (int i = 0; i < min; i++) {
            // 暂时存放字符串数组所有字符串统一位置的字符
            char[]arr=new char[strs.length];
            // 如果arr中的内容全部相同，就可以将该位置的字符加入list
            for (int j = 0; j < strs.length; j++) {
                arr[j]=strs[j].charAt(i);
            }
            if(allEqu(arr)){
                 list.add(strs[0].charAt(i))  ;
            }else{
                break;
            }

        }
        // 将list中所有元素组合为string
        String res="";
        for (Character character : list) {
            res+=character;
        }
        return res;

    }

    // 判断 arr 数组的元素是否全部相同
    private boolean allEqu(char[] arr) {
        boolean flag=true;
        for (int i = 0; i <arr.length-1 ; i++) {
            if(arr[i]!=arr[i+1]){
                flag=false;
                break;
            }
        }
        return flag;
    }


    }
//leetcode submit region end(Prohibit modification and deletion)

}