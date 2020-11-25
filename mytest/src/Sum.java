/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/24
*/

//import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {

        System.out.println(sum(100));

    }

    // 这是一个函数示例
    public static  int sum(int n) {
        // 可以按照需要修改逻辑代码
        int res=0;
        for (int i = 1; i <= n; i++) {
            res+=i;
        }
        return res;
    }


}
