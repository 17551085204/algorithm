/*
 * @Author hdk
 * @QQ:2890241339
 * @Date 2020/12/18 0018
 **/
package my202012;

public class my10 {
    public static void main(String[] args) {
        int[]height={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    // 利用双指针法解决装最多水的问题
    public static  int maxArea(int[]height){
        int left=0;
        int right=height.length-1;
        int max=0;
        while(left<right){
            int temp=Math.min(height[left],height[right])*(right-left);
            max=Math.max(temp,max);
            if(height[left]<=height[right]){
                left++;
            }else {
                right--;
            }

        }

        return max;

    }



}
