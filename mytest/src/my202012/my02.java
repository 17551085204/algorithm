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
        myList.delete(11);
        myList.show();


    }

}

//定义一条链表
class  MyList{
    Node head=new Node(0);

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
            System.out.print(temp);
        }

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
