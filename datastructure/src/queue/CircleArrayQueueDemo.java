/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/2
*/

package queue;
//import java.util.Scanner;

/*
思路如下
1，front的含义改为：front就指向队列的第一个元素，arr[front]就是队列的
第一个元素.front的初始值为0
2，real的含义改为:real指向队列的最后一个元素的后一个位置，因为希望空出一个空间作为一个约定
real的初始值也是0
3，队列满时，条件为：(real+1)%maxSize==front
4,队列为空的条件: real==front
5，队列中有效的数据的个数为：（real+maxSize-front）%maxSize
6,在原来的队列进行修改，得到环形队列



 */


import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(5);// 注意，这里队列数据最多只能有 maxSize-1，因为有一个预留空间
        char k = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s: 显示队列");
            System.out.println("e: 退出队列");
            System.out.println("a: 添加数据");
            System.out.println("g: 取出数据");
            System.out.println("h: 查看队列头数据");
            k = scanner.next().charAt(0);
            switch (k) {
                case 's':
                    circleArrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数字");
                    int n = scanner.nextInt();
                    circleArrayQueue.addQueue(n);
                    break;
                case 'g':
                    try {
                        int res = circleArrayQueue.getQueue();
                        System.out.println("取出的数据为:" + res);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'h':
                    try {
                        int res = circleArrayQueue.headQueue();
                        System.out.println("队列头的数据为:" + res);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'e':
                    scanner.close();
                    loop = false;

                    break;
                default:
                    break;

            }

        }
        System.out.println("退出程序");
    }


}


class CircleArrayQueue{
    private  int maxSize; // 最大容量
    private  int front;  // 队列头部
    private  int real; //队列尾部
    private  int[] arr; // 用于存放数据，模拟队列

    // 创建队列
    public CircleArrayQueue(int arrMaxSize){
        maxSize=arrMaxSize;
        arr=new int[maxSize];
//        front=0;  // 默认就是0
//        real=0;
    }

    // 判断队列是否是满的
    public boolean isFull(){
        return (real+1)%maxSize==front;
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
        // 直接将数据加入
        arr[real]=n;
        //real 后移,需要考虑取模，防止数组越界
        real=(real+1)%maxSize;

    }

    // 获取队列的数据
    public int getQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            throw new RuntimeException("队列为空");
        }

        // 需要分析出front是指向队列的第一个元素
        // 1,先把front的对应的值保存在一个临时变量
        int value=arr[front];
        //2,front后移
        front=(front+1)%maxSize;
        // 3,将临时变量返回
        return  value;
    }

    // 展示所有数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        // 思路: 从front开始遍历，遍历多少个元素
        for (int i = front; i < front+size(); i++) {
            System.out.print(arr[i%maxSize]+" ");
        }
        System.out.println();
    }

    // 计算当前队列有效数据的个数
    public  int size(){
        return (real+maxSize-front)%maxSize;
    }

    //  显示队列的头数据，不是取出数据
    public int headQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            throw new RuntimeException("队列为空");
        }
        return arr[front];

    }



}




