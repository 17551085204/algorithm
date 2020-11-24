//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4618 👎 0

package com.leetcode.tempfilepath.leetcode.editor.cn;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abbc"));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        // leetcode提供的答案，滑动窗口
        public  int lengthOfLongestSubstring(String s) {
            int n = s.length(), ans = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int end = 0, start = 0; end < n; end++) {
                char alpha = s.charAt(end);
                if (map.containsKey(alpha)) {
                    start = Math.max(map.get(alpha), start);
                }
                ans = Math.max(ans, end - start + 1);
                map.put(s.charAt(end), end + 1);
            }
            return ans;
        }



        // 提交不通过
        public int lengthOfLongestSubstring2(String str) {
        if(str.equals("")){
            return 0;
        }

        // 获取str所有的子串，同时筛选出不包含重复字符的
        // 获取所有筛选后子串的长度，获取其中的最大值
        ArrayList<String> substrings = new ArrayList<>(); // 保存str所有的子串
        int index=0;
        while (index<=str.length()){
            for (int i = index+1; i <=str.length() ; i++) {
                if(noRepeat(str.substring(index,i))){
                    substrings.add(str.substring(index,i));
                }
            }
            index++;
        }
        // 将所有不含重复字符的子串的长度保存在数组中
        int[] lengths=new int[substrings.size()];
        for (int i = 0; i < lengths.length; i++) {
            lengths[i]=substrings.get(i).length();
        }
        // 数组的最大值就是结果
        int max=lengths[0];
        for (int i = 1; i < lengths.length; i++) {
            if(lengths[i]>max){
                max=lengths[i];
            }
        }

        return max;
    }
        // 判断一个字串是否不包含重复字符  abc,true  aa,false
        public   boolean noRepeat(String str){
            boolean flag=true;
            char[] arr = str.toCharArray();
            //创建HashMap，key为数组中的值，value为值重复出现的次数
            Map<Character,Integer> map = new HashMap<>();
            for(int i=0;i<arr.length;i++){
                //通过map.get()方法，获取map中是否已经存在该值，如果存在则通过key取到value并加一，否则key值为1
                map.put(arr[i], map.get(arr[i]) == null?1:map.get(arr[i])+1);
            }

            //遍历map的集合  1.通过Set方法获取key的集合
            Set<Character> key = map.keySet();
            //利用Iterator
            Iterator<Character> it = key.iterator();
            while(it.hasNext()) {
                Character keys = it.next();
                if(map.get(keys)>1){
                    return  false;
                }
            }

            return flag;

        }



}
//leetcode submit region end(Prohibit modification and deletion)

}