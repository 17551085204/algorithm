/*
 * @Author hdk
 * @QQ:2890241339
 **/
package my202012;

import java.util.ArrayList;
import java.util.List;

public class my06 {
    public static void main(String[] args) {
        List<String>res=new ArrayList<>();
        dfs(0,0,3,res,"");
        System.out.println(res.size());
        System.out.println(res);

    }

    /**
     *
     * 产生括号
     */
    public static void dfs(int left, int right, int n, List<String>res,String str){
        if(left==n&&right==n){
            res.add(str);
            return;
        }

        if(right>left)return;////若右括号当前数量大于左括号当前数量，剪枝
        if(left<n){
           dfs(left+1,right,n,res,str+"(");
        }
        if(right<left){
            dfs(left,right+1,n,res,str+")");
        }

    }


}
