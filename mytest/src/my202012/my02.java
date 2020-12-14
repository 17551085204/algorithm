/*
 * @Author hdk
 * @QQ:2890241339
 **/
package my202012;

/**
 * 完成自定义的一条链表
 * 1，添加节点到最后
 * 2，按大小添加节点
 * 3，显示链表信息
 * 4，删除链表中某一个节点
 * 5，获取链表长度
 * 6，打印链表第N个节点
 * 7，打印链表倒数第N个节点
 * 8，逆序打印链表内容
 * 9，将原链表翻转
 *
 */

public class my02 {
    public static void main(String[] args) {
        MyList myList = new MyList();
//        myList.add(1);
//        myList.add(22);
//        myList.add(3);
        myList.addByOrder(11);
        myList.addByOrder(2);
        myList.addByOrder(1);
        myList.addByOrder(7);
//        myList.delete(11);
        myList.show();
//        myList.print_N(4);
//        myList.reversePrint();

        //链表翻转
        myList.reverse();
        myList.show();



    }

}

//定义一条链表
class  MyList{
    Node head=new Node(0);

    // 链表翻转
    public void reverse(){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        if(head.next.next==null){ // 链表只有一个节点
            return;
        }

        //定义一个辅助的指针(变量)，帮助我们遍历原来的链表
        Node cur = head.next;
        Node next = null;// 指向当前节点[cur]的下一个节点
        Node reverseHead = new Node(0);
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端
        // 这个过程需要好好体会
        while(cur != null) {
            next = cur.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next = reverseHead.next;//将cur的下一个节点指向新的链表的最前端
            reverseHead.next = cur; //将cur 连接到新的链表上
            cur = next;//让cur后移
        }
        //将head.next 指向 reverseHead.next , 实现单链表的反转
        head.next = reverseHead.next;


    }


    // 逆序打印链表内容
    public void reversePrint(){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        int length=getLength();// 获取链表长度
        for (int i = length; i >=1; i--) {
            printN(i);
        }


    }


    // 打印链表倒数第N个节点
    public void print_N(int N){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        int length=getLength();
        if(N<=length) {
            Node temp = head;
            for (int i = 0; i < length-N+1; i++) {
                temp = temp.next;
            }
            System.out.println(temp);
        }else{
            System.out.println("链表长度小于"+N);
        }

    }



    // 打印链表第N个节点
    public void printN(int N){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        int length=getLength();
        if(N<=length) {
            Node temp = head;
            for (int i = 0; i < N; i++) {
                temp = temp.next;
            }
            System.out.print(temp+"-->");
        }else{
            System.out.println("链表长度小于"+N);
        }

    }


    // 获取链表长度
    public int getLength(){
        if(head.next==null){
            return 0;
        }
        int count=0;
        Node temp=head;
        while(temp.next!=null){
            count++;
            temp=temp.next;
        }
        return count;

    }



    // 删除某一节点
    public void delete(int val){
        if(head.next==null){
            System.out.println("链表为空，无法删除节点");
            return;
        }
        Node temp=head;
        while (temp.next!=null){
           if(temp.next.val==val){
               temp.next=temp.next.next;
               return;
           }
           temp=temp.next;
        }
        System.out.println("链表中没有该节点");

    }


    // 往链表中加入节点，按照大小顺序
    public void addByOrder(int val){
        Node addNode=new Node(val);
        if(head.next==null){// 如果往空链表添加数据
            head.next=addNode;
            return;
        }
        Node temp=head;
        while (temp!=null &&temp.next.val<val){
            temp=temp.next;
        }
        addNode.next=temp.next;
        temp.next=addNode;




    }


    //往链表中加入节点
    public void add(int val){
        Node addNode=new Node(val);
        if(head.next==null){// 如果往空链表添加数据
            head.next=addNode;
            return;
        }
        Node temp=head.next;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=addNode;


    }

    // 显示打印链表
    public void show(){
        if(head.next==null){
            System.out.println("空链表");
        }else{
            Node temp=head.next;
            while (temp.next!=null){
                System.out.print(temp+"-->");
                temp=temp.next;
            }
            System.out.print(temp+"-->");
        }
        System.out.println();

    }



}


// 定义节点类
class Node{
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}
