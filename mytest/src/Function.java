/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/24
*/

//import java.util.Scanner;

public class Function {
    public static void main(String[] args) {
        // 下面开始写代码
        System.out.println(add(1,2));
        int[]arr={3,7,5,2,5};
        getMax(arr);

    }

    // 这是一个函数示例
    public static int add(int a, int b) {
        // 可以按照需要修改逻辑代码
        return a + b;
    }

    /**
     * 得到数组中的最大值
     * @param arr
     */
    public static void getMax(int[]arr){
        int max=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>max){
                max=arr[i];
            }
        }
        System.out.println("数组中的最大值:"+max);
    }


}
