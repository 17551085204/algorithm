/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/17
*/

package dynamic;
//import java.util.Scanner;

import java.util.Arrays;

public class KnapsackProblem {
    public static void main(String[] args) {

        int[]w={1,4,3};// 物品的重量
        int[]val={1500,3000,2000};// 物品的价值
        int m=4; // 背包的容量
        int n=val.length; // 物品的个数

        // 为了记录放入商品的情况，定义一个二维数组
        int[][]path=new int[n+1][m+1];


        // 创建二维数组,v[i][j]代表在前i个物品中能够装入容量为j的背包中的最大价值
        int[][]v=new int[n+1][m+1];
        // 初始化第一行与第一列
        for (int i = 0; i < v.length; i++) {
            v[i][0]=0;// 第一列设置为0
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i]=0;// 第一行设置为0
        }

        // 动态规划处理
        for (int i = 1; i < v.length; i++) {// 不处理第一行和第一列
            for (int j = 1; j < v[0].length; j++) {
                if(w[i-1]>j){// 这里需要i-1,保证索引从0开始
                    v[i][j]=v[i-1][j];
                }else{ // 还是因为索引的问题，所以val和w在取值时，都是i-1
//                    v[i][j]=Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
                    if(v[i-1][j]>=val[i-1]+v[i-1][j-w[i-1]]){
                        v[i][j]=v[i-1][j];
                    }else{
                        v[i][j]=val[i-1]+v[i-1][j-w[i-1]];
                        path[i][j]=1;
                    }

                }

            }
        }




        // 处理之后，背包打印
        for (int[] ints :v) {
            System.out.println(Arrays.toString(ints));
        }

        // 打印路径,需要逆向遍历
        int i = path.length-1;
        int j =path[i].length-1;
        while (i>0&&j>0){
            if(path[i][j]==1){
                System.out.println("第"+i+"个商品放入背包");
                j-=w[i-1];
            }
            i--;

        }


    }

}
