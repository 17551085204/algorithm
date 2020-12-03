/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/4
*/

package linkedlist;
//import java.util.Scanner;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        // 双向链表的测试
        HeroNode2 hero1=new HeroNode2 (1,"宋江","及时雨");
        HeroNode2 hero2=new HeroNode2 (2,"卢俊义","玉麒麟");
        HeroNode2 hero3=new HeroNode2 (3,"吴用","智多星");
        HeroNode2 hero4=new HeroNode2 (4,"林冲","豹子头");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        // 普通添加
//        doubleLinkedList.add(hero1);
//        doubleLinkedList.add(hero2);
//        doubleLinkedList.add(hero3);

        // 按照编号顺序加入
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.addByOrder(hero2);
        // 修改
        doubleLinkedList.update(new HeroNode2(2,"小卢","玉麒麟~~"));

        // 删除
//        doubleLinkedList.deleteNode(3);
        // 显示
        doubleLinkedList.list();



    }


}

class DoubleLinkedList{
    // 初始化一个头结点，固定
    private  HeroNode2 head=new HeroNode2(0,"","");

    public HeroNode2 getHead(){// 返回头结点
        return  head;
    }

    // 默认添加方式，添加到最后
    public void add(HeroNode2 node){
        //  在链表的最后添加
        // 找到最后一个节点
        // 然后将最后一个节点指向要添加的节点
        HeroNode2 temp=head;
        // 遍历链表，找到最后
        while(true){
            if(temp.next==null){//代表到链表的最后
                break;
            }
            temp=temp.next; // 没找到，temp后移
        }
        // 退出循环时,temp到了链表的最后
        temp.next=node;
        node.pre=temp;

    }

    // 按照顺序添加
    public  void addByOrder(HeroNode2 node){
        // 头结点不能动，需要一个辅助指针帮助找到添加的位置
        // temp位于添加位置的前一个节点
        HeroNode2 temp=head;
        boolean flag=false; // 标识添加的编号是否存在
        while (true){
            if (temp.next==null){// 链表的最后
                break;
            }
            if(temp.next.no>node.no){ // 找到了位置
                break;
            }else if(temp.next.no==node.no){// 编号已经存在
                flag=true; // 说明已经存在
                break;
            }
            temp=temp.next;
        }
        // 退出while循环时，判断flag的值
        if(flag){// 不能添加
            System.out.println("准备插入的英雄的编号"+node.no+"已经存在");
        }else{// 添加
            node.next=temp.next;
            if(node.next!=null){
                node.next.pre=node;
            }
            temp.next=node;
            node.pre=temp;

        }


    }



    // 修改节点内容
    public void update(HeroNode2 node){
        // 判断是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        // 根据no找到要修改的节点
        HeroNode2 temp=head.next;
        boolean flag=false; // 是否找到节点
        while (true){
            if(temp==null){
                break; // 链表已经遍历结束
            }
            if(temp.no==node.no){// 找到了
                flag=true;
                break;
            }
            temp=temp.next;
        }
        // 根据flag判断是否找到要修改的节点
        if(flag){
            temp.name=node.name;
            temp.nickName=node.nickName;

        }else{
            System.out.println("没有找到标号为"+node.no+"的节点");
        }


    }

    // 删除节点
    // 对于双向链表，可以自我删除
    public void deleteNode(int no){

        if(head.name==null){
            System.out.println("链表为空");
            return;
        }

        HeroNode2 temp=head.next; //就是要删除的节点
        boolean flag=false; // 标记是否找到待删除节点
        while (true){
            if(temp==null){
                break;// 到了最后
            }
            if(temp.no==no){
                flag=true; // 找到了temp就是待删除节点的前一个节点
                break;

            }
            temp=temp.next;
        }
        if(flag){// 如果找到，就可以删除
            temp.pre.next=temp.next;
            // 这里要处理，应对删除最后一个节点的情况
            if(temp.next!=null){
                temp.next.pre=temp.pre;
            }

        }else{
            System.out.println("编号为"+no+"的节点不存在");
        }



    }






    // 遍历双向链表
    public void list(){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }

        HeroNode2 temp=head.next;
        while(true){
            if(temp==null){//代表到链表的最后
                break;
            }
            System.out.println(temp);
            temp=temp.next; // temp后移

        }
    }




}



class HeroNode2{

    int no;
    String name;
    String nickName;
    HeroNode2 next; // 指向下一个节点
    HeroNode2 pre;  //  指向前一个节点

    public HeroNode2(int no,String name,String nickName){
        this.no=no;
        this.name=name;
        this.nickName=nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2 [no="+no+",name="+name+",nickname="+nickName+"]";
    }




}