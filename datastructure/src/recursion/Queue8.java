/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/6
*/

package recursion;
//import java.util.Scanner;
// 8皇后问题
// 使用1维数组解决问题，arr[i]=val, 代表i+1个皇后放在第i+1行
// val+1列

public class Queue8 {
    int max=8;// 表示有多少个皇后
    static int count;
    static  int judgeCount;
    int[]array=new int[max]; // 保存结果

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println("总共的摆法:"+count+"种");
        System.out.println("判断是否冲突的次数为:"+judgeCount);


    }

    // 放置第n个皇后
    private void check(int n){
        if(n==max){// 说明已经放好了所有皇后
            print();
            count++;
            return;

        }
        // 放入皇后，判断是否有冲突
        for (int i = 0; i < max; i++) {
            // 把当前皇后放在第一列
            array[n]=i;
            if(judge(n)){// 不冲突
                // 接着放
                check(n+1);
            }
            //若冲突，继续执行array[n]=i,将第n个皇后放在本行的后移的位置

        }

    }


    // 查看当我们放置第n个皇后时，会不会有冲突
    // n 代表放置第n个皇后
    private  boolean judge(int n){
        judgeCount++;
        for (int i = 0; i < n; i++) {
            // 判断第n个皇后和前面的n-1个皇后是否在同一列，是否在斜线
            if(array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false; // 有冲突

            }
        }
        return true; // 没有冲突

    }


    // 将皇后摆放的位置打印输出
    private void print(){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();


    }


}


