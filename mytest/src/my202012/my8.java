/*
 * @Author hdk
 * @QQ:2890241339
 **/
package my202012;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class my8 {
    public static void main(String[] args) {
        my8 test = new my8();
        System.out.println(test.Permutation("aab"));


    }


    // 实现字符串的全排列，同时去重
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<String>();
        if(str == null || str.length() <= 0)
            return res;
        HashSet<String> set = new HashSet<String>(); //结果去重
        dfs(set, str.toCharArray(), 0);
        res.addAll(set);
        Collections.sort(res);
        return res;
    }

    public void dfs(HashSet<String> set, char [] str, int k){
        if(k == str.length){  //得到结果
            set.add(new String(str));
            return ;
        }
        for(int i = 0; i < str.length; i ++){
            swap(i, k, str);
            dfs(set, str, k + 1);
            swap(i, k, str);  //回溯
        }
    }

    public void swap(int i, int j, char [] str){
        if(i != j){
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }


}
