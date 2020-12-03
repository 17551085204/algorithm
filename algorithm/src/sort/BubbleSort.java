/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/7
*/

package sort;
//import java.util.Scanner;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class BubbleSort {
    public static void main(String[] args) {
        // 冒泡排序的简单测试
//        int []arr={11,2,3,14,5};
//        System.out.println("排序前"+Arrays.toString(arr));
//        bubble(arr);
//        System.out.println("排序后"+Arrays.toString(arr));


        // 测试冒泡排序的时间
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

        // 冒泡排序算法
        bubble(arr);


        Date currentTime1 = new Date();
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString1 = formatter1.format(currentTime1);
        System.out.println("排序后系统时间："+dateString1);
        long time2 = System.currentTimeMillis();
        System.out.println("数组长度为"+max+",耗时"+(time2-time1)+"ms");




    }

   public  static void bubble(int[] arr){
        boolean flag=false; // 用来标识,表示是否进行过交换
        for (int i = 0; i < arr.length-1; i++) {
           for (int j = 0; j < arr.length-i-1; j++) {
               if(arr[j]>arr[j+1]){// 交换
                   flag=true;
                   int temp=arr[j];
                   arr[j]=arr[j+1];
                   arr[j+1]=temp;
               }
           }
//           System.out.println("第"+(i+1)+"趟排序后结果:"+Arrays.toString(arr));
           if(flag==false){// 没有发生交换
               break;
           }else {
               flag=false; // 重置flag，进行下一次判断
           }

        }
   }

}
