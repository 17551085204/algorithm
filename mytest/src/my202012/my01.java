/*
 * @Author hdk
 * @QQ:2890241339
 **/
package my202012;

import org.junit.Test;

import java.util.Arrays;

public class my01 {
    public static void main(String[] args) {
        System.out.println("hello world");
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




}
