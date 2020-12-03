/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/8
*/

package sortalgorithm;
//import java.util.Scanner;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSort {
    public static void main(String[] args) {

        // 基数排序的简单测试
//        int []arr={8,123,34,567,43,12};
//        System.out.println("排序前"+Arrays.toString(arr));
//        radix(arr);
//        System.out.println("排序后"+Arrays.toString(arr));


        // 测试基数排序的时间
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
        radix(arr);


        Date currentTime1 = new Date();
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString1 = formatter1.format(currentTime1);
        System.out.println("排序后系统时间："+dateString1);
        long time2 = System.currentTimeMillis();
        System.out.println("数组长度为"+max+",耗时"+(time2-time1)+"ms");


    }

    // 基数排序
    public static void radix(int[] arr) {
        int max=arr[0];
        // 获取arr中的最大值
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max){
                max=arr[i];
            }
        }

        int len=(max+"").length(); // 得到最大数的位数

        for (int i = 0; i < len; i++) {  // 一共需要大的循环

            // 定义一个二维数组，表示10个桶，每一个桶就是一个一维数组
            int[][]bucket=new int[10][arr.length];// 为了防止溢出，列取最大
            // 记录每个桶中实际存放了多少个数据
            int[]bucketEleCount=new int[10];
            for (int j = 0; j <arr.length ; j++) {
                int digitOfEle=arr[j]/((int)Math.pow(10,i))%10;
                // 放入对应的桶
                bucket[digitOfEle][bucketEleCount[digitOfEle]]=arr[j];
                bucketEleCount[digitOfEle]++;
            }
            //按照桶的顺序
            int index=0;
            // 遍历每一个桶，将桶中的数据放入原数组
            for (int k = 0; k < bucketEleCount.length; k++) {
                if(bucketEleCount[k]>0){// 桶中有数据
                    // 循环第k个桶
                    for (int l = 0; l < bucketEleCount[k]; l++) {
                        // 取出元素，放入arr
                        arr[index]=bucket[k][l];
                        index++;
                    }

                }
            }

        }



        /*
        // 第一轮，针对每个元素的个位进行排序
        // 定义一个二维数组，表示10个桶，每一个桶就是一个一维数组
        int[][]bucket=new int[10][arr.length];// 为了防止溢出，列取最大
        // 记录每个桶中实际存放了多少个数据
        int[]bucketEleCount=new int[10];
        for (int j = 0; j <arr.length ; j++) {
            // 取出每个元素的个位
            int digitOfEle=arr[j]%10;
            // 放入对应的桶
            bucket[digitOfEle][bucketEleCount[digitOfEle]]=arr[j];
            bucketEleCount[digitOfEle]++;
        }
        //按照桶的顺序
        int index=0;
        // 遍历每一个桶，将桶中的数据放入原数组
        for (int k = 0; k < bucketEleCount.length; k++) {
            if(bucketEleCount[k]>0){// 桶中有数据
                // 循环第k个桶
                for (int l = 0; l < bucketEleCount[k]; l++) {
                    // 取出元素，放入arr
                    arr[index]=bucket[k][l];
                    index++;
                }

            }
        }
*/





    }


}
