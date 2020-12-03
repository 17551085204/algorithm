/*
 * @Author hdk
 * @QQ:2890241339
 **/
package dac;

// 解决汉诺塔问题
// 如果是一个盘，a->c,如果n>=2,总是可以看成2个盘。上面的盘和最下面的盘
// 上面的盘a->b,下面的盘a->c,b上所有盘到c

public class Hanoitower {
    public static void main(String[] args) {
        hanoitower(3,'A','B','C');


    }

    // 汉诺塔的移动方法
    // 使用分治算法解决
    public static  void hanoitower(int num,char a,char b,char c){
         if(num==1){
             System.out.println("第1个盘从"+a+"->"+c);
         }else{
             // 将上面所有盘a->b
             hanoitower(num-1,a,c,b);
             // 最下面盘a->c
             System.out.println("第"+num+"个盘从"+a+"->"+c);
             // 将b上所有盘b->c
             hanoitower(num-1,b,a,c);

         }

    }

}



