/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/7
*/

package sortalgorithm;
//import java.util.Scanner;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {
        // 选择排序的简单测试
//        int []arr={-11,2,-3,14,5};
//        System.out.println("排序前"+Arrays.toString(arr));
//        select(arr);
//        System.out.println("排序后"+Arrays.toString(arr));


        // 测试选择排序的时间
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        System.out.println("排序前系统时间："+dateString);
        long time1 = System.currentTimeMillis();
        int max=80000;
        int []arr=new int[max];
        for (int i = 0; i <max ; i++) {
            arr[i]=max-i;
        }

        // 排序算法
        select(arr);


        Date currentTime1 = new Date();
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString1 = formatter1.format(currentTime1);
        System.out.println("排序后系统时间："+dateString1);
        long time2 = System.currentTimeMillis();
        System.out.println("数组长度为"+max+",耗时"+(time2-time1)+"ms");



    }

    // 这是一个函数示例
    public static void select(int []arr) {
        for (int i = 0; i < arr.length-1; i++) {// 大的排序次数
            int min=arr[i]; // 假定这一轮中的最小值
            int minIndex=i; // 假定这轮中最小值的下标
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[j]<min){
                    min=arr[j];
                    minIndex=j;
                }
            } // 循环结束后，就得到了本轮的最小值对应的下标
            // 将本轮中最小值与arr[i]进行交换
            // 就是每一轮都会将剩余数组元素中最小的值移动到最前面
            if(minIndex!=i){
                int temp=arr[i];
                arr[i]=arr[minIndex];
                arr[minIndex]=temp;
            }



        }



    }


}
