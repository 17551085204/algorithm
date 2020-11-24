//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下： 
//
// L   C   I   R
//E T O E S I I G
//E   D   H   N
// 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// string convert(string s, int numRows); 
//
// 示例 1: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIRETOESIIGEDHN"
// 
//
// 示例 2: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G 
// Related Topics 字符串 
// 👍 914 👎 0

package com.leetcode.tempfilepath.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new ZigzagConversion().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        // leetcode提供的答案，方向调转
    public String convert(String s, int numRows) {
        if(numRows < 2) return s; // 如果只排1行，直接将s输出即可
        List<StringBuilder> rows = new ArrayList<>(); // 保存排序后每一行的结果
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());// 初始化
        int i = 0, flag = -1;
        // 这个循环的思路很巧妙，每次都是在第一行和最后一行改变flag，防止row.get(i)超出
        // 且刚好按照需要的格式将s中每一个字符都放到了它应该在的位置
        for(char c : s.toCharArray()) {// 取出s中所有字符
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) flag = - flag; // 第一行和最后一行，将flag调转
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}