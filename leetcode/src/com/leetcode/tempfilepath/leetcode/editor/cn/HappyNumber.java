//编写一个算法来判断一个数 n 是不是快乐数。 
//
// 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
//如果 可以变为 1，那么这个数就是快乐数。 
//
// 如果 n 是快乐数就返回 True ；不是，则返回 False 。 
//
// 
//
// 示例： 
//
// 输入：19
//输出：true
//解释：
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
// 
// Related Topics 哈希表 数学 
// 👍 492 👎 0

package com.leetcode.tempfilepath.leetcode.editor.cn;
public class HappyNumber {
    public static void main(String[] args) {
        Solution solution = new HappyNumber().new Solution();
        System.out.println(solution.isHappy(19));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isHappy(int n) {
        boolean flag=true;
        int count =0;
        while (n!=1){
            if(count==10){
                flag=false;
                break;
            }
            count++;
            n=cal(n);

        }

        return flag;
    }

    // 将n每一位上的数提取出来，求平方和
    public int cal(int n){
        int res=0;
        char[] chars = (n + "").toCharArray();
        for (int i = 0; i < chars.length; i++) {
            res+=(chars[i]-48)*(chars[i]-48);
        }
        return res;

    }


}
//leetcode submit region end(Prohibit modification and deletion)

}