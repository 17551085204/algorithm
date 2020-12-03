/*
 * @Author hdk
 * @QQ:2890241339
 **/
package tree;

import java.util.Arrays;

public class heapSort {
    public static void main(String[] args) {
        // 堆排序简单测试
       int[]arr={4,6,8,5,9,-1,23,-5};
       heap(arr);
       System.out.println(Arrays.toString(arr));

       // 时间测试
//        long t1 = System.currentTimeMillis();
//        int max=8000000;
//        int[]arr=new int[max];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i]=(int)(Math.random()*max);
//        }
//        heap(arr);
//        long t2 = System.currentTimeMillis();
//        System.out.println((t2-t1)+"ms");



    }

    public static  void heap(int[] arr){
        int temp=0;
        // 堆排序
        for (int i = arr.length/2-1; i >=0; i--) {
            adjustHeap(arr,i,arr.length);
        }
        // 交换
        for(int j=arr.length-1;j>0;j--){
            temp=arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            adjustHeap(arr,0,j);
        }

    }

    // 将一个数组（对应一个二叉树），调整为一个大顶堆
    // arr,待调整的数组，i,非叶子节点在数组中索引
    // length,对多少元素进行调整，逐渐减少
    // 实现功能:将以i对应的非叶子节点的数组调整为大顶堆
    public static void adjustHeap(int[]arr,int i,int length){

        int temp=arr[i];// 先取出当前元素的值
        // k=i*2+1,代表i节点的左子节点
        for(int k=i*2+1;k<length;k=k*2+1){
            if(k+1<length && arr[k]<arr[k+1]){// 左子节点的值小于右子节点
                k++;// k指向右子节点
            }
            if(arr[k]>temp){// 子节点大于父节点
                arr[i]=arr[k];//较大的值赋值给当前节点
                i=k;// i指向k，继续循环比较
            }else{
                break;
            }
        }
        //循环结束后，已经将以i为父节点的数的最大值
        // 放在了最顶上（局部）
        arr[i]=temp;

    }


}


