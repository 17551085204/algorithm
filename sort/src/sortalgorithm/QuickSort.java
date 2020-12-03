/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/8
*/

package sortalgorithm;
//import java.util.Scanner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

public class QuickSort {
    public static void main(String[] args) {

        // 快速排序的简单测试
//        int []arr={8,9,1,7,2,3,5,4,6,0};
//        System.out.println("排序前"+Arrays.toString(arr));
//        quick(arr,0,arr.length-1);
//        System.out.println("排序后"+Arrays.toString(arr));


        // 测试快速排序的时间
//        Date currentTime = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String dateString = formatter.format(currentTime);
//        System.out.println("排序前系统时间："+dateString);
//        long time1 = System.currentTimeMillis();
//        int max=80000;
//        int []arr=new int[max];
//        for (int i = 0; i <max ; i++) {
////            arr[i]=max-i;
//            arr[i]=(int)(Math.random()*max);
//
//        }
//
//        // 排序算法
//        quick(arr,0,arr.length-1);
//
//
//        Date currentTime1 = new Date();
//        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String dateString1 = formatter1.format(currentTime1);
//        System.out.println("排序后系统时间："+dateString1);
//        long time2 = System.currentTimeMillis();
//        System.out.println("数组长度为"+max+",耗时"+(time2-time1)+"ms");



        // 第二种快速排序算法,返回一个新的有序数组，不会对原数组造成改变
        int []arr={8,9,1,7,2,3,5,4,6,10};
        System.out.println("排序前"+Arrays.toString(arr));
        int[]arr2=quick2(arr);
        System.out.println("排序后"+Arrays.toString(arr2));

        // 测试第二种快速排序的时间
//        Date currentTime = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String dateString = formatter.format(currentTime);
//        System.out.println("排序前系统时间："+dateString);
//        long time1 = System.currentTimeMillis();
//        int max=80000;
//        int []arr=new int[max];
//        for (int i = 0; i <max ; i++) {
////            arr[i]=max-i;
//            arr[i]=(int)(Math.random()*max);
//
//        }
//
//        // 第二种排序算法
//        arr=quick2(arr);
//
//        Date currentTime1 = new Date();
//        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String dateString1 = formatter1.format(currentTime1);
//        System.out.println("排序后系统时间："+dateString1);
//        long time2 = System.currentTimeMillis();
//        System.out.println("数组长度为"+max+",耗时"+(time2-time1)+"ms");




    }

    // 快速排序
    public static void quick(int[] arr,int left,int right) {
        int l=left;int r=right; // 将左右索引保存
        int pivot =arr[(left+right)/2]; // 数组的中轴值
        int temp=0; // 用于交换
        while(l<r){// 使得比pivot小的值放到pivot左边，比它大的放到右边
            // 在pivot的左边一直找，直到找到大于等于pivot的值才退出
            while (arr[l]<pivot){
                l++;
            }
            // 在pivot的右边一直找，直到找到小于等于pivot的值才退出
            while (arr[r]>pivot){
                r--;
            }
            if(l>=r){// 说明pivot的左右两边的值已经按照全部小于等于pivot，右边全部大于等于pivot
                break;
            }
            // 交换
            temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            // 如果交换完后，arr[l]==pivot,前移
            if(arr[l]==pivot){
                r--;
            }
            // 如果交换完后，arr[r]==pivot,后移
            if(arr[r]==pivot){
                l++;
            }

        }
        // 如果l==r,必须l++,r--,否则栈溢出
        if(l==r){
           l++;
           r--;
        }
        // 向左递归
        if(left<r){
            quick(arr,left,r);
        }
        //向右递归
        if(right>l){
          quick(arr,l,right);
        }
    }


    // 方法的重载，输入输出都改为int[]
    public static int[] quick2(int[] arr) {
        ArrayList<Integer>list=new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        ArrayList<Integer>list1=quick2(list);
        int[]result=new int[list1.size()];
        for (int i = 0; i < result.length; i++) {
            result[i]=list1.get(i);
        }
        return result;

    }


    // 第二种快速排序算法的实现
    public static ArrayList<Integer> quick2(ArrayList<Integer> arr){
        if(arr.size()==0 || arr.size()==1){
            return arr;
        }
        // 每次都选取第一个元素，作为分为2组的中间值
        int temp=arr.get(0);
        ArrayList<Integer>left=new ArrayList<>(); // 存放比temp小的值
        ArrayList<Integer>right=new ArrayList<>(); // 存放比temp大的值
        for(int i=1;i<arr.size();i++){
            if(arr.get(i)<temp){
                left.add(arr.get(i));
            }else{
                right.add(arr.get(i));
            }

        }
        left=quick2(left); // 采用递归的方式
        right=quick2(right);
        left.add(temp);
        left.addAll(right);
        return left;


    }


}
