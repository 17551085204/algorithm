/*
 * @Author hdk
 * @QQ:2890241339
 **/

import java.util.ArrayList;
import java.util.Collections;

public class QuickSort1 {
    public static void main(String[] args) {
        ArrayList<Integer>arr=new ArrayList<>();
//        Collections.addAll(arr,4,3,5,6,1);
        int max=100000;
        for (int i = 0; i < max; i++) {
            arr.add((int)(Math.random()*max));
        }

        ArrayList<Integer> integers = quickSort(arr);
//        System.out.println(integers);



    }
    // 有返回值的写法，用list实现
    public static ArrayList<Integer> quickSort(ArrayList<Integer>arr){
        if(arr.size()==0||arr.size()==1){
            return arr;
        }
        ArrayList<Integer>left=new ArrayList<>();
        ArrayList<Integer>right=new ArrayList<>();
        for (int i = 1; i < arr.size(); i++) {
            if(arr.get(i)<arr.get(0)){
                left.add(arr.get(i));
            }else{
                right.add(arr.get(i));
            }
        }
        left=quickSort(left);
        right=quickSort(right);
        left.add(arr.get(0));
        left.addAll(right);
        return left;


    }



}
