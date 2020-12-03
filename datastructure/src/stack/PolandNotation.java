/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/5
*/

package stack;
//import java.util.Scanner;

//import jnr.ffi.annotations.In;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        // 给定一个中缀表达式,不能有小数点，不能有空格
        String fixExpr="1+((22+3)*4)-5";
        // 得到对应的后缀表达式
        String suffixExpr=fix2suffix(fixExpr);
        // 思路，将表达式装入ArrayList中，传递给一个方法，配合栈
        // 完成计算
        List<String> listString = getListString(suffixExpr);
        int calculate = calculate(listString);
        System.out.println(fixExpr+"="+calculate);



    }


    //方法：将 中缀表达式转成对应的List
    public static List<String> toInfixExpressionList(String s) {
        //定义一个List,存放中缀表达式 对应的内容
        List<String> ls = new ArrayList<String>();
        int i = 0; //这时是一个指针，用于遍历 中缀表达式字符串
        String str; // 对多位数的拼接
        char c; // 每遍历到一个字符，就放入到c
        do {
            //如果c是一个非数字，我需要加入到ls
            if((c=s.charAt(i)) < 48 ||  (c=s.charAt(i)) > 57) {
                ls.add("" + c);
                i++; //i需要后移
            } else { //如果是一个数，需要考虑多位数
                str = ""; //先将str 置成"" '0'[48]->'9'[57]
                while(i < s.length() && (c=s.charAt(i)) >= 48 && (c=s.charAt(i)) <= 57) {
                    str += c;//拼接
                    i++;
                }
                ls.add(str);
            }
        }while(i < s.length());
        return ls;//返回
    }


    // 将中缀表达式转为后缀表达式
    public static String fix2suffix(String fixExpr){
        List<String> listString = toInfixExpressionList(fixExpr);
        // 定义2个栈，第二个栈不需要pop，后面还要逆序，用list简单
        Stack<String> s1 = new Stack<>();
        ArrayList<String> s2 = new ArrayList<>();
        // 开始处理
        for(String item:listString){
            // 如果是一个数
            if(item.matches("\\d+")){
                s2.add(item);
            }else if(item.equals("(")){
                s1.push(item);
            }else if(item.equals(")")){
                while(!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop(); // 消掉一对括号
            }else{
                // item的优先级小于等于栈顶的优先级
                while (s1.size()!=0 && Operation.getVal(s1.peek())>=Operation.getVal(item)){
                    s2.add(s1.pop());
                }
                s1.push(item);// item需要入栈

            }

        }
        // 将s1中剩余的加入s2
        while (s1.size()!=0){
            s2.add(s1.pop());
        }
        // s2就是后缀表达式
        String result="";
        for (int i=0;i<s2.size();i++) {
            if(i!=s2.size()-1){
                result+=s2.get(i)+" ";
            }else{
                result+=s2.get(i);
            }
        }


        return result;
    }




    // 计算后缀表达式
    public static int calculate(List<String>ls){
        // 只需要一个栈即可
       Stack<String> stack = new Stack<>();
       for(String item:ls){
           // 使用正则表达式得到数字
           if(item.matches("\\d+")){// 匹配多位数字
               stack.push(item);
           }else{
               // 弹出2个数计算
               int num2=Integer.parseInt(stack.pop());
               int num1=Integer.parseInt(stack.pop());
               int res=0;
               if(item.equals("+")){
                   res=num1+num2;
               }else if(item.equals("-")){
                   res=num1-num2;
               }else if(item.equals("*")){
                   res=num1*num2;
               }else if(item.equals("/")){
                   res=num1/num2;
               }else{
                   throw new RuntimeException("运算符有问题");
               }
               // 将结果入栈
               stack.push(res+"");

           }

       }
       // 栈中最后剩下的数据就是计算结果
       return Integer.parseInt(stack.pop());


    }



    // 将后缀表达式依次将数据和操作符放入List中
    public static List<String> getListString(String suffixExpr){
       String[] split = suffixExpr.split(" ");
       List<String>list=new ArrayList<>();
       for(String ele:split){
           list.add(ele);
       }
        return list;

    }



}

// 运算符对应的优先级
class Operation{
    private static int add=1;
    private static int sub=1;
    private static int mul=2;
    private static int div=2;

    // 返回优先级对应的数字
    public static int getVal(String ope){
        int res=0;
        if(ope.equals("+")){
            res=add;
        }else if(ope.equals("-")){
            res=sub;
        }else if(ope.equals("*")){
            res=mul;
        }else if(ope.equals("/")){
            res=div;
        }
        return res;

    }

}


