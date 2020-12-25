/*
 * @Author hdk
 * @QQ:2890241339
 * @Date 2020/12/25 0025
 **/
package my202012;

public class my12 {
    public static void main(String[] args) {
        int a=1;int b=2;
//        swap(a,b);
//        System.out.println("a="+a+",b="+b);

        int[]res=swap2(a,b);
        System.out.println("a="+res[0]+",b="+res[1]);

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
