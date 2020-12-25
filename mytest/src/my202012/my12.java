/*
 * @Author hdk
 * @QQ:2890241339
 * @Date 2020/12/25 0025
 **/
package my202012;

import java.util.Arrays;

public class my12 {
    public static void main(String[] args) {
        int a=1;int b=2;
//        swap(a,b);
//        System.out.println("a="+a+",b="+b);

//        int[]res=swap2(a,b);
//        System.out.println("a="+res[0]+",b="+res[1]);

//        System.out.println(jiecheng(3));

//        double res=sum2n(63);
//        System.out.println(res);

        System.out.println(Arrays.toString(feibonaqie(14)));

    }

    public  static int[] feibonaqie(int n){
        int[]res=new int[n];
        res[0]=1;res[1]=1;
        for (int i = 2; i < n; i++) {
            res[i]=res[i-1]+res[i-2];
        }

        return res;
    }





    public static double sum2n(int n){
        double res=0;
        for (int i = 0; i <= n; i++) {
            res+=mypower(2,i);
        }
        return res;
    }

    private static double mypower(int i, int n) {
        double res=1;
        for (int j = 0; j < n; j++) {
            res*=i;
        }
        return res;
    }


    public static int jiecheng(int n){
        if(n==1){
            return 1;
        }
        return n*jiecheng(n-1);

    }

    public static void swap(int a ,int b){
        int temp=0;
        temp=a;
        a=b;
        b=temp;
    }

    public static int[] swap2(int a ,int b){
        int temp=0;
        temp=a;
        a=b;
        b=temp;
        int[]res={a,b};
        return res;

    }


}
