/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/12/13
*/

package my202012;
//import java.util.Scanner;

import java.util.Stack;

public class my05 {
    public static void main(String[] args) {
        System.out.println(isValid("{[]}()"));


    }

    // 判断括号是否正确
    public static boolean isValid(String str) {

      Stack<Character> characters = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='('||str.charAt(i)=='{'||str.charAt(i)=='['){
                characters.push(str.charAt(i));
            }else{
                if(characters.size()>0) {
                    String temp = "" + characters.pop() + str.charAt(i);
                    if (!(temp.equals("()") || temp.equals("{}") || temp.equals("[]"))) {
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
       return characters.size()==0;

    }


}
