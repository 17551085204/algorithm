/*
@Author:南柯一梦
@Contact:2890241339@qq.com
@Date:2020/11/8
*/

package hashtab;
//import java.util.Scanner;

import java.util.HashMap;
import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {

       HashTab hashTab = new HashTab(7);

       //一个简单的菜单
        String k="";
       Scanner scanner = new Scanner(System.in);
       while (true){
           System.out.println("=====================================================");
           System.out.println("add:添加雇员");
           System.out.println("list:显示");
           System.out.println("exit:退出系统");
           System.out.println("find:查找雇员");
           System.out.println("del:删除雇员");
           k=scanner.next();
           switch (k){
               case "add":
                   System.out.println("输入id");
                   int id=scanner.nextInt();
                   System.out.println("输入name");
                   String name=scanner.next();
                   Emp emp=new Emp(id,name);
                   hashTab.add(emp);
                   break;
               case "find":
                   System.out.println("输入要查找的id");
                   id=scanner.nextInt();
                   hashTab.findEmpById(id);
                    break;
               case "del":
                   System.out.println("输入要删除雇员的id");
                   id=scanner.nextInt();
                   hashTab.delete(id);
                   break;

               case "list":
                   hashTab.list();
                   break;
               case "exit":
                   scanner.close();
                   System.exit(0);


                default:
                    break;
           }

       }


    }

}

//管理多条链表
class HashTab{
    EmpLinkedList[]empLinkedListArray;
    int size;// 表示有多少条链表
    public HashTab(int size) {
        this.size=size;
        // 初始化empLinkedListArray
        empLinkedListArray=new EmpLinkedList[size];
        // 需要对每一条链表逐一进行初始化
        for(int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //添加雇员
    public void add(Emp emp){
        // 根据员工的id,计算得到该员工应该加入哪一条链表
        int empLinkedListNO=hash(emp.id);
        // 将emp添加到对应的链表中
        empLinkedListArray[empLinkedListNO].add(emp);

    }
    // 遍历所有的链表
    public void list(){
        for (int i = 0; i <empLinkedListArray.length ; i++) {
            empLinkedListArray[i].list(i);
        }

    }

    // 根据id查找雇员信息
    public void findEmpById(int id){
        // 根据员工的id,计算得到该员工应该加入哪一条链表
        int empLinkedListNO=hash(id);
        // 将emp添加到对应的链表中
        Emp emp=empLinkedListArray[empLinkedListNO].findEmpById(id);
        if(emp==null){
            System.out.println("没有找到该雇员");
        }else{
            System.out.println("在第"+empLinkedListNO+"条链表中找到 "+emp);
        }

    }

    // 根据id删除雇员
    public void delete(int id){
        // 根据员工的id,计算得到该员工应该加入哪一条链表
        int empLinkedListNO=hash(id);
        empLinkedListArray[empLinkedListNO].delete(id);


    }


    // 散列函数
    public  int hash(int id){
        return id%size;
    }


}





// 表示链表
class EmpLinkedList{
    // 头指针，指向第一个emp，因此这个链表的head是直接指向第一个emp
    Emp head; // 默认为null

    // 添加雇员到链表,直接添加到最后
    public void add(Emp emp){
        // 如果是添加这条链表的第一个雇员
        if(head==null){
            head=emp;
            return;
        }
        Emp temp=head;//定义一个辅助指针
        while (true){
            if(temp.next==null){
                break;
            }
            temp=temp.next;
        }
        //直接将emp加入链表最后
        temp.next=emp;

    }

    // 遍历链表信息
    public void list(int no){
        if(head==null){
            System.out.println("第"+no+"条链表为空");
            return;
        }
        System.out.print("第"+no+"条链表的信息为:");
        Emp temp=head;
        while (true){
            System.out.print("  =>id="+temp.id+",name="+temp.name);
            if(temp.next==null){// 到了链表的最后
                break;
            }
            temp=temp.next;
        }
        System.out.println();


    }

    // 根据id查找雇员
    public Emp findEmpById(int id){
        if(head==null){
//            System.out.println("链表为空");
            return null;
        }
        // 辅助指针
        Emp temp=head;
        while (true){
            if(temp.id==id){// 找到
                break;
            }
            if(temp.next==null){// 遍历完当前链表，没找到
                temp=null;
                break;
            }
            temp=temp.next;
        }
        return  temp;

    }

    // 根据id删除某个雇员
    public void delete(int id){
        if(head==null){
            System.out.println("没有找到该雇员");
            return;
        }
        if(head.id==id){// 如果要删除的就是第一个节点
            head=head.next;
        }else{
            Emp temp=head; // 辅助指针,指向被删除节点的前一个节点
            while (true){
                if(temp.next!=null){
                    if(temp.next.id==id){
                        break;
                    }
                    temp=temp.next;
                }else{
                    System.out.println("没有找到该雇员");
                    return;
                }
            }
            // 出while循环后，删除节点
            temp.next=temp.next.next;

        }

    }





}





// 表示一个雇员
class Emp{
    int id;
    String name;
    Emp next;// 默认为null

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}



