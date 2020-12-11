/*
 * @Author hdk
 * @QQ:2890241339
 **/
package my202012;

import org.junit.Test;

import java.util.Arrays;

public class my01 {
    public static void main(String[] args) {
//        tower(3,'A','B','C');
        System.out.println("hellohellook".replaceAll("hello","ok"));


        /**
         *  将unicode编码10进制数，转为字符输出
         */
//        String str="20013-22269";
//        String[] split = str.split("-");
//        String res="";
//        for (int i = 0; i <split.length ; i++) {
//            res+=(char)(Integer.parseInt(split[i]));
//        }
//        System.out.println(res);// 中国





    }





    //汉诺塔游戏,采用递归的方式完成
    private static void tower(int n,char a,char b,char c) {
        if(n==1){
            System.out.println("第1个盘从"+a+"-->"+c);
        }else{
            // 上面所有盘从a-->b
            tower(n-1,a,c,b);
            //最下面的盘a-->c
            System.out.println("第"+n+"个盘从"+a+"-->"+c);
            //将b上所有盘移动到c
            tower(n-1,b,a,c);

        }


    }

    /**
     * 2数之和
     * @return
     */
    @Test
    public void twoSum(){
        int[]nums={1,5,2,8};
        int target=9;

        int[] res = new int[2];
        int[] tmp = new int[nums.length];// 保存初始数组
        System.arraycopy(nums, 0, tmp, 0, nums.length);
        Arrays.sort(nums);
        int m=0,n=0;
        for (int i = 0, j=nums.length-1; i <j ; ) {
            if(nums[i]+nums[j]<target){
                i++;
            }else if(nums[i]+nums[j]>target){
                j--;
            }else if(nums[i]+nums[j]==target){
                m=i;n=j;
                break;
            }
        }

        int k=0;
        for (k = 0; k < tmp.length; k++) {
            if(nums[m]==tmp[k]){
                res[0]=k;
                break;
            }
        }
        for (int i = 0; i < tmp.length; i++) {
            if(nums[n]==tmp[i] && i!=k){
                res[1]=i;
                break;
            }
        }
        System.out.println(Arrays.toString(res));

    }

    @Test
    public void fun1(){
        /**
         * 1) 有一个字符串 str1= ""硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好""，
         * 和一个子串 str2="尚硅谷你尚 硅你"
         * 2) 现在要判断 str1 是否含有 str2, 如果存在，
         * 就返回第一次出现的位置, 如果没有，则返回-1
         * 3) 要求用最快的速度来完成匹配
         */
        String str1="aaahelloworld";
        String str2="hell";
        System.out.println(str1.indexOf(str2)); // 直接调用java中String类的indexof函数


    }





}
