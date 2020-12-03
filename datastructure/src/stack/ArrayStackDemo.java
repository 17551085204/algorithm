/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/4
*/

package stack;
//import java.util.Scanner;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {

//        ArrayStack arrayStack = new ArrayStack(5);
////        arrayStack.push(1);
////        arrayStack.push(2);
////        arrayStack.push(3);
////        arrayStack.push(4);
////        arrayStack.push(5);
////        arrayStack.push(6);
////        arrayStack.list();
//
//        String k="";
//        boolean loop=true;
//        Scanner scanner = new Scanner(System.in);
//        while (loop){
//            System.out.println("show：显示栈");
//            System.out.println("exit：退出");
//            System.out.println("push：入栈");
//            System.out.println("pop：出栈");
//            k=scanner.next();
//            switch (k){
//                case "show":
//                    arrayStack.list();
//                    break;
//                case "push":
//                    System.out.println("输入一个数字");
//                    int value=scanner.nextInt();
//                    arrayStack.push(value);
//                    break;
//                case "pop":
//                    try{
//                        int res=arrayStack.pop();
//                        System.out.println("出栈的数据为"+res);
//                    }catch (Exception e){
//                        System.out.println(e.getMessage());
//                    }
//                    break;
//                case "exit":
//                    scanner.close();
//                    loop=false;
//                    break;
//                default:
//                    break;
//
//            }
//
//
//        }
//        System.out.println("结束");


        // 测试使用链表模拟栈
        LinkedListStack linkedListStack = new LinkedListStack();
        linkedListStack.push(1);linkedListStack.push(2);linkedListStack.push(3);
        linkedListStack.list();
        System.out.println("pop弹出一个数"+linkedListStack.pop());
        linkedListStack.list();
        System.out.println("pop弹出一个数"+linkedListStack.pop());
        linkedListStack.list();
        System.out.println("pop弹出一个数"+linkedListStack.pop());
        linkedListStack.list();
//        System.out.println("pop弹出一个数"+linkedListStack.pop());
//        linkedListStack.list();

    }

}


// 使用链表模拟栈
class LinkedListStack{
    // 初始化一个头结点，固定
    private  Node head=new Node(-1);

    public Node getHead() {
        return head;
    }

    // 添加节点到单向链表,完成push功能
    public void push(int value){
        // head 就是要添加节点的前一个节点
        Node node=new Node(value); // 要加入的节点
        // 压栈操作
        node.next=head.next;
        head.next=node;


    }

    // 完成pop功能
    public  int pop(){
        int value;
        if(head.next!=null){
            value=head.next.value;
            head.next=head.next.next;
        }else{
            System.out.println("栈为空");
            throw new RuntimeException("栈为空");
        }

        return value;

    }



    // 显示链表
    public void list(){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }

        Node temp=head.next;
        while(true){
            if(temp==null){//代表到链表的最后
                break;
            }
            System.out.println(temp);
            temp=temp.next; // temp后移

        }
    }




}


class Node{
    int value;
    Node next;
    public Node(int value){
        this.value=value;
    }

    @Override
    public String toString() {
        return "Node{" + "value=" + value + '}';
    }

}





// 使用数组模拟栈
class ArrayStack{
    private  int maxSize; // 栈的大小
    private  int [] stack;
    private  int top=-1; // 指向栈顶

    public ArrayStack(int maxSize){
        this.maxSize=maxSize;
        stack=new int[maxSize];
    }
    // 栈满
    public boolean isFull(){
        return top==maxSize-1;
    }
    // 栈空
    public boolean isEmpty(){
        return top==-1;
    }
    // 入栈
    public void push(int value){
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top]=value;

    }
    // 出栈
    public int pop(){
        if(isEmpty()){
            System.out.println("栈为空");
            throw new RuntimeException("栈为空");
        }
        int value=stack[top];
        top--;
        return value;

    }
    // 遍历栈,要从栈顶开始显示数据
    public  void list(){
        if(isEmpty()){
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >=0 ; i--) {
            System.out.println(stack[i]);
        }
    }





}

