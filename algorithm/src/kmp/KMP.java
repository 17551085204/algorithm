/*
 * @Author hdk
 * @QQ:2890241339
 **/
package kmp;

import java.util.Arrays;

public class KMP {
    public static void main(String[] args) {
        String str1="dhuifbwifwhuifg";String str2="huifg";
        System.out.println(kmp(str1,str2,kmpNext(str2)));// 10

    }

    // 输入 原串和子串，以及子串的部分匹配表
    // 返回-1代表没有匹配到，否则返回第一次出现的位置
    public  static int kmp(String str1,String str2,int[]next){
        // 遍历
        for (int i = 0,j=0; i < str1.length(); i++) {

            // 需要考虑str1.charAt(i)！=str2.charAt(j)
            // kmp核心代码
            while (j>0 && str1.charAt(i)!=str2.charAt(j)){
                j=next[j-1];
            }

            if(str1.charAt(i)==str2.charAt(j)){
                j++;
            }
            if(j==str2.length()){
                return i-j+1;
            }

        }


        return -1;
    }

    // 获取子串的部分匹配值
    public static int[] kmpNext(String dest){
        int[]next=new int[dest.length()];
        next[0]=0; // dest长度为1时，部分匹配值是0
        for (int i = 1,j=0; i <dest.length() ; i++) {
            // 如果下面条件不满足，需要从next[j-1]获得j
            // 直到下列情况满足
            while (j>0&&dest.charAt(i)!=dest.charAt(j)){
                j=next[j-1];
            }

            // 下面情况部分匹配值+1
            if(dest.charAt(i)==dest.charAt(j)){
                j++;
            }
            next[i]=j;
        }
        return next;

    }

}
