/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/8
*/

package search;
//import java.util.Scanner;

import java.util.ArrayList;

public class BinarySearch {
    public static void main(String[] args) {
       int[]arr={0,1,2,3,4,4,4,4,5,6,7,8,9,9,9,9,9};// 数组是有序的
//       int index=binarySearch2(arr,4);
////       int index=binarySearch(arr,0,arr.length-1,4);
//        if(index !=-1){
//            System.out.println("下标为:"+index);
//        }else{
//            System.out.println("找不到");
//        }


//        ArrayList<Integer> indexs = binarySearch3(arr, 0, arr.length - 1, 4);
        ArrayList<Integer> indexs = binarySearch4(arr, 4);
        if(indexs.size()==0){
            System.out.println("找不到");
        }else{
            System.out.println("所有下标的集合:"+indexs);
        }


    }

    // 二分查找，递归完成,考虑重复的元素
    public static ArrayList<Integer> binarySearch3(int []arr, int left, int right, int val) {

        //当left>right,说明递归完毕
        if(left>right){
            return  new ArrayList();
        }

        int mid=(left+right)/2;
        int midVal=arr[mid];
        if(val>midVal){// 需要向右递归
            return  binarySearch3(arr,mid+1,right,val);
        }else if(val<midVal){// 需要向左递归
            return  binarySearch3(arr,left,mid-1,val);
        }else {

            ArrayList<Integer> list = new ArrayList<>();
            // 向mid左边扫描
            int temp=mid-1;
            while (true){
                if(temp<0 || arr[temp]!=val){
                    break;
                }
                //否则就将temp加入集合
                list.add(temp);
                temp--;
            }
            list.add(mid);
            // 向mid右边扫描
            temp=mid+1;
            while (true){
                if(temp>arr.length-1 || arr[temp]!=val){
                    break;
                }
                //否则就将temp加入集合
                list.add(temp);
                temp++;
            }
            return list;

        }

    }

    // 二分查找，递归完成
    public static int binarySearch(int []arr, int left,int right,int val) {

        //当left>right,说明递归完毕
        if(left>right){
            return  -1;
        }

        int mid=(left+right)/2;
        int midVal=arr[mid];
        if(val>midVal){// 需要向右递归
            return  binarySearch(arr,mid+1,right,val);
        }else if(val<midVal){// 需要向左递归
            return  binarySearch(arr,left,mid-1,val);
        }else {

            return mid;
        }



    }



    // 二分查找，非递归完成
    public static int binarySearch2(int []arr, int val) {

        int left=0;int right=arr.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==val){
                return mid;
            }else if(arr[mid]<val){
                left=mid+1;
            }else if(arr[mid]>val){
                right=mid-1;
            }

        }

        return -1;

    }

    // 二分查找，非递归完成,考虑重复元素
    public static ArrayList<Integer> binarySearch4(int []arr, int val) {

        int index=binarySearch2(arr,val);
        if(index==-1){// 表示没有找到
            return  new ArrayList<>();

        }else{// 以index为中心，找数组其他的值是否为val
            ArrayList<Integer>list=new ArrayList<>();
            int temp=index-1;
            // 向左查看
            while(true){
                if(temp<0||arr[temp]!=val){
                    break;
                }
                list.add(temp);
                temp--;
            }
            // 加入中间的index
            list.add(index);
            // 向右查看
            temp=index+1;
            while(true){
                if(temp>arr.length-1||arr[temp]!=val){
                    break;
                }
                list.add(temp);
                temp++;
            }

            return  list;

        }


    }


}
