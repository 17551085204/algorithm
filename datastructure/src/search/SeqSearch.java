/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/8
*/

package search;
//import java.util.Scanner;
//顺序查找


public class SeqSearch {
    public static void main(String[] args) {
        int []arr={1,2,3,4,5,6};
        int index=seqSearch(arr,2);
        if(index !=-1){
            System.out.println("下标为:"+index);
        }else{
            System.out.println("找不到");
        }



    }

    public static  int seqSearch(int []arr,int val){
        // 线性查找是逐一比对，发现有相同值就返回下标
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==val){
                return i; // 找到一个就返回下标
            }
        }
        return -1;
    }




}
