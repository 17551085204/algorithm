/*
 * @Author hdk
 * @QQ:2890241339
 * @Date 2020/12/25 0025
 **/
package my202012;

import java.util.Arrays;
import java.util.Stack;

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

//        System.out.println(Arrays.toString(feibonaqie(14)));

//        getNum();

//        System.out.println(getCount());

//         check();

//        System.out.println(ten2two(114));

        ishuiwen("45654");

    }

    // 判断回文字符串
    public static void ishuiwen(String str){
        if(str==null){
            System.out.println("输入不可以为null");
            return;
        }
        String s = new StringBuilder(str).reverse().toString();
        boolean flag=s.equals(str);
        if(flag){
            System.out.println("是回文串");
        }else{
            System.out.println("不是回文串");
        }
    }




    // 利用栈实现10进制数转为2进制
    public  static String ten2two(int num){
        Stack<Integer> integers = new Stack<>();
        String res="";
        while (num!=0){
            int k=num%2;
            num=num/2;
            integers.push(k);
        }
        while (!integers.isEmpty()){
            res+=integers.pop();
        }
        return  res;

    }



    // 验证歌德巴赫猜想
    public static void check(){
        for (int i = 4; i < 1000; i+=2) {
            gedabahe(i);
        }

    }



    // 判断一个大于2的偶数是否可以被分解为2个质数之和
    public static  void gedabahe(int n){
        for (int i = 2; i < n-1; i++) {
            int j=n-i;
            if(isprime(i)&&isprime(j)){
                System.out.println(n+"="+i+"+"+j);
                break;
            }
        }

    }



    // 判断一个数是否是质数
    public static boolean isprime(int n){
        boolean flag=true;
        for (int i =2; i < n; i++) {
            if(n%i==0){
                flag=false;
                break;
            }
        }
        return flag;
    }





    public static int getCount(){
        int count=7;
        while (!(count%2==1&&count%3==2&&count%5==4&&count%6==5&&count%7==0)){
            count+=7;
        }
        return count;

    }



    public static void getNum(){
        for (int x = 1; x <10 ; x++) {
            for (int y = 2; y < 20 ; y+=2) {
                    int z=30-x-y;
                    if((3*x+2*y+z)==50){
                        System.out.println(x+","+y+","+z);
                }

            }
        }

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
