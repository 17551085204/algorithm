/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/6
*/

package recursion;
//import java.util.Scanner;

public class recursionTest {
    public static void main(String[] args) {
        printTest(4);
        System.out.println(jiecheng(5));

    }

  // 打印问题
    public  static void printTest(int n){
        if(n>2){
            printTest(n-1);
        }
        System.out.println(n);
    }

    // 阶乘问题
    public static  int jiecheng(int n){
        if(n==1){
            return 1;
        }
        return n*jiecheng(n-1);
    }


}
