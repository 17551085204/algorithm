/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/2
*/

package linkedlist;
//import java.util.Scanner;

/*
1，链表以节点进行存储，链式存储
2，每个节点包含data域和next,指向下一个节点
3，链表不是顺序存储
4，链表分有没有头结点

单向链表的实现，带有头结点
实现数据的增删查改操作

第一种添加方法，直接接入链表最后
第二种，考虑排名后，按照顺序添加数据

头结点，不放数据，只是为了表示单链表的头部



 */



//import java.time.chrono.HijrahEra;
import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {

//        HeroNode hero1=new HeroNode (1,"宋江","及时雨");
//        HeroNode hero2=new HeroNode (2,"卢俊义","玉麒麟");
//        HeroNode hero3=new HeroNode (3,"吴用","智多星");
//        HeroNode hero4=new HeroNode (4,"林冲","豹子头");
//
//        SingleLinkedList singleLinkedList = new SingleLinkedList();
//
//        // 添加，按照添加的顺序加入英雄
////        singleLinkedList.add(hero1);
////        singleLinkedList.add(hero4);
////        singleLinkedList.add(hero3);
////        singleLinkedList.add(hero2);
//        // 添加，按照影响的编号进行排序
//        singleLinkedList.addByOrder(hero1);
//        singleLinkedList.addByOrder(hero4);
//        singleLinkedList.addByOrder(hero3);
//        singleLinkedList.addByOrder(hero2);
//
//        // 对节点信息进行修改
//        singleLinkedList.update(new HeroNode(2,"小卢","玉麒麟~~"));
//
//        // 删除节点
//        singleLinkedList.deleteNode(4);
//        // 显示
//        singleLinkedList.list();
//
//        // 问题1，计算单链表的有效节点个数
//        System.out.println("有效节点个数为:"+getLen(singleLinkedList.getHead()));
//
//        // 问题2，查找,单链表倒数第k个节点
//        int k=2;
//        System.out.println("倒数第"+k+"个英雄为:"+findLastIndexNode(singleLinkedList.getHead(),k));
//
//        // 问题3，单链表的翻转
//        System.out.println("单链表的翻转");
//        reverseSingleLinkedList(singleLinkedList.getHead());
//        singleLinkedList.list();
//
//        // 问题4，从尾到头打印单链表
//        System.out.println("从尾到头打印单链表");
//        reversePrint(singleLinkedList.getHead());



        // 问题5.课后练习，将2个有序链表进行合并，使得合并后的链表也是有序的
        // 创建2个链表
        HeroNode hero11=new HeroNode (1,"宋江","及时雨");
        HeroNode hero12=new HeroNode (2,"卢俊义","玉麒麟");
        HeroNode hero13=new HeroNode (33,"mark","world");
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        singleLinkedList1.addByOrder(hero11);singleLinkedList1.addByOrder(hero12);singleLinkedList1.addByOrder(hero13);

        HeroNode hero21=new HeroNode (4,"吴用","智多星");
        HeroNode hero22=new HeroNode (5,"林冲","豹子头");
        HeroNode hero23=new HeroNode (66,"jack","hello");
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        singleLinkedList2.addByOrder(hero21);singleLinkedList2.addByOrder(hero22);singleLinkedList2.addByOrder(hero23);
        // 调用函数，将2个链表进行组合，得到新链表
        SingleLinkedList merge = merge(singleLinkedList1, singleLinkedList2);
        merge.list();


    }

    // 将2个链表进行组合
    public  static  SingleLinkedList merge(SingleLinkedList singleLinkedList1,SingleLinkedList singleLinkedList2){
        SingleLinkedList res=new SingleLinkedList();
        HeroNode head1=singleLinkedList1.getHead();
        HeroNode head2=singleLinkedList2.getHead();

        // 如果singleLinkedList1 或者singleLinkedList2 中有一个为null 那么直接返回另一个
        if(head1.next==null){
            return singleLinkedList2;
        }
        if(head2.next==null){
            return  singleLinkedList1;
        }
        //  先将singleLinkedList1所有节点按顺序挂到res后，然后将singleLinkedList2所有节点按顺序挂到res后
        HeroNode cur1=head1.next;
        HeroNode next1=cur1.next;
        while (cur1!=null){
            res.addByOrder(cur1);
            cur1=next1;
            if(next1!=null){
                next1=next1.next;
            }

        }

        HeroNode cur2=head2.next;
        HeroNode next2=cur2.next;
        while (cur2!=null){
            res.addByOrder(cur2);
            cur2=next2;
            if(next2!=null){
                next2=next2.next;
            }

        }

        return res;


    }






    // 获取单链表的节点的个数，不统计头节点
    public static int getLen(HeroNode head){
        if(head.next==null){
            return  0;
        }
        int len=0;
        // 定义一个辅助变量
        HeroNode cur=head.next;
        while (cur!=null){ // 不统计头结点
            len++;
            cur=cur.next;
        }
        return len;

    }

    // 查找倒数第k个节点
    // 将链表从头到尾遍历，得到链表的总的长度，从链表第一个开始遍历，遍历
    // size-index个就可以
    public  static  HeroNode findLastIndexNode(HeroNode head,int index){
        if(head.next==null){
            return null;
        }
        // 遍历得到节点的个数
        int size=getLen(head);
        // 第二次遍历 size-index,就是倒数第index个节点
        if(index<=0 || index>size){
            return null;
        }
        // 定义辅助变量
        HeroNode cur=head.next;
        for (int i = 0; i < size-index; i++) {
            cur=cur.next;
        }
        return cur;

    }


    // 单链表的翻转
    // 定义一个用于翻转的头结点，遍历原来的节点，没遍历一个节点，就
    // 将其取下，放在新链表的最前端
    public static void reverseSingleLinkedList(HeroNode head){
        // 如果链表为空或者只有一个节点，不需要翻转
        if(head.next==null ||head.next.next==null){
            return;
        }
        // 定义一个辅助指针
        HeroNode cur=head.next;
        HeroNode next=null; // 指向当前节点的下一个节点
        HeroNode reverseHead=new HeroNode(0,"","");
        // 遍历原来的链表，将节点取出，加入新链表
        while (cur!=null){
            next=cur.next;  // 暂时保存当前节点的下一个节点
            cur.next=reverseHead.next;// 将cur的下一个节点指向新链表的最前端
            reverseHead.next=cur;

            cur=next; // cur后移

        }
        head.next=reverseHead.next;


    }


    // 从尾到头打印链表
    // 思路1，将单链表翻转，然后打印，但是这样会破坏链表的结构
    //  思路2，利用栈
    public static void reversePrint(HeroNode head){
        if(head.next==null){
            return; // 空链表，无法打印
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur=head.next;
        //将链表的所有节点压入栈
        while (cur!=null){
            stack.push(cur);
            cur=cur.next;
        }
        // 将栈中的节点进行打印即可
        while (stack.size()>0){
            System.out.println(stack.pop());
        }


    }




}

