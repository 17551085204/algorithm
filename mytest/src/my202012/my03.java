/*
 * @Author hdk
 * @QQ:2890241339
 **/
package my202012;

/**
 * 受  盛最多水 问题启发，完成一个 升级 问题 : 剪出最大报纸的面积
 *
 */


public class my03 {
    public static void main(String[] args) {
        int[]hight={1,3,5,3};
        int[]width={1,1,1,5};

//        int[]hight={1,8,6,2,5,4,8,3,7};
//        int[]width={1,1,1,1,1,1,1,1,1};

        System.out.println(maxArea(hight,width));

    }

    // 盛最多水--> 升级: 剪出最大的报纸
    /**
     * hight=[1,2,3,1]
     * width=[1,1,1,1]
     *
     */
    public static int maxArea(int[] height,int []width) {
        int left=0;int right=height.length-1;
        int max=0;
        while(left<=right){
            int temp=Math.min(height[left],height[right])*getWidth(width,left,right);
            // 不断更新最大的面积
            max=Math.max(temp,max);
            // 双指针移动的规则
            if(height[left]<=height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }

    private static int getWidth(int[] width, int left, int right) {
        int res=0;
        for (int i = left; i <=right ; i++) {
            res+=width[i];
        }
        return res;
    }

}
