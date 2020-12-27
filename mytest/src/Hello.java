/*
 * @Author hdk
 * @QQ:2890241339
 **/

import java.util.ArrayList;

public class Hello {
    public static void main(String[] args) throws InterruptedException {
        // java最简单的输出语句
//        String str="hello world";
//        System.out.println(str);
//        System.out.println(1+1);
//        System.out.println("hello world 你好");

//        int i=1;
//        i=i++;
//        System.out.println(i);


        ArrayList<int[]> ints = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(2000);
            ints.add(new int[(int)(Math.random()*1000000)]);

        }



    }
}

