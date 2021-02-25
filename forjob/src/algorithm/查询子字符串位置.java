/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2021/2/13
*/

package algorithm;
//import java.util.Scanner;

public class 查询子字符串位置 {
    public static void main(String[] args) {
        System.out.println(findIndexOfSubStr("hello","lo"));


    }




    /**
     * 判断一个字符串str1中是否包含另一个子字符串str2，如果有，返回第一次出现的位置，如果没有，返回-1
     * @param str1
     * @param str2
     * @return
     */
    public static int findIndexOfSubStr(String str1,String str2){
        char[] source=str1.toCharArray();
        char[] target=str2.toCharArray();
        int sourceOffset=0;
        int sourceCount=source.length;
        int targetOffset=0;
        int targetCount=target.length;
        int fromIndex=0;
        int res=indexOf(source, sourceOffset,  sourceCount,
                target, targetOffset,  targetCount, fromIndex);
        return res;

    }

    // 判断一个字符串中是否包含另一个子字符串，如果有，返回第一次出现的位置，如果没有，返回-1
    // 下面是jdk1.8源码
    public  static int indexOf(char[] source, int sourceOffset, int sourceCount,
                       char[] target, int targetOffset, int targetCount,
                       int fromIndex) {
        if (fromIndex >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return fromIndex;
        }

        char first = target[targetOffset]; // 子串的第一个字符
        int max = sourceOffset + (sourceCount - targetCount);// 最多需要比较到的索引位置

        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first);
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j]
                        == target[k]; j++, k++);

                if (j == end) {
                    /* Found whole string. */
                    return i - sourceOffset;
                }
            }
        }
        return -1;
    }



}
