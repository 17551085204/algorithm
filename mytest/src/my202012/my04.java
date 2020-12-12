/*
 * @Author hdk
 * @QQ:2890241339
 **/
package my202012;

public class my04 {
    public static void main(String[] args) {
        int[]height={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));

        System.out.println(intToRoman(1923));
    }

    // 盛最多水的容器,双指针方法
    public  static  int  maxArea(int[]height){
        int left=0;
        int right=height.length-1;
        int max=0;
        while (left<right){
            int temp=Math.min(height[left],height[right])*(right-left);
            max=Math.max(temp,max);
            // 指针移动的规则，需要好好理解
            if(height[left]<=height[right]){
                left++;
            }else{
                right--;
            }

        }
        return max;
    }


    // 数字转罗马数字
    public  static  String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <values.length&&num>0 ; i++) {
            while (values[i]<=num){
                num-=values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();

    }




}
