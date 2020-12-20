/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/12/20
*/

package my202012;
//import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;

public class my11 {
    public static void main(String[] args) {
        int[][]arr=new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j]=i*10+j;
            }
        }
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("=======提取出9宫格");
        show(arr);

    }

    // 这是一个函数示例
    public static void  show(int[][] arr) {
        int[]ge=new int[9];
        int count=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                count=0;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {

                        ge[count++]=arr[i*3+k][j*3+l];
                    }
                }
                System.out.println(Arrays.toString(ge));
            }

        }



    }


}
