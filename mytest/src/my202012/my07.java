/*
 * @Author hdk
 * @QQ:2890241339
 **/
package my202012;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class my07 {
    public static void main(String[] args) {
        System.out.println("hello world");


    }

    @Test
    public void my01(){
        /**
         * list底层是定义的Object[]数组
         * 初始大小为10，如果长度不够，就需要扩容1.5倍
         */
        int[]arr=new int[20];
        arr[0]=10;
        for (int i = 1; i < arr.length; i++) {
            arr[i]=arr[i-1]+(arr[i-1]>>1);
        }
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>1000){
                System.out.println("arr["+i+"]="+arr[i]);
                break;
            }
        }

    }


}
