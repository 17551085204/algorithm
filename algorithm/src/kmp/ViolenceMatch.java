/*
 * @Author hdk
 * @QQ:2890241339
 **/
package kmp;

// 暴力匹配法

public class ViolenceMatch {
    public static void main(String[] args) {
        System.out.println(violenceMatch("hello","ll"));


    }
    public static int violenceMatch(String str1,String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int s1len=s1.length;int s2len=s2.length;
        int i=0;int j=0;  // 分别指向s1和s2
        while(i<s1len&&j<s2len){
            if(s1[i]==s2[j]){// 匹配成功
                i++;j++;
            }else{
                i=i-(j-1);
                j=0;
            }
        }
        // 判断是否匹配成功
        if(j==s2len){
            return i-j;
        }else{
            return  -1;
        }


    }
    




}



