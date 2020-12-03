/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/4
*/

package linkedlist;
//import java.util.Scanner;

// 约瑟夫环问题  单向环形链表
/*
n=5,代表5个人
k=1,从第一个人开始报数
m=2，数2下
出队列的顺序
2,4,1,5,3

 */



public class Josepfu {
    public static void main(String[] args) {

        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.add(10);
//        circleSingleLinkedList.showBoy();

        circleSingleLinkedList.countBoy(1,4,10);

    }

}

// 创建环形单向链表
class CircleSingleLinkedList{
    // 创建first节点
    Boy first=new Boy(-1);

    // 根据输入，生成小孩出圈的顺序
    public void countBoy(int startNo,int countNum,int nums){
        if(first==null || startNo<1 || startNo>nums){
            System.out.println("参数输入有误");
            return;
        }
        Boy helper=first;
        while (true){
            if(helper.getNext()==first){
                break;
            }
            helper=helper.getNext();
        }// 循环结束后，helper指向最后一个小孩
        // 报数前，先要移动2个指针
        for (int i = 0; i <startNo-1 ; i++) {
            first=first.getNext();
            helper=helper.getNext();
        }
        // 报数，移动countNum-1次
        while (true){
            if(helper==first){// 只有1个小孩
                break;
            }
            // 让2个指针都移动
            for (int i = 0; i < countNum-1; i++) {
                first=first.getNext();
                helper=helper.getNext();
            }
            // first指向的节点就是要出圈的节点
            System.out.println(first.getNo());
            // 出圈
            first=first.getNext();
            helper.setNext(first);

        }
        System.out.println("最后留下的小孩编号"+helper.getNo());




    }



    // 添加boy节点,形成一个单向循环链表
    public void add(int nums){
        if(nums<1){
            System.out.println("出错！");
            return;
        }
        Boy curBoy=null;// 辅助指针，帮助构建环形链表
        // 创建环形链表
        for (int i = 1; i <=nums ; i++) {
            Boy boy=new Boy(i);
            // 第一个小孩
            if(i==1){
                first=boy;
                first.setNext(first);// 构成环
                curBoy=first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy=boy;
            }

        }

    }

    // 遍历当前环形链表
    public  void showBoy(){
        // 判断链表是否为空
        if(first==null){
            System.out.println("链表为空");
            return;
        }
        //first不可以动，需要辅助指针
        Boy curBoy=first;
        while (true){
            System.out.println("小孩编号"+curBoy.getNo());
            if(curBoy.getNext()==first){// 遍历完毕
                break;
            }
            curBoy=curBoy.getNext(); // 需要后移
        }


    }

}


// 定义节点
class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public Boy getNext() {
        return next;
    }
}

