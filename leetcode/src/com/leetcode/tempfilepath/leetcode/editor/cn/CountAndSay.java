//给定一个正整数 n ，输出外观数列的第 n 项。 
//
// 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。 
//
// 你可以将其视作是由递归公式定义的数字字符串序列： 
//
// 
// countAndSay(1) = "1" 
// countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。 
// 
//
// 前五项如下： 
//
// 
//1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
//第一项是数字 1 
//描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
//描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
//描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
//描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
// 
//
// 要 描述 一个数字字符串，首先要将字符串分割为 最小 数量的组，每个组都由连续的最多 相同字符 组成。然后对于每个组，先描述字符的数量，然后描述字符，形成
//一个描述组。要将描述转换为数字字符串，先将每组中的字符数量用数字替换，再将所有描述组连接起来。 
//
// 例如，数字字符串 "3322251" 的描述如下图： 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 1
//输出："1"
//解释：这是一个基本样例。
// 
//
// 示例 2： 
//
// 
//输入：n = 4
//输出："1211"
//解释：
//countAndSay(1) = "1"
//countAndSay(2) = 读 "1" = 一 个 1 = "11"
//countAndSay(3) = 读 "11" = 二 个 1 = "21"
//countAndSay(4) = 读 "21" = 一 个 2 + 一 个 1 = "12" + "11" = "1211"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 30 
// 
// Related Topics 字符串 
// 👍 601 👎 0

package com.leetcode.tempfilepath.leetcode.editor.cn;

import java.util.ArrayList;

public class CountAndSay {
    public static void main(String[] args) {
        Solution solution = new CountAndSay().new Solution();
        System.out.println(solution.countAndSay(4));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        // leetcode提供的答案
        public String countAndSay(int n) {
            // 递归终止条件
            if (n == 1) {
                return "1";
            }
            StringBuffer res = new StringBuffer();
            // 拿到上一层的字符串
            String str = countAndSay(n - 1);
            int length = str.length();
            // 开始指针为0
            int start = 0;
            // 注意这从起始条件要和下面长度统一
            for (int i = 1; i < length + 1; i++) {
                // 字符串最后一位直接拼接
                if (i == length) {
                    res.append(i - start).append(str.charAt(start));
                    // 直到start位的字符串和i位的字符串不同，拼接并更新start位
                } else if (str.charAt(i) != str.charAt(start) ) {
                    res.append(i - start).append(str.charAt(start));
                    start = i;
                }
            }
            return res.toString();
        }




        //第一项是数字 1
//描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
//描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
//描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
//描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"

    public String countAndSay2(int n) {
        String[]strings=new String[n+1];
        strings[0]="1";
        for (int i = 1; i < n+1; i++) {
            strings[i]=description(strings[i-1]);
        }
        return strings[n-1];
    }

    // 对一个字符串进行描述
    public  String description(String s) {
        String result="";
        ArrayList<ArrayList<Character>>a=my_split(s);
        ArrayList<String>a1=new ArrayList<>();
        for(int i=0;i<a.size();i++){
            a1.add(a.get(i).size()+"");
            a1.add( ""+a.get(i).get(0));
        }
        for(int i=0;i<a1.size();i++){
            result+=a1.get(i);
        }

        return result;

    }

    public  ArrayList<ArrayList<Character>>  my_split(String s) {
            char[]s_list=s.toCharArray();
            ArrayList<ArrayList<Character>> result=new ArrayList<>();
            ArrayList<Character>tep=new ArrayList<>();
            result.add(tep);

            if(s_list.length>1){
                int k=0;
                result.get(k).add(s_list[0]);
                for(int i=0;i<s_list.length-1;i++){

                    if(s_list[i+1]!=s_list[i]){
                        k++;
                        ArrayList<Character>tep1=new ArrayList<>();
                        result.add(tep1);
                        result.get(k).add(s_list[i+1]);

                    }else{
                        result.get(k).add(s_list[i]);
                    }

                }

                return result;
            }else{
                result.get(0).add(s_list[0]);
                return result;
            }


        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}