//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 378 👎 0

package com.leetcode.tempfilepath.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
        System.out.println(solution.generate(5));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>res =new ArrayList<>();
        if(numRows==0){
            return res;
        }

        List<Integer>list1=new ArrayList<>();
        list1.add(1);
        List<Integer>list2=new ArrayList<>();
        list2.add(1);list2.add(1);
        res.add(list1);
        if(numRows==1){
            return res;
        }
        res.add(list2);
        if (numRows==2){
            return res;
        }

        for (int i = 2; i < numRows; i++) {
            List<Integer>temp=new ArrayList<>();
            temp.add(1);
            for (int j = 0; j < res.get(i-1).size()-1; j++) {
                temp.add(res.get(i-1).get(j)+res.get(i-1).get(j+1));
            }
            temp.add(1);
            res.add(temp);
        }


        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}