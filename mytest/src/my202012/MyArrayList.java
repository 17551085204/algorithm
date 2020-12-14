/*
 * @Author hdk
 * @QQ:2890241339
 **/
package my202012;

import java.util.Arrays;

/**
 * 实现ArrayList功能
 * 1，添加，add,初始长度为10，可以自动扩容,重载，在某一指定位置添加元素
 * 2,打印，show
 * 3，获取size
 * 4,删除元素，remove
 * 5,判断某元素是否存在 contains
 * 6，删除所有元素 clear
 * 7,返回指定索引处的元素 get
 * 8,返回某元素第一次出现的索引 indexof
 * 9,返回对应的数组 toArray
 * 10,排序 sort
 *
 *
 */


public class MyArrayList {
    private int size;// list长度大小
    private int[]data; // 维护一个数组
    private int capcity=10;//数组的初始大小

    public MyArrayList() {
        data=new int[capcity];
    }

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        //加入元素
//        myArrayList.add(1);myArrayList.add(2);myArrayList.add(3);
        for (int i = 0; i < 18; i++) {
            myArrayList.add(i);
        }
        // 删除某一个元素
        myArrayList.remove(13);
        // 在某一指定索引位置添加元素
        myArrayList.add(5,100);
        for (int i = 0; i < 4; i++) {
            myArrayList.add(5,100);
        }

        // 判断元素是否存在
        System.out.println("是否存在元素24:"+myArrayList.contains(24));

//        myArrayList.clear();
        System.out.println("是否为空:"+myArrayList.isEmpty());

        // 打印最后一个元素
//        System.out.println(myArrayList.get(myArrayList.size-1));

        System.out.println(myArrayList.indexof(22));

        //打印长度
        System.out.println("myArrayList的长度为:"+myArrayList.size);
        //打印内容
        myArrayList.show();

        myArrayList.sort();
        myArrayList.show();


//        int[] ints = myArrayList.toArray();
//        System.out.println(Arrays.toString(ints));



    }

    // 排序
    public void sort(){
        Arrays.sort(data);

    }



    // 转为数组
    public int[] toArray(){
        int[]arr=new int[size];
        for (int i = 0; i < size; i++) {
            arr[i]=data[i];
        }
        return arr;

    }

    // 判断是否为空
    public boolean isEmpty(){
        return size==0;
    }


    // 返回此列表中指定元素的第一次出现的索引，如果此列表不包含元素，则返回-1。
    public int indexof(int target){
        for (int i = 0; i < size; i++) {
            if(data[i]==target){
                return i;
            }
        }
        return -1;

    }

    // 返回指定索引处的元素
    public int get(int index){
        if(index<size){
            return data[index];
        }else{
            throw new RuntimeException("超出索引");
        }
    }


    // 删除所有元素
    public void clear(){
        capcity=10;
        size=0;
        data=new int[capcity];

    }

    // 判断某一元素是否存在
    public boolean contains(int target){
        for (int i = 0; i < size; i++) {
            if(data[i]==target){
                return true;
            }
        }
        return false;

    }


    // 移除list中的target
    public void remove(int target){
        for (int i = 0; i < size; i++) {
            if(data[i]==target){
                System.arraycopy(data,i+1,data,i,size-i);
                size--;
                return;
            }
        }
        System.out.println("不存在元素:"+target);

    }

    // 在指定位置加入元素
    public  void add(int index,int element){
        if(size<capcity){
            System.arraycopy(data,index,data,index+1,size-index);
            data[index]=element;
            size++;


        }else{
            capcity=capcity+(capcity>>1);
            int[]newdata=new int[capcity];
            System.arraycopy(data,0,newdata,0,size);
            data=newdata;

            System.arraycopy(data,index,data,index+1,size-index);
            data[index]=element;
            size++;

        }

    }

    // 在末尾加入元素
    public  void add(int element){
        if(size<capcity){
            data[size]=element;
            size++;
        }else{
            capcity=capcity+(capcity>>1);
            int[]newdata=new int[capcity];
            System.arraycopy(data,0,newdata,0,size);
            data=newdata;
            data[size]=element;
            size++;

        }

    }

    public void show(){
        if(size>0) {
            System.out.print("[");
            for (int i = 0; i < size - 1; i++) {
                System.out.print(data[i] + ",");
            }
            System.out.println(data[size - 1] + "]");
            System.out.println();
        }else{
            System.out.println("[]");
        }
    }



}