//  管理英雄人物
class SingleLinkedList{
       // 初始化一个头结点，固定
    private  HeroNode head=new HeroNode(0,"","");

    public HeroNode getHead(){// 返回头结点
        return  head;
    }

    // 添加节点到单向链表
    public void add(HeroNode node){
        //  在链表的最后添加
        // 找到最后一个节点
        // 然后将最后一个节点指向要添加的节点
        HeroNode temp=head;
        // 遍历链表，找到最后
        while(true){
            if(temp.next==null){//代表到链表的最后
                break;
            }
            temp=temp.next; // 没找到，temp后移
        }
        // 退出循环时,temp到了链表的最后
        temp.next=node;

    }

    // 按照 英雄的编号的顺序添加
    /*1，找到新添加节点的位置,通过辅助指针
      2,新节点的next=temp.next
      3,temp.next=新节点
    */
    public  void addByOrder(HeroNode node){
        // 头结点不能动，需要一个辅助指针帮助找到添加的位置
        // 因为是单链表，所以temp位于添加位置的前一个节点
        HeroNode temp=head;
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
            temp.next=node;
        }


    }

    // 修改节点的信息,依据新节点的编号来修改
    public void update(HeroNode node){
        // 判断是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        // 根据no找到要修改的节点
        HeroNode temp=head.next;
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
    /*
    1,需要一个辅助指针，指向要删除节点的前一个节点
    2,temp.next=temp.next.next;
    3,被删除的节点会被垃圾回收机制回收

     */
    public void deleteNode(int no){
        HeroNode temp=head;
        boolean flag=false; // 标记是否找到待删除节点的前一个节点
        while (true){
            if(temp.next==null){
                break;// 到了最后
            }
            if(temp.next.no==no){
                flag=true; // 找到了temp就是待删除节点的前一个节点
                break;

            }
            temp=temp.next;
        }
        if(flag){
            temp.next=temp.next.next;
        }else{
            System.out.println("编号为"+no+"的节点不存在");
        }



    }

    // 显示链表
    public void list(){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }

        HeroNode temp=head.next;
        while(true){
            if(temp==null){//代表到链表的最后
                break;
            }
            System.out.println(temp);
            temp=temp.next; // temp后移

        }
    }


}







class HeroNode{

    int no;
    String name;
    String nickName;
    HeroNode next;

    public HeroNode(int no,String name,String nickName){
        this.no=no;
        this.name=name;
        this.nickName=nickName;
    }

    @Override
    public String toString() {
        return "HeroNode [no="+no+",name="+name+",nickname="+nickName+"]";
    }




}

