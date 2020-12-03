/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/8
*/

package sort;
//import java.util.Scanner;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergeSort {
    public static void main(String[] args) {

        // 归并排序的简单测试
//        int []arr={8,4,5,7,1,3,6,2};
//        int []temp=new int[arr.length];
//        System.out.println("排序前"+Arrays.toString(arr));
//        mergeSort(arr,0,arr.length-1,temp);
//        System.out.println("排序后"+Arrays.toString(arr));


        // 测试归并排序的时间
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        System.out.println("排序前系统时间："+dateString);
        long time1 = System.currentTimeMillis();
        int max=80000;
        int []arr=new int[max];
        for (int i = 0; i <max ; i++) {
//            arr[i]=max-i;
            arr[i]=(int)(Math.random()*max);
        }

        // 排序算法
        int []temp=new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);


        Date currentTime1 = new Date();
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString1 = formatter1.format(currentTime1);
        System.out.println("排序后系统时间："+dateString1);
        long time2 = System.currentTimeMillis();
        System.out.println("数组长度为"+max+",耗时"+(time2-time1)+"ms");


    }

    public static  void mergeSort(int[] arr,int left,int right,int []temp){
        if(left<right){
            int mid=(left+right)/2;
            // 向左递归，分解
            mergeSort(arr,left,mid,temp);
            // 向右递归，分解
            mergeSort(arr,mid+1,right,temp);
            // 合并
            merge(arr,left,mid,right,temp);

        }
    }


    // 合并的方法
    // 排序的原始数组，左边有序的初始索引，中间索引，右边索引，做中转的数组
    public static void merge(int[] arr,int left,int mid,int right,int[]temp) {
        int i=left; // 左边有序序列的初始索引
        int j=mid+1;// 右边有序序列的初始索引
        int t=0; // temp数组的索引
        // 将左右两边的有序数据，按照规则，copy到temp数组，直到左右两边的
        // 有序序列有一方处理完毕为止
        while(i<=mid&&j<=right){
            if(arr[i]<=arr[j]){// 左边有序序列的当前元素<=右边有序序列的当前元素
                temp[t]=arr[i];
                t++;
                i++;
            }else{
                temp[t]=arr[j];
                t++;
                j++;
            }
        }
        // 将有剩余数据的一方，依次全部copy到temp
        while(i<=mid){// 左边的有序序列有剩余，全部copy到temp
            temp[t]=arr[i];
            t++;i++;
        }
        while(j<=right){// 右边的有序序列有剩余，全部copy到temp
            temp[t]=arr[j];
            t++;j++;
        }
        // 将temp数组copy到arr
        // 不是每次都copy所有数据
        t=0;
        int tempLeft=left;//
        while(tempLeft<=right){// 第一次合并,tempLeft=0 right=1
            arr[tempLeft]=temp[t];
            t++;tempLeft++;
        }


    }


}
