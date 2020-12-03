/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/8
*/

package search;
//import java.util.Scanner;

public class InsertValSearch {
    public static void main(String[] args) {
        int[]arr=new int[100];// 数组是有序的
        for (int i =0;i<arr.length;i++) {
            arr[i]=i;
        }
       int index=insertValSearch(arr,0,arr.length-1,6);
        if(index !=-1){
            System.out.println("下标为:"+index);
        }else{
            System.out.println("找不到");
        }


    }

    // 插值查找，递归完成，要求数组是有序的
    public static int insertValSearch(int []arr, int left,int right,int val) {

        //当left>right,说明递归完毕 val>arr[arr.length-1] || val<arr[0]是必须的
        // 否则mid可能会越界
        if(left>right || val>arr[arr.length-1] || val<arr[0]){
            return  -1;
        }

        int mid=left+(right-left)*(val-arr[left])/(arr[right]-arr[left]);

        int midVal=arr[mid];
        if(val>midVal){// 需要向右递归
            return insertValSearch(arr,mid+1,right,val);
        }else if(val<midVal){// 需要向左递归
            return  insertValSearch(arr,left,mid-1,val);
        }else {

            return mid;
        }



    }


}
