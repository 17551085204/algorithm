/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/1
*/

package sparsearray;
//import java.util.Scanner;

import java.util.Arrays;



// 实现二维数组转稀疏数组以及稀疏数组转二维数组
public class SparseArray1 {
    public static void main(String[] args) {
        // 创建一个原始的二维数组 11*11
        // 0表示无淇，1表示黑子，2表示蓝子
        int[][]chessArr1=new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        chessArr1[5][8]=1;
//        System.out.println(Arrays.deepToString(chessArr1));
        // 输出原始的二维数组
        System.out.println("原始的二维数组");
        for(int[]temp:chessArr1){
            System.out.println(Arrays.toString(temp));
        }
        // 将二维数组转为稀疏数组
        // 1,先得到有效数据，非0
        int sum=0;
        for (int i = 0; i <chessArr1.length ; i++) {
            for (int j = 0; j <chessArr1[0].length ; j++) {
                if(chessArr1[i][j]!=0){
                    sum++;
                }
            }
        }
        System.out.println("原始二维数组中非0值个数");
        System.out.println(sum);
        // 2，创建稀疏数组
        int[][]sparseArr=new int[sum+1][3];
        // 给稀疏数组赋值
        sparseArr[0][0]=chessArr1.length;
        sparseArr[0][1]=chessArr1[0].length;
        sparseArr[0][2]=sum;

        int count=0; // 记录是第几个非0数据
        for (int i = 0; i <chessArr1.length ; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if(chessArr1[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArr1[i][j];

                }
            }
        }

        // 输出稀疏组
        System.out.println("稀疏数组");
        for(int[]temp:sparseArr){
            System.out.println(Arrays.toString(temp));
        }

        // 根据稀疏数组还原为原数组
        int[][]chessArr2=new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
                chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }

        // 输出  恢复后的数组
        System.out.println("恢复后的数组");
        for(int[]temp:chessArr2){
            System.out.println(Arrays.toString(temp));
        }


    }


}
