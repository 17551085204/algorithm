/*
 * @Author hdk
 * @QQ:2890241339
 **/

public class BinarySearch {
    public static void main(String[] args) {
        int[]arr={0,1,2,3,4,5,6,7};
        int index = binarySearch(arr,14);
        System.out.println(index);



    }

    /**
     * 对已经排序的数组进行二分查找，找到就返回下标
     * 没有就返回-1
     * @param arr
     * @return
     */
    public static int binarySearch(int[]arr,int target){
        int left=0;
        int right=arr.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]<target){
                left=mid+1;
            }else if(arr[mid]>target){
                right=mid-1;
            }
        }
        return -1;

    }

}
