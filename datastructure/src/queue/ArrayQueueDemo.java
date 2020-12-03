/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/1
*/

package queue;
//import java.util.Scanner;
// 数组模拟队列实现

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char k=' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop=true;
        while (loop){
            System.out.println("s: 显示队列");
            System.out.println("e: 退出队列");
            System.out.println("a: 添加数据");
            System.out.println("g: 取出数据");
            System.out.println("h: 查看队列头数据");

            k=scanner.next().charAt(0);
            switch (k){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数字");
                    int n=scanner.nextInt();
                    arrayQueue.addQueue(n);
                    break;
                case 'g':
                    try {
                        int res=arrayQueue.getQueue();
                        System.out.println("取出的数据为:"+res);

                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'h':
                    try {
                        int res=arrayQueue.headQueue();
                        System.out.println("队列头的数据为:"+res);

                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'e':
                    scanner.close();
                    loop=false;

                    break;
                 default:
                        break;

            }

        }
        System.out.println("退出程序");
    }

}

class ArrayQueue{
    private  int maxSize; // 最大容量
    private  int front;  // 队列头部
    private  int real; //队列尾部
    private  int[] arr; // 用于存放数据，模拟队列

    // 创建队列
    public ArrayQueue(int arrMaxSize){
        maxSize=arrMaxSize;
        arr=new int[maxSize];
        front=-1; // 指向队列头的前一个位置
        real=-1; // 指向队列尾部，就是队列的最后一个数据

    }

    // 判断队列是否是满的
    public boolean isFull(){
        return real==maxSize-1;
    }

    // 判断队列是否为空
    public boolean isEmpty(){
        return real==front;
    }

    // 添加数据到队列
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列满了");
            return ;
        }
        real++;
        arr[real]=n;
    }

    // 获取队列的数据
    public int getQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];

    }

    // 展示所有数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    //  显示队列的额头数据，不是取出数据
    public int headQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            throw new RuntimeException("队列为空");
        }
        return arr[front+1];
    }



}


