//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组 
// 👍 199 👎 0

package com.leetcode.tempfilepath.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangleIi().new Solution();
        System.out.println(solution.getRow(3));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>>res =new ArrayList<>();

        List<Integer>list1=new ArrayList<>();
        list1.add(1);

        List<Integer>list2=new ArrayList<>();
        list2.add(1);list2.add(1);


        res.add(list1);
        res.add(list2);


        for (int i = 2; i <= rowIndex; i++) {
            List<Integer>temp=new ArrayList<>();
            temp.add(1);
            for (int j = 0; j < res.get(i-1).size()-1; j++) {
                temp.add(res.get(i-1).get(j)+res.get(i-1).get(j+1));
            }
            temp.add(1);
            res.add(temp);
        }

//        System.out.println(res);

        return res.get(rowIndex);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}