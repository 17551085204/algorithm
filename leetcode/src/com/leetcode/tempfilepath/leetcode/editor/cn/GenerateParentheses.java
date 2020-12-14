//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1468 👎 0

package com.leetcode.tempfilepath.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        // leetcode 提供的答案， 深度优先，递归回溯
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<String>();
            String sb = "";
            dfs(0, 0, n, res, sb);
            return res;

        }

        //left表示左括号当前个数 right表右括号当前个数
        public void dfs(int left, int right, int n, List<String> res, String sb) {

            if (left == n && right == n) {
                res.add(sb);
                return;
            }
            if (right > left) return; //若右括号当前数量大于左括号当前数量，剪枝
            if (left < n) dfs(left + 1, right, n, res, sb + "(");
            if (right < left) dfs(left, right + 1, n, res, sb + ")");
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}