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

public class ShellSort {
    public static void main(String[] args) {

        // shell排序的简单测试
//        int []arr={8,9,1,7,2,3,5,4,6,0};
//        System.out.println("排序前"+Arrays.toString(arr));
//        shell2(arr);
//        System.out.println("排序后"+Arrays.toString(arr));


        // 测试shell排序的时间
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
        shell2(arr);


        Date currentTime1 = new Date();
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString1 = formatter1.format(currentTime1);
        System.out.println("排序后系统时间："+dateString1);
        long time2 = System.currentTimeMillis();
        System.out.println("数组长度为"+max+",耗时"+(time2-time1)+"ms");


    }

    //  shell排序，交换法,效率较低，甚至不如简单的插入排序
    public static void shell(int []arr) {

        // 根据逐步分析，使用循环处理
        int temp=0;
        for(int gap=arr.length/2;gap>0;gap/=2){
            for (int i = gap; i < arr.length; i++) {
                // 遍历各组中所有的元素，共5组，每组2个元素
                for (int j = i-gap; j >=0 ; j-=gap) {
                    // 如果当前元素大于加上步长后的那个元素，说明要交换
                    if(arr[j]>arr[j+gap]){
                        temp=arr[j];
                        arr[j]=arr[j+gap];
                        arr[j+gap]=temp;
                    }
                }
            }
        }


        /*
        // 逐步推导
        // 第一轮排序将10个数据分为5组
        int temp=0;
        for (int i = 5; i < arr.length; i++) {
            // 遍历各组中所有的元素，共5组，每组2个元素
            for (int j = i-5; j >=0 ; j-=5) {
                // 如果当前元素大于加上步长后的那个元素，说明要交换
                if(arr[j]>arr[j+5]){
                    temp=arr[j];
                    arr[j]=arr[j+5];
                    arr[j+5]=temp;
                }
            }
        }
        // 第二轮排序将10个数据分为2组
        for (int i = 2; i < arr.length; i++) {
            // 遍历各组中所有的元素，共5组，每组2个元素
            for (int j = i-2; j >=0 ; j-=2) {
                // 如果当前元素大于加上步长后的那个元素，说明要交换
                if(arr[j]>arr[j+2]){
                    temp=arr[j];
                    arr[j]=arr[j+2];
                    arr[j+2]=temp;
                }
            }
        }
        // 第三轮排序将10个数据分为1组
        for (int i = 1; i < arr.length; i++) {
            // 遍历各组中所有的元素，共5组，每组2个元素
            for (int j = i-1; j >=0 ; j-=1) {
                // 如果当前元素大于加上步长后的那个元素，说明要交换
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
           */


    }


    //  shell排序，移位法，效率比简单的插入排序高了很多
    public static void shell2(int []arr) {
        // 在简单插入排序的基础上，使用缩小增量的方法
        for(int gap=arr.length/2;gap>0;gap/=2){
            // 从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j=i;
                int temp=arr[j];
                if(arr[j]<arr[j-gap]){
                    while(j-gap>=0 && temp<arr[j-gap]){
                        // 开始移动
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }
                    //退出循环后，说明找到了插入的位置
                    arr[j]=temp;

                }
                
            }

        }

    }


}
