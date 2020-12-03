/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/16
*/

package binarysearchnorecursion;
//import java.util.Scanner;

// 实现二分查找，不用递归的方式

public class BinarySearch {
    public static void main(String[] args) {
        int[]arr={0,1,2,3,4,5,6,7,8};
        int i = binarySearch(arr, 89);
        System.out.println(i);


    }

    // 二分查找，如果找到，返回下标，否则返回-1，arr是有序列表
    public static int binarySearch(int[]arr,int value){
        int left=0;
        int right=arr.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==value){
                return mid;
            }else if(arr[mid]>value){// 需要向左找
                right=mid-1;
            }else if(arr[mid]<value){// 需要向右找
                left=mid+1;
            }

        }
        return -1;

    }





}
