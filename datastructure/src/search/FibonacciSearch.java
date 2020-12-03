/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/8
*/

package search;
//import java.util.Scanner;

import java.util.Arrays;

public class FibonacciSearch {

    public  static  int maxSize=20;

    public static void main(String[] args) {

        int[]arr=new int[100];// 数组是有序的
        for (int i =0;i<arr.length;i++) {
            arr[i]=i;
        }
        int index=fibonacciSearch(arr,16);
        if(index !=-1){
            System.out.println("下标为:"+index);
        }else{
            System.out.println("找不到");
        }


    }

    // 这是一个函数示例
    public static int fibonacciSearch(int[] arr,int val) {
        // 可以按照需要修改逻辑代码
        int low=0;
        int high=arr.length-1;
        int k=0; //斐波那些分割数值的下标
        int mid=0;
        int[]f=fib();
        // 获取到k
        while (high>f[k]-1){
            k++;
        }
        // f[k]可能会大于数组的长度，所以需要使用Arrays构造新数组，指向arr
        // 不足的部分用0填充
        int []temp=Arrays.copyOf(arr,f[k]);
        // 实际需要使用arr[high]填充temp
        for (int i = high+1; i < temp.length; i++) {
            temp[i]=arr[high];
        }
        // 使用while循环
        while (low<=high){
            mid=low+f[k-1]-1;
            if(val<temp[mid]){
                // 向左边查找
                high=mid-1;
                k--;//
            }else if(val>temp[mid]){
                // 向右边查找
                low=mid+1;
                k-=2;
            }else{
                return Math.min(mid,high);
            }

        }


        return -1;

    }

    // 获取斐波那锲数列
    public static  int[]fib(){
        int[] f=new int[maxSize];
        f[0]=1;f[1]=1;
        for (int i = 2; i < maxSize; i++) {
            f[i]=f[i-1]+f[i-2];
        }
        return  f;
    }


}
