/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/7
*/

package sort;
//import java.util.Scanner;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {


    public static void main(String[] args) {
        // 插入排序的简单测试
//        int []arr={3,-1,101,34,119,1};
//        System.out.println("排序前"+Arrays.toString(arr));
//        insert(arr);
//        System.out.println("排序后"+Arrays.toString(arr));


        // 测试插入排序的时间
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
        insert(arr);


        Date currentTime1 = new Date();
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString1 = formatter1.format(currentTime1);
        System.out.println("排序后系统时间："+dateString1);
        long time2 = System.currentTimeMillis();
        System.out.println("数组长度为"+max+",耗时"+(time2-time1)+"ms");



    }

    // 这是一个函数示例
    public static void insert(int []arr) {
        for (int i = 0; i < arr.length-1; i++) {// 大的循环次数
            // 待插入的数
            int insertVal=arr[i+1];
            int insertIndex=i;// 待插入数的前一个数
            // 给insertVal 找到一个插入的位置
            while (insertIndex>=0 && insertVal<arr[insertIndex]){// 前一个条件保证不越界
                // 后一个条件说明还没找到合适的插入位置
                // 需要将arr[insertIndex]后移
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;

            }
            // 退出循环时，插入位置找到 insertIndex+1
            // 加一步优化
            if(insertIndex!=i){
                arr[insertIndex+1]=insertVal;
            }

        }

        // 分析过程
//        // 待插入的数
//        int insertVal=arr[1];
//        int insertIndex=0;// 待插入数的前一个数
//        // 给insertVal 找到一个插入的位置
//        while (insertIndex>=0 && insertVal<arr[insertIndex]){// 前一个条件保证不越界
//            // 后一个条件说明还没找到合适的插入位置
//            // 需要将arr[insertIndex]后移
//            arr[insertIndex+1]=arr[insertIndex];
//            insertIndex--;
//
//        }
//        // 退出循环时，插入位置找到 insertIndex+1
//        arr[insertIndex+1]=insertVal;


    }

}


